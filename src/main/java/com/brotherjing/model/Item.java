package com.brotherjing.model;

/**
 * Created by Brotherjing on 2016/4/3.
 */
class Item {
    String title;
    String url;
    String desc;

    public Item() {
    }

    public Item(String title, String url, String desc) {
        this.title = title;
        this.url = url;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}