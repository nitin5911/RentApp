package com.example.chetanp.rentitapp.UserInterface;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.chetanp.rentitapp.BasicComponentsReuse;
import com.example.chetanp.rentitapp.R;
import com.example.chetanp.rentitapp.RetrofitInstancefile;
import com.example.chetanp.rentitapp.RetrofitintrfcFile;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetUserLocationMap extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener,GoogleMap.OnCameraIdleListener,GoogleMap.OnMyLocationButtonClickListener {
    @BindView(R.id.pickbackarrowid)ImageView backarrow_obj;
    @BindView(R.id.mapconfirmpickupid)Button confmbtn_obj;
    BasicComponentsReuse basicComponentsReuse_obj = null;
    Marker marker_obj;
    MarkerOptions addmarker_obj;
    Place place_obj;
    GoogleApiClient mGoogleApiClient_obj;
    GoogleMap mGoogleMap_obj;
    UiSettings uisettings_obj;
    LocationManager locationManager_obj;
    static final int REQUEST_LOCATION = 1;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    double destlat, destlng;
    String str_mylocation = "mohali 7 phase",confirmApi_address;
    LocationRequest mLocationRequest;
    PlaceAutocompleteFragment autocompleteFragment;
    RetrofitintrfcFile retrofitinterfacefile;
    LatLng centerlatLng;
    // private GoogleMap.OnCameraIdleListener onCameraIdleListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_user_location_map);
        basicComponentsReuse_obj = new BasicComponentsReuse();
        ButterKnife.bind(this);
        //Retrofit work
        retrofitinterfacefile = RetrofitInstancefile.map_retrofit_method().create(RetrofitintrfcFile.class);
        //Google API client work
        buildGoogleApiClient();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.itemdetailsmapid);
        mapFragment.getMapAsync(this);
    }//end of onCreate method

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap_obj = googleMap;
        mGoogleMap_obj.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        uisettings_obj = mGoogleMap_obj.getUiSettings();
        uisettings_obj.setZoomControlsEnabled(true);
        uisettings_obj.setAllGesturesEnabled(true);
        uisettings_obj.setCompassEnabled(true);
        uisettings_obj.setMapToolbarEnabled(false);
        uisettings_obj.setMyLocationButtonEnabled(true);
        uisettings_obj.isCompassEnabled();
        uisettings_obj.setIndoorLevelPickerEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED)
            checkLocationPermission();
        else {
            mGoogleMap_obj.setMyLocationEnabled(true);
            //Google API client work
        //    buildGoogleApiClient();
            //get Location lat lng from address
            try {
                getLocationFromAddress(str_mylocation);
            } catch (IOException e) {
                e.printStackTrace();
            }//end of try catch
            //get Auto Results for location search
            autoSearchLocation_method();
            //draggable google map work
            mGoogleMap_obj.setOnCameraIdleListener(this);
            mGoogleMap_obj.setOnMyLocationButtonClickListener(this);
        }//end of else condition
    }//end of onMapReady method

    //  Here give the permission to access the map location
    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED){
            // Should we show an explanation
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)&& ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                new AlertDialog.Builder(this)
                        .setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(SetUserLocationMap.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                                ActivityCompat.requestPermissions(SetUserLocationMap.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        }).create().show();
            } else
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }//end of checkLocationPermission method

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient_obj = new GoogleApiClient.Builder(this).addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).build();
        mGoogleApiClient_obj.connect();
    }//end of buildGoogleApiClient method

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(10000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient_obj, mLocationRequest, this);
        }
    }//end of onConnected method
    @Override
    public void onConnectionSuspended(int i) {
    }//end of onConnectionSuspended
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }//end of onConnectionFailed method

    @Override
    public boolean onMyLocationButtonClick() {
        locationSettingOpen_method();
        return false;
    }//end of onMyLocationButtonClick method

    private void locationSettingOpen_method() {
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true); //this is the key ingredient
        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient_obj, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                final LocationSettingsStates state = result.getLocationSettingsStates();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            status.startResolutionForResult(SetUserLocationMap.this, 1000);
                        } catch (IntentSender.SendIntentException e) {
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        break;
                }//end of switch case
            }//end of onResult method
        }); //end of callback work
    }//end of location Setting Open method

    public void getLocationFromAddress(String userdestaddr) throws IOException {
        Geocoder coder = new Geocoder(SetUserLocationMap.this, Locale.getDefault());
        List<Address> destlist_obj=coder.getFromLocationName(userdestaddr, 5);
        if(destlist_obj.size()>0){
            destlat= destlist_obj.get(0).getLatitude();
            destlng= destlist_obj.get(0).getLongitude();
            //Move camera on Already Selected location
            mGoogleMap_obj.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(destlat, destlng)));
            mGoogleMap_obj.animateCamera(CameraUpdateFactory.zoomTo(15));
        }//end of inner if condition
    }//end of method

    private void autoSearchLocation_method() {
        //AutoComplete location text search box work
        autocompleteFragment =(PlaceAutocompleteFragment)getFragmentManager().findFragmentById(R.id.searchautocompltid);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place placeobj) {
                place_obj=placeobj;
                if (marker_obj != null)
                    marker_obj.remove();
                //Move camera on Searched location
                mGoogleMap_obj.moveCamera(CameraUpdateFactory.newLatLng(place_obj.getLatLng()));
                mGoogleMap_obj.animateCamera(CameraUpdateFactory.zoomTo(15));
            }//end of onPlaceSelected method
            @Override
            public void onError(Status status) {
                autocompleteFragment.setText("Loading Failed..! Check Internet Connection");
            }//end of onError method
        }); //end of auto completed work
    }//end of autoSearch Location method

    @Override
    public void onLocationChanged(Location location) {
        mGoogleApiClient_obj.connect();
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient_obj, mLocationRequest, this);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mGoogleMap_obj.setMyLocationEnabled(true);
    }//end of onLocationChanged method

    @Override
    public void onPause() {
        super.onPause();
        //stop location updates when Activity is no longer active
        if (mGoogleApiClient_obj != null)
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient_obj, this);
    }//end of onPause method

    @Override
    protected void onResume() {
        super.onResume();
        if (mGoogleApiClient_obj != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }//end of inner if condition
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient_obj, mLocationRequest, this);
        }//end of if condition
    }//end of onResume method

    @OnClick({R.id.pickbackarrowid, R.id.mapconfirmpickupid})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pickbackarrowid:
                Intent setloc_intent = new Intent(SetUserLocationMap.this, CategoryItems.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(SetUserLocationMap.this,setloc_intent);
                break;
            case R.id.mapconfirmpickupid:
                Intent confmloc_intent = new Intent(SetUserLocationMap.this, CategoryItems.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(SetUserLocationMap.this,confmloc_intent);
                break;
        }//end of switch
    }//end of on click method

    @Override
    public void onCameraIdle() {
        centerlatLng = mGoogleMap_obj.getProjection().getVisibleRegion().latLngBounds.getCenter();
        try {
            getAddressFromgivenLocation(centerlatLng);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of onCaneraIdle method

    public void getAddressFromgivenLocation(LatLng latLng_obj) throws IOException {
        String confirm_knownName=" ";
        autocompleteFragment.setText("Loading...");
        Geocoder coder = new Geocoder(SetUserLocationMap.this, Locale.getDefault());
        List<Address> addrsDataList_obj;
        addrsDataList_obj=coder.getFromLocation(latLng_obj.latitude,latLng_obj.longitude,1);
        if(addrsDataList_obj.size()>0){
            confirm_knownName=addrsDataList_obj.get(0).getAddressLine(0);
            autocompleteFragment.setText(confirm_knownName);
        }else autocompleteFragment.setText("Searching Failed..! Try Again");
    }//end of get Address from Location method
}//end of main class