package com.sk4atg89.alexander.soccer.domain.common.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class LeagueTableEntity implements Parcelable {

    private String leagueCaption;
    private int matchday;
    private List<StandingEntity> standing;
    private List<ChampionLeagueStandingEntity> standings;

    public LeagueTableEntity(String leagueCaption,
                             int matchday,
                             List<StandingEntity> standing,
                             List<ChampionLeagueStandingEntity> standings
    ) {
        this.leagueCaption = leagueCaption;
        this.matchday = matchday;
        this.standing = standing;
        this.standings = standings;
    }

    protected LeagueTableEntity(Parcel in) {
        leagueCaption = in.readString();
        matchday = in.readInt();
        standing = in.createTypedArrayList(StandingEntity.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(leagueCaption);
        dest.writeInt(matchday);
        dest.writeTypedList(standing);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LeagueTableEntity> CREATOR = new Creator<LeagueTableEntity>() {
        @Override
        public LeagueTableEntity createFromParcel(Parcel in) {
            return new LeagueTableEntity(in);
        }

        @Override
        public LeagueTableEntity[] newArray(int size) {
            return new LeagueTableEntity[size];
        }
    };

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public int getMatchday() {
        return matchday;
    }

    public List<StandingEntity> getStanding() {
        return standing;
    }

    public List<ChampionLeagueStandingEntity> getStandings() {
        return standings;
    }

    @Override
    public String toString() {
        return "LeagueTableEntity : matchday = " + matchday
                + " , leagueCaption = '" + leagueCaption
                + "' , awayGames = {" + standing.toString() + "}";
    }


}
