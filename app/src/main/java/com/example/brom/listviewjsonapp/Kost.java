package com.example.brom.listviewjsonapp;

public class Kost {

    private String kostName;
    private String kostCompany;
    private String kostType;
    private int kostPrice;
    private int kostSize;
    private int kostScoop;


    public Kost(String inName, String inType, String inCompany, int inSize, int inPrice, int inScoop) {

        kostName = inName;
        kostPrice = inPrice;
        kostCompany = inCompany;
        kostScoop = inScoop;
        kostType = inType;
        kostSize = inSize;
    }

    public Kost(String inName) {

        kostName = inName;
        kostType = "";
        kostSize = 1;
    }

    public String toString() {return kostName;}



    public String info(){

        String str=kostName;
        str+=" ";
        str+=kostType;
        str+=" ";
        str+= Integer.toString(kostSize);
        str+="g ";
        return str;
    }

}