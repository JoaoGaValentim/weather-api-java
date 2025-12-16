package com.github.joaogavalentim.climatic.app.models;

import java.time.LocalDateTime;

public class Weather {
    private String country;
    private String city;
    private LocalDateTime dateTime;
    private Double actualTemperature;
    private Double feelsLike;
    private String timeCondition;
    private Double humidity;
    private Double windSpeed;
    private Double atmosphericPressure;

    public Weather() {
        this("", "", LocalDateTime.now(), 0.0, 0.0, "", 0.0, 0.0, 0.0);
    }

    public Weather(String country, String city, LocalDateTime dateTime, Double actualTemperature, Double feelsLike,
            String timeCondition, Double humidity, Double windSpeed, Double atmosphericPressure) {
        this.country = country;
        this.city = city;
        this.dateTime = dateTime;
        this.actualTemperature = actualTemperature;
        this.feelsLike = feelsLike;
        this.timeCondition = timeCondition;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.atmosphericPressure = atmosphericPressure;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Double getActualTemperature() {
        return actualTemperature;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public String getTimeCondition() {
        return timeCondition;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setActualTemperature(Double actualTemperature) {
        this.actualTemperature = actualTemperature;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setTimeCondition(String timeCondition) {
        this.timeCondition = timeCondition;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setAtmosphericPressure(Double atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }
}
