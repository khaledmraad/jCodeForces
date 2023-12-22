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
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



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

//      line=line.substring(line.indexOf('[')+1,line.length()-2);

        System.out.println(line);

        String responseFilePath="./src/main/java/test.json";

        PrintWriter printer=new PrintWriter(responseFilePath);
        printer.write(line);
        printer.close();

        JSONParser jsonParser=new JSONParser();

        FileReader fileReader =new FileReader(responseFilePath);

        Object obj=jsonParser.parse(fileReader);
        JSONObject responseObj=(JSONObject) obj;

        JSONArray contests=(JSONArray) responseObj.get("result");

//        System.out.print(contests);

        for (int i=0;i<contests.size();i++){
            JSONObject ithContest=(JSONObject) contests.get(i);

            String contestState=(String) ithContest.get("phase");
            if(Objects.equals(contestState, "BEFORE")){
                System.out.println((String) ithContest.get("name") );
            }
            else {
                break;
            }

        }

    }
}
