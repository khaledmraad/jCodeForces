package com.example.jcodeforces;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Main extends Application {

    Stage window;
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{


        CodeForcesGetRequest.sendRequest();

        JsonProcessing jsonReader=new JsonProcessing(CodeForcesGetRequest.responseFilePath);

        JSONArray contests=jsonReader.allContestsDetails();
        System.out.println("lkjsndlckjsndlkcjn");
//        System.out.print(contests);


        Vector<Label> textLabel=new Vector<>();

        for (int i=0;i<contests.size();i++){
            JSONObject ithContest=(JSONObject) contests.get(i);

            String contestState=(String) ithContest.get("phase");

            if(Objects.equals(contestState, "BEFORE")){

                Label l=new Label((String) ithContest.get("name"));

                textLabel.add(l);

                System.out.println((String) ithContest.get("name") );

            }
            else {
                break;
            }

        }

        window=primaryStage;
        VBox vBox=new VBox(20);
        vBox.getChildren().addAll(textLabel);


        Scene scene=new Scene(vBox,300,300);
        window.setScene(scene);
        window.show();

    }
}
