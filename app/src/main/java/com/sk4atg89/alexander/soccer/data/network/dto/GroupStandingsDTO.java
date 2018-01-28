package com.sk4atg89.alexander.soccer.data.network.dto;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupStandingsDTO {

    @SerializedName("A")
    public List<ChampionLeagueStandingDTO> a;
    @SerializedName("B")
    public List<ChampionLeagueStandingDTO> b;
    @SerializedName("C")
    public List<ChampionLeagueStandingDTO> c;
    @SerializedName("D")
    public List<ChampionLeagueStandingDTO> d;
    @SerializedName("E")
    public List<ChampionLeagueStandingDTO> e;
    @SerializedName("F")
    public List<ChampionLeagueStandingDTO> f;
    @SerializedName("G")
    public List<ChampionLeagueStandingDTO> g;
    @SerializedName("H")
    public List<ChampionLeagueStandingDTO> h;

}
