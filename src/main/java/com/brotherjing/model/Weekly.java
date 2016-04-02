package com.brotherjing.model;

import java.util.List;

/**
 * Created by Brotherjing on 2016/4/3.
 */
public class Weekly {
    String btn_color;
    String banner_color;
    String pre_word, post_word;
    String weekly_number;
    String date;
    String file;
    String img;
    List<Author> authors;
    List<Title> titles;

    List<Item> articles;
    List<Item> tools;
    List<Item> repos;

    public Weekly() {
    }

    public String getBtn_color() {
        return btn_color;
    }

    public void setBtn_color(String btn_color) {
        this.btn_color = btn_color;
    }

    public String getBanner_color() {
        return banner_color;
    }

    public void setBanner_color(String banner_color) {
        this.banner_color = banner_color;
    }

    public String getPre_word() {
        return pre_word;
    }

    public void setPre_word(String pre_word) {
        this.pre_word = pre_word;
    }

    public String getPost_word() {
        return post_word;
    }

    public void setPost_word(String post_word) {
        this.post_word = post_word;
    }

    public String getWeekly_number() {
        return weekly_number;
    }

    public void setWeekly_number(String weekly_number) {
        this.weekly_number = weekly_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public List<Item> getArticles() {
        return articles;
    }

    public void setArticles(List<Item> articles) {
        this.articles = articles;
    }

    public List<Item> getTools() {
        return tools;
    }

    public void setTools(List<Item> tools) {
        this.tools = tools;
    }

    public List<Item> getRepos() {
        return repos;
    }

    public void setRepos(List<Item> repos) {
        this.repos = repos;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}