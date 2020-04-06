package com.company;

/**
 * Class description here
 * We made some assumptions
 * - water initial temperature is 15° C
 * - water is considered cold from 65° C
 * - water takes 3minutes to move from 15 - 100°C
 *
 */

public class Boiler {
    double initTemp = 15;
    int initTimer = 0;
    double currentTemp = 0;


    /**
     * Returns true when boiler started.
     */
    public Boolean starBoiler() {
        if (checkCurrentTemp()) {
            boil(60);
            return true;
        }

        return false;
    }

    /**
     * Check if there is enough water in the bank.
     * bank normally should checked the water quantity "Optional"
     * @param quantity comes from the bank
     */
    private Boolean checkQuantity(int quantity) {
        if (quantity < 20)
            return false;

        return true;
    }

    /**
     * Check water current temperature for possible reboil
     */
    private Boolean checkCurrentTemp() {
        if (currentTemp < 65)
            return true;

        return false;
    }

    /**
     * From the current temperature of water,
     * Calculate the time needed for it to reach 100°C
     * returns time in seconds
     */
    private double calculateBoilingTime() {
        // for previously boiled water
        double bt;
        if (currentTemp > 0) {
            double leftTemp = 100 - currentTemp;
            bt = ( (leftTemp * 3) / 85 ) * 60;
            return bt;
        }

        //time of first boil (3 minutes), boilTime(bt)
        bt = 3 * 60;
        return bt;
    }

    /**
     * Boil the water proper.
     * @param quantity from bank class
     */
    public String boil(int quantity) {
        //init quantity from bank module
        quantity = 50;
        double boilTime = calculateBoilingTime();

        if (checkQuantity(quantity)) {
            BoilerTimer boilerTimer = new BoilerTimer();
            currentTemp = initTemp;

            for (int i = 0; i<=boilTime; i++) {
                System.out.println("In: " +i);
                currentTemp += 0.472;

                System.out.println("Elapsed Time: "+boilerTimer.boilingTime(currentTemp));
                System.out.println(currentTemp);
            }
        }

        return "finished";
    }
}
