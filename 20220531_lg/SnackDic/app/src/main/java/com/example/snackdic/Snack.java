package com.example.snackdic;

public class Snack {
    private String name="";
    private int uri;
    public Snack(String name,int uri) {
        this.name = name;
        this.uri = uri;
    }
    public String getName() {
        return name;
    }

    public int getUri() {
        return uri;
    }
}



