package com.example.jcodeforces;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static final String contest_API = "https://codeforces.com/api/contest.list?gym=false";
    @Override
    public void start(Stage primaryStage) throws Exception{

        URL url = new URL(contest_API);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line=reader.readLine();

//        line=line.substring(line.indexOf('[')+1,line.length()-2);

        System.out.println(line);

        PrintWriter printer=new PrintWriter("./src/main/java/test.json");
        printer.write(line);
        printer.close();


    }
}
