package com.example.brom.listviewjsonapp;

public class Kost {

    private String name;
    private String type;
    private int size;


    public Kost(String inName, String inLocation, int inHeight) {

        name = inName;
        type = inLocation;
        size = inHeight;
    }

    public Kost(String inName) {

        name = inName;
        type = "";
        size = 1;
    }

    public String toString() {return name;}

    public String info(){

        String str=name;
        str+=" is located in ";
        str+=type;
        str+=" and has an height of ";
        str+= Integer.toString(size);
        str+="m. ";
        return str;
    }

}