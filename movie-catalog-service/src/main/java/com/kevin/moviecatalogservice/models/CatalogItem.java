package com.kevin.moviecatalogservice.models;


public class CatalogItem
{
    private String names;
    private String desc;
    private int rating;

    public CatalogItem(String names, String desc, int rating) {
        this.names = names;
        this.desc = desc;
        this.rating = rating;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
