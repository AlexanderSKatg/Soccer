package com.sk4atg89.alexander.soccer.data.network.dto;

import com.google.gson.annotations.SerializedName;

public class HomeAwayDTO {

    @SerializedName("goals")
    public int goals;
    @SerializedName("goalsAgainst")
    public int goalsAgainst;
    @SerializedName("wins")
    public int wins;
    @SerializedName("draws")
    public int draws;
    @SerializedName("losses")
    public int losses;

}
