package com.sk4atg89.alexander.soccer.domain.common.model;


import android.os.Parcel;
import android.os.Parcelable;

public class PlayerEntity implements Parcelable {

    private String name;
    private String position;
    private int jerseyNumber;
    private String dateOfBirth;
    private String nationality;
    private String contractUntil;

    public PlayerEntity(String name, String position, int jerseyNumber, String dateOfBirth, String nationality, String contractUntil) {
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.contractUntil = contractUntil;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public String getContractUntil() {
        return contractUntil;
    }

    protected PlayerEntity(Parcel in) {
        name = in.readString();
        position = in.readString();
        jerseyNumber = in.readInt();
        dateOfBirth = in.readString();
        nationality = in.readString();
        contractUntil = in.readString();
    }

    public static final Creator<PlayerEntity> CREATOR = new Creator<PlayerEntity>() {
        @Override
        public PlayerEntity createFromParcel(Parcel in) {
            return new PlayerEntity(in);
        }

        @Override
        public PlayerEntity[] newArray(int size) {
            return new PlayerEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(position);
        dest.writeInt(jerseyNumber);
        dest.writeString(dateOfBirth);
        dest.writeString(nationality);
        dest.writeString(contractUntil);
    }


    @Override
    public String toString() {
        return "PlayerEntity : name = '" + name
                + "' , position = '" + position
                + "' , jerseyNumber = " + jerseyNumber
                + "  , dateOfBirth = '" + dateOfBirth
                + "' , nationality = '" + nationality
                + "' , contractUntil = '" + contractUntil + "'";
    }
}
