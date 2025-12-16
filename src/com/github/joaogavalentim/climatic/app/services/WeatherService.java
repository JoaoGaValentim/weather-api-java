package com.github.joaogavalentim.climatic.app.services;

import java.io.IOException;

import com.github.joaogavalentim.climatic.app.dto.WeatherDTO;
import com.github.joaogavalentim.climatic.app.models.Weather;

public class WeatherService {

    public WeatherService() {
    }

    public Weather getWeatherResponse(String city) throws IOException, InterruptedException {
        Request request = new Request();
        WeatherDTO wDto = request.get(city);
        Weather weather = new Weather(
                wDto.country(),
                wDto.city(),
                wDto.dateTime(),
                wDto.actualTemperature(),
                wDto.feelsLike(),
                wDto.timeCondition(),
                wDto.humidity(),
                wDto.windSpeed(),
                wDto.atmosphericPressure());
        return weather;
    }
}
