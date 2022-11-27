package com.example.mysuperhero;


public class DataModel {

    String name;
    String detail;
    String data;
    int image;

    public DataModel(String name, String version,int image , String data) {
        this.name = name;
        this.detail = version;
        this.image=image;
        this.data = data;
    }


    public String getName() {
        return name;
    }


    public String getDetail() {
        return detail;
    }

    public String getData() {
        return data;
    }

    public int getImage() {
        return image;
    }

}