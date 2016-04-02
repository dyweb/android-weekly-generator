package com.brotherjing;

/**
 * Created by Brotherjing on 2016/4/2.
 */

import com.brotherjing.model.Weekly;
import com.google.gson.Gson;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
}

