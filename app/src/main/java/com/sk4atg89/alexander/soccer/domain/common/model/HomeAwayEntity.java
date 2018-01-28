package com.sk4atg89.alexander.soccer.domain.common.model;


import android.os.Parcel;
import android.os.Parcelable;

public class HomeAwayEntity implements Parcelable {

    private int goals;
    private int goalsAgainst;
    private int wins;
    private int draws;
    private int losses;


    public HomeAwayEntity(int goals, int goalsAgainst, int wins, int draws, int losses) {
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
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

    protected HomeAwayEntity(Parcel in) {
        goals = in.readInt();
        goalsAgainst = in.readInt();
        wins = in.readInt();
        draws = in.readInt();
        losses = in.readInt();
    }

    public static final Creator<HomeAwayEntity> CREATOR = new Creator<HomeAwayEntity>() {
        @Override
        public HomeAwayEntity createFromParcel(Parcel in) {
            return new HomeAwayEntity(in);
        }

        @Override
        public HomeAwayEntity[] newArray(int size) {
            return new HomeAwayEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(goals);
        dest.writeInt(goalsAgainst);
        dest.writeInt(wins);
        dest.writeInt(draws);
        dest.writeInt(losses);
    }

    @Override
    public String toString() {
        return "HomeAwayEntity : goals = " + goals
                + " , goalsAgainst = " + goalsAgainst
                + " , wins = " + wins
                + " , draws = " + draws
                + " , losses = " + losses;
    }

}
