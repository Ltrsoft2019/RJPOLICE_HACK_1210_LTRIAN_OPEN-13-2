package com.ltrsoft.policeapp.Classes;

import java.io.Serializable;

public class News implements Serializable {
    public int newsImgRes;

    public int getNewsImgRes() {
        return newsImgRes;
    }

    public void setNewsImgRes(int newsImgRes) {
        this.newsImgRes = newsImgRes;
    }

    public News(int newsImgRes) {
        this.newsImgRes = newsImgRes;
    }
}
