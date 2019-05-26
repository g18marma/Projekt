package com.example.g18marma.projekt;

public class Kost {

    private String kostName;
    private String kostCompany;
    private String kostType;
    private int kostPrice;
    private int kostSize;
    private int kostScoop;
    private int kostKcal;
    private int kostFett;
    private int kostProtein;





    public Kost(String inName, String inType, String inCompany,  int inPrice, int inSize, int inScoop, int inKcal, int inFett, int inProtein) {

        kostName = inName;
        this.kostPrice = inPrice;
        kostCompany = inCompany;
        this.kostScoop = inScoop;
        kostType = inType;
        this.kostSize = inSize;
        this.kostKcal = inKcal;
        this.kostFett = inFett;
        this.kostProtein = inProtein;
    }

    public int getKostFett() {
        return kostFett;
    }

    public void setKostFett(int kostFett) {
        this.kostFett = kostFett;
    }

    public int getKostProtein() {
        return kostProtein;
    }

    public void setKostProtein(int kostProtein) {
        this.kostProtein = kostProtein;
    }

    public int getKostKcal() {
        return kostKcal;
    }

    public void setKostKcal(int kostKcal) {
        this.kostKcal = kostKcal;
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