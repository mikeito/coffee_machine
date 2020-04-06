package com.company;


public class Main {

    public static void main(String[] args) {

        Boiler boiler = new Boiler();

        boiler.boil(60);
        System.out.println("initTemp " + boiler.initTemp);
        System.out.println("currentTemp " + boiler.currentTemp);
    }
}
