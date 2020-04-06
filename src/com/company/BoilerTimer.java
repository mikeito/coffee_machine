package com.company;

import java.util.concurrent.TimeUnit;

/**
 * BoilerTimer class.
 * Monitors every boil time using the system CPU time
 * We have an error margin, from pausing "TimeUnit.SECONDS.sleep(1)"
 * this error is quite negligable
 */
public class BoilerTimer {

    private final long start;


    /**
     * Initializes a new timer.
     */
    public BoilerTimer() {
        start = System.currentTimeMillis();
    }

    /**
     * @return elapsed CPU time (in seconds) since the timer was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    /**
     * returns boiling time
     * Pause for a second to simulate 1sec of time
     */
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