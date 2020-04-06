package com.company;

import java.util.concurrent.TimeUnit;

public class BoilerTimer {

    private final long start;


    /**
     * Initializes a new stopwatch.
     */
    public BoilerTimer() {
        start = System.currentTimeMillis();
    }

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public double boilingTime(double currentTime) {
        if (currentTime < 100) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return elapsedTime();
        }

        return 0.0;
    }

}