package com.sk4atg89.alexander.soccer.domain.common.model;

public class ChampionLeagueStandingEntity {

    private String group;
    private int rank;
    private String team;
    private int teamId;
    private int playedGames;
    private String crestURI;
    private int points;
    private int goals;
    private int goalsAgainst;
    private int goalDifference;

    public ChampionLeagueStandingEntity(String group,
                                        int rank,
                                        String team,
                                        int teamId,
                                        int playedGames,
                                        String crestURI,
                                        int points,
                                        int goals,
                                        int goalsAgainst,
                                        int goalDifference) {
        this.group = group;
        this.rank = rank;
        this.team = team;
        this.teamId = teamId;
        this.playedGames = playedGames;
        this.crestURI = crestURI;
        this.points = points;
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
    }

    public String getGroup() {
        return group;
    }

    public int getRank() {
        return rank;
    }

    public String getTeam() {
        return team;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public int getPoints() {
        return points;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }
}
