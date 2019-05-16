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

    public String toString() {return kostName;}


    public String getKostName() {
        return kostName;
    }

    public void setKostName(String kostName) {
        this.kostName = kostName;
    }

    public String getKostCompany() {
        return kostCompany;
    }

    public void setKostCompany(String kostCompany) {
        this.kostCompany = kostCompany;
    }

    public String getKostType() {
        return kostType;
    }

    public void setKostType(String kostType) {
        this.kostType = kostType;
    }

    public int getKostPrice() {
        return kostPrice;
    }

    public void setKostPrice(int kostPrice) {
        this.kostPrice = kostPrice;
    }

    public int getKostSize() {
        return kostSize;
    }

    public void setKostSize(int kostSize) {
        this.kostSize = kostSize;
    }

    public int getKostScoop() {
        return kostScoop;
    }

    public void setKostScoop(int kostScoop) {
        this.kostScoop = kostScoop;
    }



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