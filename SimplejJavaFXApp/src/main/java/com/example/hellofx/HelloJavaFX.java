package com.example.hellofx;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class HelloJavaFX extends Application {
    public void start(Stage stage) {
        Label message = new Label("Welcome, Alex Musonda Mulenga ID 202505766");
        Button button = new Button("Press");
        button.setOnAction(event -> message.setText("Good job Alex."));
        Button resetButton = new Button("Rest");
        resetButton.setOnAction(event->message.setText("Welcome, Alex Musonda Mulenga ID 202505766"));
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(message,button,resetButton);
        Scene scene = new Scene(layout, 500, 300);
        stage.setTitle("My First JavaFX Application ID 202505766");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}