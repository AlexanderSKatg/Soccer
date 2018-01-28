package com.sk4atg89.alexander.soccer.data.network.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamPlayersDTO {

    @SerializedName("count")
    public int count;
    @SerializedName("players")
    public List<PlayerDTO> players;

}
