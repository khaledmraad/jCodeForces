package com.example.jcodeforces;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Objects;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ContextScene {

    public static Scene theContextScene() throws Exception{

        ContestInfo.sendContestRequest();

        JsonProcessing jsonReader=new JsonProcessing(ContestInfo.responseContestFilePath);

        JSONArray contests=jsonReader.allContestsDetails();

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

        VBox vBox=new VBox(20);
        vBox.getChildren().addAll(textLabel);


        return new Scene(vBox,300,300);

    }
}
