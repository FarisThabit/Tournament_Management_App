package com.example.swe206project;

public class Elimination extends Tournaments {

    int daysBetweenPhases;
    int phases;

    public Elimination(String name, String type, String teamType ,int capacity, String date, int daysBetweenPhases, int phases) {

        super(name, type, teamType, capacity, date);
        this.daysBetweenPhases = daysBetweenPhases;
        this.phases = phases;

    }

    public int getDaysBetweenPhases(){
        return daysBetweenPhases;
    }
    public int getPhases(){
        return phases;
    }


}