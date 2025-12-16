package com.github.joaogavalentim.climatic.app.dto;

import java.time.LocalDateTime;

public record WeatherDTO(
                String country,
                String city,
                LocalDateTime dateTime,
                Double actualTemperature,
                Double feelsLike,
                String timeCondition,
                Double humidity,
                Double windSpeed,
                Double atmosphericPressure) {
}
