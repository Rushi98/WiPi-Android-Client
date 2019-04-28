package com.example.wipi.models;


import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Rushikesh Jogdand.
 */
public class Attendance {

    public static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy MM dd, HH:mm:ss", Locale.ENGLISH);

    public String personName;

    public String macAddress;

    public int numberOfHits;

    public Attendance (String personName, String macAddress, int numberOfHits) {
        this.personName = personName;
        this.macAddress = macAddress;
        this.numberOfHits = numberOfHits;
    }

    /**
     * Timestamp in {@link #TIMESTAMP_FORMAT} format.
     */
//    public String lastHit;

    /**
     * Unit : meter
     */
//    public float distance;

    /**
     * range : [0f,1f]
     */
//    public float confidence;
}
