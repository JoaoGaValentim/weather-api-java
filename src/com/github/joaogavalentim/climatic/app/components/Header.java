package com.github.joaogavalentim.climatic.app.components;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Header extends VBox {
    public Header() {
        Label titleApp = new Label("WeatherFX");
        getChildren().add(titleApp);
        getStyleClass().add("header");
    }
}
