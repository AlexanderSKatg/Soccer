package com.sk4atg89.alexander.soccer.data.network.dto;

import com.google.gson.annotations.SerializedName;

public class TeamDTO {

    @SerializedName("name")
    public String name;
    @SerializedName("code")
    public String code;
    @SerializedName("shortName")
    public String shortName;
    @SerializedName("squadMarketValue")
    public Object squadMarketValue;
    @SerializedName("crestUrl")
    public String crestUrl;

}
