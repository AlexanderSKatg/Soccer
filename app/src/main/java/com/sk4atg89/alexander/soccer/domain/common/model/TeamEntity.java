package com.sk4atg89.alexander.soccer.domain.common.model;


import android.os.Parcel;
import android.os.Parcelable;

public class TeamEntity implements Parcelable {

    private String name;
    private String code;
    private String shortName;
    private Object squadMarketValue;
    private String crestUrl;

    public TeamEntity(String name, String code, String shortName, Object squadMarketValue, String crestUrl) {
        this.name = name;
        this.code = code;
        this.shortName = shortName;
        this.squadMarketValue = squadMarketValue;
        this.crestUrl = crestUrl;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getShortName() {
        return shortName;
    }

    public Object getSquadMarketValue() {
        return squadMarketValue;
    }

    public String getCrestUrl() {
        return crestUrl;
    }


    protected TeamEntity(Parcel in) {
        name = in.readString();
        code = in.readString();
        shortName = in.readString();
        crestUrl = in.readString();
    }

    public static final Creator<TeamEntity> CREATOR = new Creator<TeamEntity>() {
        @Override
        public TeamEntity createFromParcel(Parcel in) {
            return new TeamEntity(in);
        }

        @Override
        public TeamEntity[] newArray(int size) {
            return new TeamEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(code);
        dest.writeString(shortName);
        dest.writeString(crestUrl);
    }

    @Override
    public String toString() {
        return "TeamEntity : name = '" + name
                + "' , code = '" + code
                + "' , shortName = '" + shortName
                + "' , crestUrl = '" + crestUrl + "'";
    }
}
