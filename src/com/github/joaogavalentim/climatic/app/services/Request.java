package com.github.joaogavalentim.climatic.app.services;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;

import com.github.joaogavalentim.climatic.app.dto.WeatherDTO;
import com.github.joaogavalentim.climatic.app.services.exceptions.NotFoundException;

public class Request {
    private final String WEATHER_URL;

    public Request() throws IOException {
        String apiKey = Files.readString(Path.of("api_key.txt")).trim();
        WEATHER_URL = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&lang=pt&q=";
    }

    public WeatherDTO get(String city) throws IOException, InterruptedException {
        String cityEncoded = URLEncoder.encode(city, StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(WEATHER_URL + cityEncoded)).build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String conent = response.body();

        if (conent.contains("\"code\":1006")) {
            throw new NotFoundException();
        }

        JSONObject data = new JSONObject(conent);
        JSONObject location = data.getJSONObject("location");
        JSONObject weatherData = data.getJSONObject("current");
        JSONObject weatherCondiditon = weatherData.getJSONObject("condition");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        WeatherDTO dto = new WeatherDTO(
                location.getString("country"),
                location.getString("name"),
                LocalDateTime.parse(location.getString("localtime"), formatter),
                weatherData.getDouble("temp_c"),
                weatherData.getDouble("feelslike_c"),
                weatherCondiditon.getString("text"),
                Double.valueOf(weatherData.getInt("humidity")),
                weatherData.getDouble("wind_kph"),
                weatherData.getDouble("pressure_mb"));

        return dto;
    }
}
