package com.sk4atg89.alexander.soccer.presentation.season.detail;


import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;

import io.reactivex.functions.Action;

public class SeasonDetailViewModel {

    private String caption;
    private String league;
    private String year;
    private int currentMatchday;
    private int numberOfMatchdays;
    private int numberOfTeams;
    private int numberOfGames;
    private long eventTime;
    private Action refresh;
    private Action details;


    public SeasonDetailViewModel(SeasonEntity seasonEntity, SeasonDetailContract.EventListener eventListener) {
        caption = seasonEntity.getCaption();
        league = seasonEntity.getLeague();
        year = seasonEntity.getYear();
        currentMatchday = seasonEntity.getCurrentMatchday();
        numberOfMatchdays = seasonEntity.getNumberOfMatchdays();
        numberOfTeams = seasonEntity.getNumberOfTeams();
        numberOfGames = seasonEntity.getNumberOfGames();
        eventTime = seasonEntity.getEventTime();
        details = () -> eventListener.details(seasonEntity.getId());
        refresh = () -> eventListener.refresh(seasonEntity.getId());
    }



    public String getCaption() {
        return caption;
    }

    public String getLeague() {
        return league;
    }

    public String getYear() {
        return year;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public int getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public long getEventTime() {
        return eventTime;
    }

    public Action getRefresh() {
        return refresh;
    }

    public Action getDetails() {
        return details;
    }
}
