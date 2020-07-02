package com.example.partymanager;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveState {






     public void save(String txt, Context ctx){
         FileInputStream fin = null;                                     //Read Stream öffnen
         try {
             fin = ctx.openFileInput("data");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         int c = 0;                                                      //Aus Stream auslesen
         String temp = "";
         while(true){
             try {
                 if (!((c = fin.read()) != -1)) break;
             } catch (IOException e) {
                 e.printStackTrace();
             }
             temp = temp + Character.toString((char)c);
         }

         if(temp.length() == 0){
             temp="[  ]";
         }

         try {
             fin.close();                                                // Stream schliessen
         } catch (IOException e) {
             e.printStackTrace();
         }

            FileOutputStream fOut = null;
            try {
                fOut = ctx.openFileOutput("data", Context.MODE_PRIVATE);        //File Stream öffnen | Name: Name der Datei

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                temp = temp.substring(0, temp.length() - 2);
                String s="";
                if(temp.length() == 2){
                    s = temp.concat(txt).concat(" ]");
                }else{
                    s = temp.concat(", ").concat(txt).concat(" ]");
                }
                fOut.write(s.getBytes());                                    // Text aus String in Datei schreiben
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fOut.close();                                                       // Stream schliessen
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

     public String restore(Context ctx){
            //text_save.setText(text[0]);
            FileInputStream fin = null;                                     //Read Stream öffnen
            try {
                fin = ctx.openFileInput("data");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int c = 0;                                                      //Aus Stream auslesen
            String temp="";
            while(true){
                try {
                    if (!((c = fin.read()) != -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                temp = temp + Character.toString((char)c);
            }

            try {
                fin.close();                                                // Stream schliessen
            } catch (IOException e) {
                e.printStackTrace();
            }
           return temp;
    }







}
