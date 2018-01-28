package com.sk4atg89.alexander.soccer.data.network.dto;


import com.google.gson.annotations.SerializedName;

public class SoccerSeasonsDTO {

    @SerializedName("id")
    public int id;
    @SerializedName("caption")
    public String caption;
    @SerializedName("league")
    public String league;
    @SerializedName("year")
    public String year;
    @SerializedName("currentMatchday")
    public int currentMatchday;
    @SerializedName("numberOfMatchdays")
    public int numberOfMatchdays;
    @SerializedName("numberOfTeams")
    public int numberOfTeams;
    @SerializedName("numberOfGames")
    public int numberOfGames;
    @SerializedName("lastUpdated")
    public String lastUpdated;

}
