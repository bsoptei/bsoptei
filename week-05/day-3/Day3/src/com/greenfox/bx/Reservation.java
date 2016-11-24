package com.greenfox.bx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Söp on 2016.11.16..
 */
public class Reservation implements Reservationy, Comparator<Object> {
    final static String ls = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static ArrayList<String> lsDow = new ArrayList<>(Arrays.asList("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"));
    private String dow;
    private String codeBooking;

    public Reservation(String dow) {
        this.dow = dow;
        this.codeBooking = randomZeroToZ(8);
    }

    public int dayToNumber() {
        return lsDow.indexOf(dow);
    }

    static String randomZeroToZ(int len) {
        String out = "";
        for(int i= 0; i<len; i++) {
            out += ls.charAt((int) (Math.random() * 36));
        }
        return out;
    }

    public String getDow() {
        return dow;
    }

    @Override
    public void setDowBooking(String dowBooking) {

    }

    @Override
    public String getDowBooking() {
        return null;
    }

    @Override
    public void setCodeBooking(String codeBooking) {

    }

    @Override
    public String getCodeBooking() {
        return codeBooking;
    }

    @Override
    public boolean PlaceReserved(String dowBooking, String codeBooking) {
        return false;
    }

    @Override
    public boolean PlaceCancelled(String dowBooking, String codeBooking) {
        return false;
    }

    public String toString() {
        return String.format("Booking# %s for %s", codeBooking, dow);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public Comparator<Object> reversed() {
        return null;
    }
}
