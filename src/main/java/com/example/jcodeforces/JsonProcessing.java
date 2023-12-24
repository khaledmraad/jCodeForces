package com.example.jcodeforces;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonProcessing {


    String path;
    JSONParser jsonParser;
    FileReader fileReader;
    public JsonProcessing(String filePath) throws Exception{

        this.path=filePath;
        JSONParser jsonParser=new JSONParser();

        FileReader fileReader =new FileReader(filePath);

    }

    public JSONArray contestsDetails() throws Exception{

        Object obj=jsonParser.parse(fileReader);
        JSONObject responseObj=(JSONObject) obj;

        return (JSONArray) responseObj.get("result");

    }



}
