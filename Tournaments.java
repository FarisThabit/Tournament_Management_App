package com.example.swe206project;

public class Tournaments {
    private String name;
    private String type;

    private String teamType;
    private int capacity;
    private String date;

    private String startDate;

    private String dueDate;

    public Tournaments(String name, String type, String teamType ,int capacity, String date){
        this.name = name;
        this.type = type;
        this.teamType = teamType;
        this.capacity = capacity;
        this.date = date;
        this.startDate = date.substring(0,date.indexOf("-"));
        this.dueDate = date.substring(date.indexOf("-")+1,date.length());

    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }

    public String getTeamType(){
        return teamType;
    }

    public String getStartDate(){return startDate;};

    public String getDueDate(){return dueDate;}

    public int getCapacity(){
        return capacity;
    }
    public String getDate(){
        return date;
    }
    public String toString(){
        return name+","+type+","+teamType+","+capacity+","+date.trim();
    }
}
