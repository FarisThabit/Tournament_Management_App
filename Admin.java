package com.example.swe206project;

public class Admin {
    private String name;
    private int id;
    private String email;
    public Admin(String name, int id, String email){
        this.name = name;
        this.id = id;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String toString(){
        return  name+","+id+","+email.trim();
    }
}
