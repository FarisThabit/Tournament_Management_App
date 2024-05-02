package com.example.swe206project;

import java.util.ArrayList;
import java.util.List;

public class RoundRobin {

    private final List<String> Tournament;
    private final List<String> Team;
    private final List<Integer> Wins;
    private final List<Integer> Losses;
    private final List<Integer> Draws;
    private final List<Integer> Score;


    public RoundRobin(List<String> Tournament, List<String> Team, List<Integer> Wins, List<Integer> Losses, List<Integer> Draws, List<Integer> Score) {

        this.Tournament = Tournament;
        this.Team = Team;
        this.Wins = Wins;
        this.Losses = Losses;
        this.Draws = Draws;
        this.Score = Score;

    }


    public List<String> getTournament() { return Tournament; }

    public List<String> getTeam() { return Team; }
    public List<Integer> getWins() { return Wins; }

    public List<Integer> getLosses() { return Losses; }

    public List<Integer> getDraws() { return Draws; }

    public List<Integer> getScore() { return Score; }

}