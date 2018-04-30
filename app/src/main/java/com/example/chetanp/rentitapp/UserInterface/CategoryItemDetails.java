
package com.example.chetanp.rentitapp.UserInterface;

import android.graphics.Color;
import android.graphics.Matrix;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chetanp.rentitapp.Adapter.SlideAdapter;
import com.example.chetanp.rentitapp.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryItemDetails extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{
    private static ViewPager viewPager;
    private static int currentpage=0;
    private int i=0;
    private static final Integer [] Xmen={R.drawable.sport_bike,R.drawable.ferrari,R.drawable.sport_bike,R.drawable.sport_bike};
    private ArrayList<Integer>XmenArray=new ArrayList<>();
    @BindViews({R.id.daTitleTxt,R.id.daDescriptionTxt,R.id.daOwnerNoteText,R.id.daCategoryTxt,
                R.id.daMbDaysTxt,R.id.daConditionTxt,R.id.daPricePDayTxt,R.id.daCOwnerTxt,R.id.daOListingTxt})List<TextView>text_view;
    @BindViews({R.id.daACartBtn,R.id.daAFavouriteBtn,R.id.daRentNowBtn})List<Button>btn_obj;
    @BindViews({R.id.daOwnerImage})List<ImageView>detailImage;
    @BindView(R.id.daViewPager)ViewPager myPager;
//    @BindView(R.id.daCircleIndicator)CircleIndicator circleIndicator;
    GoogleApiClient mGoogleApiClient_obj;
    GoogleMap mGoogleMap_obj;
    UiSettings uisettings_obj;
    public  static final int REQUEST_LOCATION=1;
    double destlat,destlng;
    String owneraddress="7 phase mohali";
    int catItemscardpos;
    private TextView[] dots;
    private LinearLayout ll_dots;
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryitemdetails);
        ButterKnife.bind(this);
        ll_dots =findViewById(R.id.ll_dots);
        addImages();
        init();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.itemdetailsmapid);
        mapFragment.getMapAsync(this);
        catItemscardpos=getIntent().getIntExtra("catItemposition",-1);
        if(catItemscardpos!=-1) {
            Toast.makeText(this, "Category Item Position selected is " + catItemscardpos, Toast.LENGTH_SHORT).show();
           // CategoryItemsDeatilsData_method();
        }
    }//end of onCreate method

    private void addImages() {
        for (i=0;i<Xmen.length;i++) {
            XmenArray.add(Xmen[i]);
        }
    }//end of add images

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap_obj = googleMap;
        mGoogleMap_obj.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //Google map UI setting work
        uisettings_obj = mGoogleMap_obj.getUiSettings();
        uisettings_obj.setZoomControlsEnabled(true);
        uisettings_obj.setAllGesturesEnabled(true);
        uisettings_obj.setMapToolbarEnabled(true);
        //Google API client work
        buildGoogleApiClient();
        //get Location lat lng from address
        try {
            getLocationFromAddress(owneraddress);
        } catch (IOException e) {
            e.printStackTrace();
        }//end of try catch
    }//end of onMapReady method

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient_obj = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient_obj.connect();
    }//end of buildGoogleApiClient method

    public void getLocationFromAddress(String userdestaddr) throws IOException {
        Geocoder coder = new Geocoder(CategoryItemDetails.this, Locale.getDefault());
        List<Address> destlist_obj;
        destlist_obj=coder.getFromLocationName(userdestaddr, 5);
        Toast.makeText(getApplicationContext(), "destlist is null", Toast.LENGTH_SHORT).show();
        if(destlist_obj.size()>0){
            destlat= destlist_obj.get(0).getLatitude();
            destlng= destlist_obj.get(0).getLongitude();
            Toast.makeText(getApplicationContext(), "Owner lat lng "+destlat+" , "+destlng, Toast.LENGTH_SHORT).show();
            //marker options work
            markeroperations_method();
        }//end of inner if condition
    }//end of method

    public void markeroperations_method() {
        //Marker options initialize
        MarkerOptions destmarkerOption_obj = new MarkerOptions();
        //marker icon set
        destmarkerOption_obj.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        //Add markers
        mGoogleMap_obj.addMarker(destmarkerOption_obj.position(new LatLng(destlat, destlng)).title("owner").snippet("location"));
        //Move camera on origin location
        mGoogleMap_obj.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(destlat, destlng)));
        mGoogleMap_obj.animateCamera(CameraUpdateFactory.zoomTo(12));
    }//end of marker operations method

    @Override
    public void onConnected(@Nullable Bundle bundle) {
    }//end of onConnected method
    @Override
    public void onConnectionSuspended(int i) {
    }//end of onConnectionSuspended
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }//end of onConnectionFailed method

    private void init() {
        // method for adding indicators
        addBottomDots(0);
        myPager.setAdapter(new SlideAdapter(CategoryItemDetails.this,XmenArray));
        myPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }//end of onPageScrolled method
            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }//end of onPageSelected method
            @Override
            public void onPageScrollStateChanged(int state) {
            }//end of scrollstatechanged method
        });  //end of listener part

//            circleIndicator.setViewPager(myPager);
////        final Handler handler=new Handler();
////        final Runnable update=new Runnable() {
////                @Override
////                public void run() {
////                    if(currentpage == Xmen.length){
////                        currentpage=0;
////                    }
////                   myPager.setCurrentItem(currentpage ++,true);
////                }
////            };//end of runable thread
////            final Timer swipeTime=new Timer();
////            swipeTime.schedule(new TimerTask() {
////                @Override
////                public void run() {
////                    handler.post(update);
////                }
////            }, 2500,2500);//end of timer
//            circleIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//                @Override
//                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                }
//                @Override
//                public void onPageSelected(int position) {
//                    currentpage=position;
//                }
//                @Override
//                public void onPageScrollStateChanged(int state) {
//                }
//            });//end of page change listner
    }//end of init

    private void addBottomDots(int currentPage) {
        dots = new TextView[XmenArray.size()];
        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#000000"));
            ll_dots.addView(dots[i]);
        }//end of for loop
        if (dots.length >= 0)
            dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
    }//end of addBottomDots method

    @OnClick({R.id.daACartBtn,R.id.daAFavouriteBtn,R.id.daRentNowBtn,R.id.daViewPager})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.daACartBtn:
                Toast.makeText(this,"Button Pressed",Toast.LENGTH_SHORT).show();
                break;
            case R.id.daAFavouriteBtn:
                Toast.makeText(this,"Button Pressed",Toast.LENGTH_SHORT).show();
                break;
            case R.id.daRentNowBtn:
                Toast.makeText(this,"Button Pressed",Toast.LENGTH_SHORT).show();
                break;
            case R.id.daViewPager:
                break;
        }//end of switch
    }//end of on click
}//end of class