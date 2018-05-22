package com.hillary.fetchingmovies;

public class Movie {
    private String title, year, category;

    public Movie(String title, String year, String category) {
        this.title = title;
        this.year = year;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }




}
