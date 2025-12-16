package com.github.joaogavalentim.climatic.app.components;

import java.net.URL;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Container extends BorderPane {
    public Container() {
    }

    public void loadHandlers(Stage stage, Scene scene, URL css) {
        setTop(new Header());
        setCenter(new Form(stage, scene, css));
        getStyleClass().add("container");
    }
}
