package com.example.chetanp.rentitapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Amit on 19-12-2017.
 */

public class RetrofitInstancefile {

    public static final String map_base_url="http://maps.googleapis.com/maps/api/";
    public static Retrofit map_retrofit_obj=null;

    public static Retrofit map_retrofit_method(){
        if(map_retrofit_obj==null){
            map_retrofit_obj= new Retrofit.Builder().baseUrl(map_base_url).addConverterFactory(GsonConverterFactory.create()).build();
        }//end of if
        return map_retrofit_obj;
    }//end of method

}//end of Retrofit instance file
