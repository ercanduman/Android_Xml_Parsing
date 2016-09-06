package ercanduman.androidxmlparsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpManager {
    private static BufferedReader reader;
    private static URL url;
    private static HttpURLConnection connection;
    private static StringBuilder builder;

    public static String getDataFromURL(String uri) {
        try {
            url = new URL(uri);
            connection = (HttpURLConnection) url.openConnection();
            builder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
