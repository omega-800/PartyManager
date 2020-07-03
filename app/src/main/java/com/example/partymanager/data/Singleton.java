package com.example.partymanager.data;

import com.example.partymanager.model.Party;

import java.util.ArrayList;

public class Singleton {
    private static Singleton singleton = new Singleton( );
    ArrayList<Party> partyList = new ArrayList<Party>();

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Singleton() { }

    /* Static 'instance' method */
    public static Singleton getInstance( ) {
        return singleton;
    }

    public void addParty(Party party){
        partyList.add(party);
    }

    public ArrayList<Party> getParties(){
        return partyList;
    }

    public Party getParty(int index){
        return partyList.get(index);
    }

}
