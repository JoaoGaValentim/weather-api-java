package com.github.joaogavalentim.climatic.app.components;

import java.net.URL;

import com.github.joaogavalentim.climatic.app.dto.WeatherResponse;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeatherCard extends BorderPane {
    public WeatherCard(WeatherResponse response, Stage stage, Scene scene, URL css) {
        Icon icon = new Icon("https://uxwing.com/wp-content/themes/uxwing/download/weather/weather-icon.png");

        Label countryLabel = new Label();
        Label cityLabel = new Label();
        Label currentDateLabel = new Label();
        Label actualTemperatureLabel = new Label();
        Label feelsLikeLabel = new Label();
        Label timeConditionLabel = new Label();
        Label humidityLabel = new Label();
        Label windSpeedLabel = new Label();
        Label atmosphericPressureLabel = new Label();
        Label notFoundLabel = new Label();
        Button backButton = new Button("Pesquisar novamente");

        Header header = new Header();
        VBox data = new VBox();

        if (response != null) {
            countryLabel.setText("País: " + response.weather().getCountry());
            cityLabel.setText("Cidade: " + response.weather().getCity());
            currentDateLabel.setText("Ultima atualização: " + response.weather().getDateTime());
            actualTemperatureLabel.setText("Temperatura atual: " + response.weather().getActualTemperature() + " ˚C");
            feelsLikeLabel.setText("Sensação térmica: " + response.weather().getFeelsLike() + " ˚C");
            timeConditionLabel.setText("Condição do tempo: " + response.weather().getTimeCondition());
            humidityLabel.setText("Humidade do ar: " + response.weather().getHumidity() + "%");
            windSpeedLabel.setText("Velocidade do vento: " + response.weather().getWindSpeed() + " km/h");
            atmosphericPressureLabel
                    .setText("Pressão atmosférica: " + response.weather().getAtmosphericPressure() + " mb");

            data.getChildren().addAll(icon, countryLabel, cityLabel, currentDateLabel, actualTemperatureLabel,
                    feelsLikeLabel,
                    timeConditionLabel, humidityLabel, windSpeedLabel, atmosphericPressureLabel);

        }

        if (response.weather() == null) {
            Icon iconNotFound = new Icon("https://static.thenounproject.com/png/1400397-200.png");
            notFoundLabel.setText("Cidade não encontrada");
            notFoundLabel.getStyleClass().add("not-found");
            data.getChildren().addAll(iconNotFound, notFoundLabel);
        }

        backButton.setOnAction(e -> {
            stage.setScene(scene);
        });

        data.getChildren().add(backButton);
        data.getStyleClass().add("response-form");
        data.setSpacing(20);
        data.setAlignment(Pos.CENTER);
        setTop(header);
        setCenter(data);
        getStyleClass().add("container");
        getStylesheets().add(css.toExternalForm());
    }
}
