package com.ltrsoft.policeapp.Classes;

import java.io.Serializable;

public class News implements Serializable {
    public String news_title,news_description,news_date,news_category_name,news_photo_path;

    public News(String news_title, String news_description, String news_date, String news_category_name, String news_photo_path) {
        this.news_title = news_title;
        this.news_description = news_description;
        this.news_date = news_date;
        this.news_category_name = news_category_name;
        this.news_photo_path = news_photo_path;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_description() {
        return news_description;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public String getNews_category_name() {
        return news_category_name;
    }

    public void setNews_category_name(String news_category_name) {
        this.news_category_name = news_category_name;
    }

    public String getNews_photo_path() {
        return news_photo_path;
    }

    public void setNews_photo_path(String news_photo_path) {
        this.news_photo_path = news_photo_path;
    }
}
