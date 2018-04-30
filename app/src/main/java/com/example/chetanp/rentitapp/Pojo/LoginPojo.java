package com.example.chetanp.rentitapp.Pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chetan P on 23-02-2018.
 */

public class LoginPojo {

    @SerializedName("userName")
    private String UName;
    @SerializedName("userPassword")
    private String UPassword;

    public LoginPojo(String name, String password){
        this.UName=name;
        this.UPassword=password;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUPassword() {
        return UPassword;
    }

    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }
}
