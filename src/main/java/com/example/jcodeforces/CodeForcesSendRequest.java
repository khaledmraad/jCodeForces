package com.example.jcodeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class CodeForcesSendRequest {
    private static final String contest_API = "https://codeforces.com/api/contest.list?gym=false";


    static public String responseFilePath="./src/main/java/test.json";

    static void writeJSON(String content,String path) throws Exception{
        PrintWriter printer=new PrintWriter(path);
        printer.write(content);
        printer.close();
    }


    public static void sendRequest() throws Exception{

        URL url = new URL(contest_API);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line=reader.readLine();

//      line=line.substring(line.indexOf('[')+1,line.length()-2);




        writeJSON(line,responseFilePath);

    }

}
