package com.sk4atg89.alexander.soccer.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class SoccerDateUtils {

    private static final SimpleDateFormat CAME_TIME = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());

    public static long getConvertedTime(String time) {
        try {
            return CAME_TIME.parse(time).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
