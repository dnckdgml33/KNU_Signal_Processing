package com.snack.snackdic.akinator;

public class Snack {
    private String name="";
    private int uri;
    private int kcal;
    private String search="";
    public Snack(String name,int uri,int kcal,String search) {
        this.name = name;
        this.uri = uri;
        this.kcal=kcal;
        this.search=search;
    }
    public String getName() {
        return name;
    }

    public int getUri() {
        return uri;
    }

    public int getKcal() {
        return kcal;
    }

    public String getSearch(){
        return search;
    }
}



