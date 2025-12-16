package com.github.joaogavalentim.climatic.app.components;

import java.io.IOException;
import java.net.URL;

import com.github.joaogavalentim.climatic.app.models.Weather;
import com.github.joaogavalentim.climatic.app.services.WeatherService;
import com.github.joaogavalentim.climatic.app.services.exceptions.NotFoundException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Form extends VBox {
    public Form(Stage stage, Scene scene, URL css) {
        Image image = new Image("https://uxwing.com/wp-content/themes/uxwing/download/weather/weather-icon.png");
        ImageView icon = new ImageView(image);
        icon.setPreserveRatio(true);
        icon.setFitHeight(100);
        icon.setFitWidth(100);

        TextField weatherField = new TextField();
        weatherField.setPromptText("Informe a cidade");
        weatherField.setFocusTraversable(false);
        weatherField.getStyleClass().add("field");

        Button searchButton = new Button("Pesquisar");

        searchButton.setOnAction(e -> {
            String city = weatherField.getText().trim();
            WeatherService service = new WeatherService();
            try {
                Weather weather = service.getWeatherResponse(city);
                WeatherCard weatherCard = new WeatherCard(weather, stage, scene, css);

                Scene weatherScene = new Scene(weatherCard, 600, 740);

                stage.setScene(weatherScene);
            } catch (NotFoundException ex) {
                WeatherCard weatherCard = new WeatherCard(null, stage, scene, css);
                Scene weatherNotFoundScene = new Scene(weatherCard, 400, 400);
                stage.setScene(weatherNotFoundScene);
            } catch (IOException ioe) {
                System.err.println("IOException: " + ioe);
            } catch (InterruptedException ine) {
                System.err.println("InterruptedException: " + ine);
            }
        });

        getStyleClass().add("form");
        getChildren().add(icon);
        getChildren().add(weatherField);
        getChildren().add(searchButton);
        setAlignment(Pos.CENTER);
        setSpacing(20);
    }
}
