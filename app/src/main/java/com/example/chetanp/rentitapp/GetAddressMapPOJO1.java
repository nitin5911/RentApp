package com.example.chetanp.rentitapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amit on 27-02-2018.
 */

public class GetAddressMapPOJO1 {
    @SerializedName("formatted_address")
    @Expose
    private String formattedAddress;

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
}//end of POJO1
