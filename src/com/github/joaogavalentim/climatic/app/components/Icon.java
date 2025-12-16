package com.github.joaogavalentim.climatic.app.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Icon extends ImageView {
    public Icon(String url) {
        Image image = new Image(url);

        setImage(image);
        setPreserveRatio(true);
        setFitHeight(100);
        setFitWidth(100);
    }
}
