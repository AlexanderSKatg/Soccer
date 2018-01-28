package com.sk4atg89.alexander.soccer.data.network.dto;


import com.google.gson.annotations.SerializedName;

public class ChampionLeagueStandingDTO {

    @SerializedName("group")
    public String group;
    @SerializedName("rank")
    public int rank;
    @SerializedName("team")
    public String team;
    @SerializedName("teamId")
    public int teamId;
    @SerializedName("playedGames")
    public int playedGames;
    @SerializedName("crestURI")
    public String crestURI;
    @SerializedName("points")
    public int points;
    @SerializedName("goals")
    public int goals;
    @SerializedName("goalsAgainst")
    public int goalsAgainst;
    @SerializedName("goalDifference")
    public int goalDifference;

}
