package com.example.chetanp.rentitapp.Pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chetan P on 26-02-2018.
 */

public class ResetPojo {
    @SerializedName("newPassword")
    private String newPassword;

    public ResetPojo(String newPassword, Integer status) {
        this.newPassword = newPassword;
        this.status = status;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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
