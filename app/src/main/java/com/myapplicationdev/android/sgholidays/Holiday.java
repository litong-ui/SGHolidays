package com.myapplicationdev.android.sgholidays;

public class Holiday {
    private String name;
    private String date;
    private String imageName;

    public Holiday(String name, String date, String imageName) {
        this.name = name;
        this.date = date;
        this.imageName = imageName;
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public String getImageName() {
        return imageName;
    }
}
