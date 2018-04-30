package com.example.chetanp.rentitapp;

import com.google.android.gms.maps.model.LatLng;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Amit on 19-12-2017.
 */

public interface RetrofitintrfcFile {

    @GET("geocode/json")
    Call<GetAddressMapPOJO1> mapAddrsShow_method(@Query("latlng") LatLng latlng,
                                                 @Query("sensor") boolean value);

}//end of interface file
