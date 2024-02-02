package com.example.jcodeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SaveResponseFile {

    public static String sendRequest(String API_URL) throws Exception{

        URL url = new URL(API_URL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        return reader.readLine();

//      line=line.substring(line.indexOf('[')+1,line.length()-2);

    }

    static void writeJSON(String content,String path) throws Exception{
        PrintWriter printer=new PrintWriter(path);
        printer.write(content);
        printer.close();
    }


}
