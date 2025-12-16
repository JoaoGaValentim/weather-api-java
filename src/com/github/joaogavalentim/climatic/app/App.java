package com.github.joaogavalentim.climatic.app;

import java.io.IOException;
import java.net.URL;

import com.github.joaogavalentim.climatic.app.components.Container;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL css = getClass().getResource("resources/style.css");

        Container container = new Container();
        Scene scene = new Scene(container, 500, 500);

        container.loadHandlers(primaryStage, scene, css);
        scene.getStylesheets().add(css.toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        launch(args);
    }
}
