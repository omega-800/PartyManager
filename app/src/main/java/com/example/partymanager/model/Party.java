package com.example.partymanager.model;

import java.util.ArrayList;

public class Party{

    String location;
    String date;
    String time;
    ArrayList<String> people = new ArrayList<String>();

    public Party(){
    }

    public void setLocation(String l){
        location = l;
    }

    public String getLocation(){
        return location;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String d){
        date = d;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String t){
        time = t;
    }

    public ArrayList<String> getPeople(){
        return people;
    }

    public void setPeople(ArrayList<String> p){
        people = p;
    }

    public void addPerson(String p){
        people.add(", "+p);
    }
}
