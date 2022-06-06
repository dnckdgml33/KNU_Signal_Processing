package com.example.snackdic.akinator;

public class Snack {
    private String name="";
    private int uri;
    private int kcal;
    public Snack(String name,int uri,int kcal) {
        this.name = name;
        this.uri = uri;
        this.kcal=kcal;
    }
    public String getName() {
        return name;
    }

    public int getUri() {
        return uri;
    }

    public int getKcal(){return kcal;}
}



