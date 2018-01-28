package com.sk4atg89.alexander.soccer.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoccerTimeUtil {

    private static Pattern patternHour = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})");
    private static Pattern patternHour1 = Pattern.compile("(\\d{1}):(\\d{2}):(\\d{2})");
    private static Pattern patternMin = Pattern.compile("(\\d{2}):(\\d{2})");
    public static final Map<String, Long> times = new LinkedHashMap<>();

    static {
        times.put("day", TimeUnit.DAYS.toMillis(1));
        times.put("hour", TimeUnit.HOURS.toMillis(1));
        times.put("minute", TimeUnit.MINUTES.toMillis(1));
        times.put("second", TimeUnit.SECONDS.toMillis(1));
    }
    public static long getTimeMillis(String s) {
        Matcher matcher = patternMin.matcher(s);
        Matcher matcher2 = patternHour.matcher(s);
        Matcher matcher3 = patternHour1.matcher(s);
        if (!matcher.matches() && !matcher2.matches() && !matcher3.matches()) {
            return 0;
        }
        try {
            if (s.length() == 5) {
                s = "00:" + s;
            }
            String[] data = s.split(":");
            int hours = Integer.parseInt(data[0]);
            int minutes = Integer.parseInt(data[1]);
            long time = (long) ((((minutes * 60) + Integer.parseInt(data[2])) + (hours * 3600)) * 1000);
            System.out.println("time in millis = " + TimeUnit.MILLISECONDS.convert(time, TimeUnit.SECONDS));
            return time;
        } catch (Exception e) {
            return 0;
        }
    }
    public static String toRelative(long duration, int maxLevel) {
        StringBuilder res = new StringBuilder();
        int level = 0;
        for (Map.Entry<String, Long> time : times.entrySet()) {
            long timeDelta = duration / time.getValue();
            if (timeDelta > 0) {
                res.append(timeDelta)
                        .append(" ")
                        .append(time.getKey())
                        .append(timeDelta > 1 ? "s" : "")
                        .append(", ");
                duration -= time.getValue() * timeDelta;
                level++;
            }
            if (level == maxLevel) {
                break;
            }
        }
        if ("".equals(res.toString())) {
            return "0 seconds ago";
        } else {
            res.setLength(res.length() - 2);
            res.append(" ago");
            return res.toString();
        }
    }

    public static String toRelative(long duration) {
        return toRelative(duration, times.size());
    }
//
//    public static String toRelative(Date start, Date end) {
//        assert start.after(end);
//        return toRelative(end.getTime() - start.getTime());
//    }
//
//    public static String toRelative(Date start, Date end, int level) {
//        assert start.after(end);
//        return toRelative(end.getTime() - start.getTime(), level);
//    }

}
