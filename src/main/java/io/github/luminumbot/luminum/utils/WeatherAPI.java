package io.github.luminumbot.luminum.utils;
import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.github.luminumbot.luminum.Config;
import org.json.*;

public class WeatherAPI {
    private static final String BASE_URL = "https://api.weatherapi.com/v1/";
    private static final String API_KEY = Config.WEATHER_TOKEN;

    public static List<String> getWeather(String city) {
        String url = BASE_URL + "current.json?key=" + API_KEY + "&q=" + city;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject json = new JSONObject(response.toString());
            JSONObject current = json.getJSONObject("current");
            String condition = current.getJSONObject("condition").getString("text");
            String iconUrl = "https:" + current.getJSONObject("condition").getString("icon");
            return Arrays.asList("The weather in " + city + " is " + condition + ".", "Here's the icon for the current weather: " + iconUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.singletonList(e.getMessage());
        }
    }
}