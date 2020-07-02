package com.example.partymanager;

import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;

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

    public String toString(){
        String s = "{ \"location\": \"" + location + "\", \"date\": \"" + date + "\", \"time\": \"" + time + "\", \"people\": \"" +  TextUtils.join(", ", people) + "\" }";
        return s;
    }
}
