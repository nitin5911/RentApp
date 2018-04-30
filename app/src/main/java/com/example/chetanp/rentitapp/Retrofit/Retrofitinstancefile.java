package com.example.chetanp.rentitapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chetan P on 26-02-2018.
 */

public class Retrofitinstancefile {
    public static final String base_url="";
    public static Retrofit retrofit_obj=null;
    //OTP url
    public static final String otp_base_url="http://sms.thinkbuyget.com/";
    public static Retrofit otp_retrofit_obj=null;

    public static Retrofit retrofit_method(){
       if (retrofit_obj==null){
           retrofit_obj=new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
       }//end of if
       return retrofit_obj;
   } //end of retrofit method

    //Retrofit method for OTP
    public static Retrofit otp_retrofit_method(){
        if(otp_retrofit_obj==null){
            otp_retrofit_obj= new Retrofit.Builder().baseUrl(otp_base_url).addConverterFactory(GsonConverterFactory.create()).build();
        }//end of if
        return otp_retrofit_obj;
    }//end of method

}//end of instance
