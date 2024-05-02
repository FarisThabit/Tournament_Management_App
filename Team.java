package com.example.swe206project;

public class Team {

    String name;
    int score;
    int seatsForStudents;

    public Team(String name, int score, int seatsForStudents) {

        this.name = name;
        this.score = score;
        this.seatsForStudents = seatsForStudents;

    }

    public String getName() { return name; }

    public int getScore() { return score; }

    public int getSeatsForStudents() { return seatsForStudents; }
}