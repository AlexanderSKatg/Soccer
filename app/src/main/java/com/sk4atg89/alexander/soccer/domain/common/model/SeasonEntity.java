package com.sk4atg89.alexander.soccer.domain.common.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.sk4atg89.alexander.soccer.utils.SoccerDateUtils;

public class SeasonEntity implements Parcelable {

    private int id;
    private String caption;
    private String league;
    private String year;
    private int currentMatchday;
    private int numberOfMatchdays;
    private int numberOfTeams;
    private int numberOfGames;
    private long eventTime;

    public SeasonEntity(int id,
                        String caption,
                        String league,
                        String year,
                        int currentMatchday,
                        int numberOfMatchdays,
                        int numberOfTeams,
                        int numberOfGames,
                        String lastUpdated) {
        this.id = id;
        this.caption = caption;
        this.league = league;
        this.year = year;
        this.currentMatchday = currentMatchday;
        this.numberOfMatchdays = numberOfMatchdays;
        this.numberOfTeams = numberOfTeams;
        this.numberOfGames = numberOfGames;
        eventTime = SoccerDateUtils.getConvertedTime(lastUpdated);
        eventTime = System.currentTimeMillis() - eventTime;
    }

    public int getId() {
        return id;
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

    protected SeasonEntity(Parcel in) {
        id = in.readInt();
        caption = in.readString();
        league = in.readString();
        year = in.readString();
        currentMatchday = in.readInt();
        numberOfMatchdays = in.readInt();
        numberOfTeams = in.readInt();
        numberOfGames = in.readInt();
        eventTime = in.readLong();
    }

    public static final Creator<SeasonEntity> CREATOR = new Creator<SeasonEntity>() {
        @Override
        public SeasonEntity createFromParcel(Parcel in) {
            return new SeasonEntity(in);
        }

        @Override
        public SeasonEntity[] newArray(int size) {
            return new SeasonEntity[size];
        }
    };

    @Override
    public String toString() {
        return "SeasonEntity :  " +
                " id = " + id
                + " , caption = '" + caption + "'"
                + " , league = '" + league + "'"
                + " , year = '" + year + "'"
                + " , currentMatchday = " + currentMatchday
                + " , numberOfMatchdays = " + numberOfMatchdays
                + " , numberOfTeams = " + numberOfTeams
                + " , numberOfGames = " + numberOfGames
                + " , eventTime = " + eventTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(caption);
        dest.writeString(league);
        dest.writeString(year);
        dest.writeInt(currentMatchday);
        dest.writeInt(numberOfMatchdays);
        dest.writeInt(numberOfTeams);
        dest.writeInt(numberOfGames);
        dest.writeLong(eventTime);
    }
}
