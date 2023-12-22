package com.example.bloodbank;

public class ShortsData {
    public ShortsData(String shortPath, String shortsUser, String shortsTitle, int shortsImage) {
        this.shortPath = shortPath;
        this.shortsUser = shortsUser;
        this.shortsTitle = shortsTitle;
        this.shortsImage = shortsImage;
    }

    private String shortPath,shortsUser , shortsTitle  ;
    private int shortsImage ;

    public String getShortsUser() {
        return shortsUser;
    }

    public String getShortsTitle() {
        return shortsTitle;
    }

    public String getShortPath() {
        return shortPath;
    }

    public int getShortsImage() {
        return shortsImage;
    }


}
