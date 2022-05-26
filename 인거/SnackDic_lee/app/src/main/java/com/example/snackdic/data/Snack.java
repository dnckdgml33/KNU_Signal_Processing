package com.example.snackdic.data;

public class Snack {
    private String name="";
    private String uri="";
    public Snack(String name,String uri){
        this.name=name;
        this.uri=uri;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }
}



