package com.example.wipi.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Rushikesh Jogdand.
 */
public class Person implements Parcelable {
    public String name;
    public String id;
    public String deviceMac;
    public String deviceModel;

    public Person() {
        name = null;
        id = null;
        deviceMac = null;
        deviceModel = null;
    }

    protected Person(Parcel in) {
        name = in.readString();
        id = in.readString();
        deviceMac = in.readString();
        deviceModel = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(deviceMac);
        dest.writeString(deviceModel);
    }
}
