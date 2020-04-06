package com.company;


/**
 * Class description here
 *
 */

public class Boiler {
    double initTemp = 15;
    int initTimer = 0;
    double currentTemp = 0;


    // returns true when boiler started.
    public Boolean starBoiler() {
        if (checkCurrentTemp()) {
            //System.out.println("Boiler started.");
            boil(60);
            return true;
        }

        return false;
    }

    // bank normally checked the water quantity "Optional"
    private Boolean checkQuantity(int quantity) {
        if (quantity < 20)
            return false;

        return true;
    }

    // check water current temperature
    private Boolean checkCurrentTemp() {
        if (currentTemp < 65)
            return true;

        return false;
    }

    // returns time in seconds
    private double calculateBoilingTime() {
        // for previously boiled water
        double bt;
        if (currentTemp > 0) {
            double leftTemp = 100 - currentTemp;
            bt = ( (leftTemp * 3) / 85 ) * 60;
            return bt;
        }

        //time of first boil (3 minutes). boilTime(bt)
        bt = 3 * 60;
        return bt;
    }

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

                System.out.println("Elapsed Time: "+boilerTimer.boilingTime(currentTemp));;
                System.out.println(currentTemp);
            }
        }

        return "finished";
    }
}
