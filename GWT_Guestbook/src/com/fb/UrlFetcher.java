package com.fb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlFetcher {
    /**
     * 擷取url返回的資料裡的access_token
     * @param url
     * @return
     */
    public static String get(String url) {
        System.out.println(url);
        StringBuilder sb = new StringBuilder();
        try {
            URL graphURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)graphURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = in.readLine();
            while (line != null) {
                sb.append(line);
                line = in.readLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getAccessToken(sb.toString());
    }
    
    /**
     * 擷取access_tokne=xxx&expires=5182769裡的xxx
     * @param resp
     * @return
     */
    public static String getAccessToken(String resp) {
        System.out.println(resp);
        return resp.substring(resp.indexOf("=") + 1, resp.lastIndexOf("&"));
    }
}
