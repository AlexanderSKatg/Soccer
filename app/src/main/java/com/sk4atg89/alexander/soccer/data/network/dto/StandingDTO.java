package com.sk4atg89.alexander.soccer.data.network.dto;


import com.google.gson.annotations.SerializedName;

public class StandingDTO {

    @SerializedName("_links")
    public LinkDTO linkDTO;
    @SerializedName("position")
    public int position;
    @SerializedName("teamName")
    public String teamName;
    @SerializedName("crestURI")
    public String crestURI;
    @SerializedName("playedGames")
    public int playedGames;
    @SerializedName("points")
    public int points;
    @SerializedName("goals")
    public int goals;
    @SerializedName("goalsAgainst")
    public int goalsAgainst;
    @SerializedName("goalDifference")
    public int goalDifference;
    @SerializedName("wins")
    public int wins;
    @SerializedName("draws")
    public int draws;
    @SerializedName("losses")
    public int losses;
    @SerializedName("home")
    public HomeAwayDTO home;
    @SerializedName("away")
    public HomeAwayDTO away;

}
