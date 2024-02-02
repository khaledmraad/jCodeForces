package com.example.jcodeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ContestInfo {
    private static final String contest_API = "https://codeforces.com/api/contest.list?gym=false";

    static public String responseContestFilePath="./src/main/java/test.json";

    public static void sendContestRequest() throws Exception {
        String response=SaveResponseFile.sendRequest(contest_API);
        SaveResponseFile.writeJSON(response,responseContestFilePath);
    }

    public static void main(String[] args) throws Exception {
        ContestInfo.sendContestRequest();
    }


}
