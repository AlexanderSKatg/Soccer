package com.sk4atg89.alexander.soccer.data.network;

import com.sk4atg89.alexander.soccer.data.network.dto.LeagueTableDTO;
import com.sk4atg89.alexander.soccer.data.network.dto.SoccerSeasonsDTO;
import com.sk4atg89.alexander.soccer.data.network.dto.TeamDTO;
import com.sk4atg89.alexander.soccer.data.network.dto.TeamPlayersDTO;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SoccerApi {

    @GET("soccerseasons")
    Single<List<SoccerSeasonsDTO>> getSeasons();

    @GET("competitions/{id}/leagueTable")
    Single<LeagueTableDTO> getTable(@Path("id") int id);

    @GET("competitions/{id}")
    Single<SoccerSeasonsDTO> getSeasonDetail(@Path("id") int id);

    @GET("teams/{id}")
    Single<TeamDTO> getTeams(@Path("id") int id);

    @GET("teams/{id}/players")
    Single<TeamPlayersDTO> getPlayers(@Path("id") int id);

}
