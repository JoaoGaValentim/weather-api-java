module climatic.app {
    requires java.base;
    requires java.net.http;
    requires org.json;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;
    requires javafx.swing;

    opens com.github.joaogavalentim.climatic.app to javafx.graphics;
}
