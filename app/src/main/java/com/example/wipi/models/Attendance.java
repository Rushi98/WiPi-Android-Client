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

    /**
     * Timestamp in {@link #TIMESTAMP_FORMAT} format.
     */
    public String lastHit;

    /**
     * Unit : meter
     */
    public float distance;

    /**
     * range : [0f,1f]
     */
    public float confidence;
}
