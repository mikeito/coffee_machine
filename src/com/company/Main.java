package com.company;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Boiler boiler = new Boiler();
        //boiler.calculateBoilingTime();
        //System.out.println(boiler.calculateBoilingTime());

        boiler.boil(60);
        System.out.println("initTemp " + boiler.initTemp);
        System.out.println("currentTemp " + boiler.currentTemp);
    }
}
