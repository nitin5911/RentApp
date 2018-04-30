package com.example.chetanp.rentitapp.Pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chetan P on 26-02-2018.
 */

public class ForgotPojo {
    @SerializedName("mobileNo")
    private String mobileNo;

    public ForgotPojo(String mobileNo, Integer status) {
        this.mobileNo = mobileNo;
        this.status = status;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @SerializedName("status")

    private Integer status;
}
