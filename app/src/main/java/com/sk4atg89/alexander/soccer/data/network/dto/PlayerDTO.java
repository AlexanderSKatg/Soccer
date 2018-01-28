package com.sk4atg89.alexander.soccer.data.network.dto;

import com.google.gson.annotations.SerializedName;

public class PlayerDTO {

    @SerializedName("name")
    public String name;
    @SerializedName("position")
    public String position;
    @SerializedName("jerseyNumber")
    public int jerseyNumber;
    @SerializedName("dateOfBirth")
    public String dateOfBirth;
    @SerializedName("nationality")
    public String nationality;
    @SerializedName("contractUntil")
    public String contractUntil;
    @SerializedName("marketValue")
    public Object marketValue;


}
