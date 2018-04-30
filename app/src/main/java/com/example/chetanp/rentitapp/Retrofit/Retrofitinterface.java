package com.example.chetanp.rentitapp.Retrofit;

import com.example.chetanp.rentitapp.Pojo.ForgotPojo;
import com.example.chetanp.rentitapp.Pojo.LoginPojo;
import com.example.chetanp.rentitapp.Pojo.ResetPojo;
import com.example.chetanp.rentitapp.Pojo.SignUpPojo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Chetan P on 26-02-2018.
 */

public interface Retrofitinterface {
    @GET("login")
    Call<LoginPojo> loginInterface_method(@Query("userName") String userName,@Query("userPassword") String userPassword);

    @GET("signup")
    Call<SignUpPojo> signUpInterface_method(@Query("userFname") String userFname, @Query("userLname") String userLname,
                                            @Query("userEmail") String userEmail,@Query("userPassword") String userPassword);

    @GET("forgot")
    Call<ForgotPojo> forgotInterfae_method(@Query("mobileNumber") String mobileNumber);

    @GET("Reset")
    Call<ResetPojo> resetInterface_method(@Query("newPassword") String newPassword);

    @GET("api.php")
    Call<ResponseBody> otpsendintfc_method(@Query("username") String username,
                                           @Query("password") String password,
                                           @Query("sender") String sender,
                                           @Query("sendto") String sendto,
                                           @Query("message") String message);

}//end of interface file
