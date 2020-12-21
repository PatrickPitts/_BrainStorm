package org.nerdcore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Stopwatch {

    private static LocalDateTime timer;
    private static LocalDateTime stopTime;
    private static DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("mm:ss.SSSS");

    public Stopwatch(){
        start();
    }

    public void start(){
        timer = LocalDateTime.now();
    }

    public String stop(){
        stopTime = LocalDateTime.now();
        return getDurationString();
    }

    public String getDurationString(){
        long diff = timer.until(stopTime, ChronoUnit.MILLIS);
        return String.format("%d milliseconds", diff);
    }

    public long getDuration(){
        return timer.until(stopTime, ChronoUnit.MILLIS);
    }
}
