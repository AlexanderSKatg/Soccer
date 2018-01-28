package com.sk4atg89.alexander.soccer.domain.common.model;


import android.os.Parcel;
import android.os.Parcelable;

public class StandingEntity implements Parcelable {

    private int id;
    private int position;
    private String teamName;
    private String crestURI;
    private int playedGames;
    private int points;
    private int goals;
    private int goalsAgainst;
    private int goalDifference;
    private int wins;
    private int draws;
    private int losses;
    private HomeAwayEntity homeGames;
    private HomeAwayEntity awayGames;

    public StandingEntity(String urlWithId,
                          int position,
                          String teamName,
                          String crestURI,
                          int playedGames,
                          int points,
                          int goals,
                          int goalsAgainst,
                          int goalDifference,
                          int wins,
                          int draws,
                          int losses,
                          HomeAwayEntity homeGames,
                          HomeAwayEntity awayGames) {
        this.id = Integer.valueOf(urlWithId
                .replaceAll("http://api.football-data.org/v1/teams/", ""));
        this.position = position;
        this.teamName = teamName;
        this.crestURI = crestURI;
        this.playedGames = playedGames;
        this.points = points;
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.homeGames = homeGames;
        this.awayGames = awayGames;
    }

    protected StandingEntity(Parcel in) {
        id = in.readInt();
        position = in.readInt();
        teamName = in.readString();
        crestURI = in.readString();
        playedGames = in.readInt();
        points = in.readInt();
        goals = in.readInt();
        goalsAgainst = in.readInt();
        goalDifference = in.readInt();
        wins = in.readInt();
        draws = in.readInt();
        losses = in.readInt();
        homeGames = in.readParcelable(HomeAwayEntity.class.getClassLoader());
        awayGames = in.readParcelable(HomeAwayEntity.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(position);
        dest.writeString(teamName);
        dest.writeString(crestURI);
        dest.writeInt(playedGames);
        dest.writeInt(points);
        dest.writeInt(goals);
        dest.writeInt(goalsAgainst);
        dest.writeInt(goalDifference);
        dest.writeInt(wins);
        dest.writeInt(draws);
        dest.writeInt(losses);
        dest.writeParcelable(homeGames, flags);
        dest.writeParcelable(awayGames, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StandingEntity> CREATOR = new Creator<StandingEntity>() {
        @Override
        public StandingEntity createFromParcel(Parcel in) {
            return new StandingEntity(in);
        }

        @Override
        public StandingEntity[] newArray(int size) {
            return new StandingEntity[size];
        }
    };

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public int getPlayedGames() {
        return playedGames;
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

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public HomeAwayEntity getHomeGames() {
        return homeGames;
    }

    public HomeAwayEntity getAwayGames() {
        return awayGames;
    }

    @Override
    public String toString() {
        return "StandingEntity : position = " + position
                + " , teamName = '" + teamName
                + "' , crestURI = '" + crestURI
                + "' , playedGames = " + playedGames
                + " , points = " + points
                + " , goals = " + goals
                + " , goalsAgainst = " + goalsAgainst
                + " , goalDifference = " + goalDifference
                + " , wins = " + wins
                + " , draws = " + draws
                + " , losses = " + losses
                + " , id = " + id
                + " , homeGames = {" + homeGames.toString()
                + "} , awayGames = {" + awayGames.toString() + "}";
    }


}
