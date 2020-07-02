package com.example.partymanager;

public class Party {
    String location;
    String date;
    String time;
    String[] people;

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

    public String[] getPeople(){
        return people;
    }


    public void setPeople(String[] p){
        people = p;
    }
}
