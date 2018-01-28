package com.sk4atg89.alexander.soccer.data.network.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChampionLeagueTableDTO {

    @SerializedName("leagueCaption")
    public String leagueCaption;

    @SerializedName("matchday")
    public int matchday;

    @SerializedName("standing")
    public List<StandingDTO> standing;

//    @SerializedName("standings")
//    public List<ChampionLeagueStandingDTO> standings;
}
