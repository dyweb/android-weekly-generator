package com.brotherjing;

/**
 * Created by Brotherjing on 2016/4/2.
 */

import com.google.gson.Gson;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

    private static final String OUTPUT_HTML_NAME = "out.html";

    /**
     * Usage: java androidweekly.jar <mail html template path> <markdown template path> <weekly json path>
     * @param args
     */
    public static void main(String[] args) {
        String path_email_template;
        String path_md_template;
        String path_json;
        if (args.length < 3) {
            System.out.println("Usage: java androidweekly.jar <mail html template path> <markdown template path> <weekly json path>");
            /*path_email_template = "E:\\Projects\\mailer\\template.html";
            path_md_template = "E:\\Projects\\mailer\\template.md";
            path_json = "E:\\Projects\\mailer\\weekly.json";*/
            return;
        } else {
            path_email_template = args[0];
            path_md_template = args[1];
            path_json = args[2];
        }
        String temp, json;
        try {
            FileReader fileReader = new FileReader(path_email_template);
            FileReader jsonReader = new FileReader(path_json);
            BufferedReader bufferedReader = new BufferedReader(jsonReader);
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s).append("\n");
            }
            bufferedReader.close();
            json = sb.toString();

            Template template = Mustache.compiler().compile(fileReader);

            Weekly weekly = new Gson().fromJson(json, Weekly.class);

            temp = template.execute(
                    weekly
            );

            File out = new File(OUTPUT_HTML_NAME);
            PrintWriter writer = new PrintWriter(out);
            writer.print(temp);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader(path_md_template);
            FileReader jsonReader = new FileReader(path_json);
            BufferedReader bufferedReader = new BufferedReader(jsonReader);
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s).append("\n");
            }
            bufferedReader.close();
            json = sb.toString();

            Template template = Mustache.compiler().compile(fileReader);

            Weekly weekly = new Gson().fromJson(json, Weekly.class);

            temp = template.execute(weekly);

            File out = new File(weekly.getFile());
            PrintWriter writer = new PrintWriter(out);
            writer.print(temp);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class Weekly {
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

    class Title {
        public String name;

        public Title(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

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

    class Author {
        String name;

        public Author() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

