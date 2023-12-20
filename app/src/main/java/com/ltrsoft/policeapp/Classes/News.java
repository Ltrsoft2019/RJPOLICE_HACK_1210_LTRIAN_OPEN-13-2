package com.ltrsoft.policeapp.Classes;

import java.io.Serializable;

public class News implements Serializable {
    public int newsImgRes;
    public String newstitle,newsdate;

    public News(int newsImgRes, String newstitle, String newsdate) {
        this.newsImgRes = newsImgRes;
        this.newstitle = newstitle;
        this.newsdate = newsdate;
    }

    public int getNewsImgRes() {
        return newsImgRes;
    }

    public void setNewsImgRes(int newsImgRes) {
        this.newsImgRes = newsImgRes;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewsdate() {
        return newsdate;
    }

    public void setNewsdate(String newsdate) {
        this.newsdate = newsdate;
    }
}
