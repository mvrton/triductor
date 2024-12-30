package com.triductor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TranslatorApp extends Application {
    private Translator translator = new Translator();

    @Override
    public void start(Stage primaryStage) {

        Label welcomeLabel = new Label("¡Bienvenido a 3ductor!");
        welcomeLabel.setFont(Font.font("Arial", 20));

        Label inputLangLabel = new Label("Selecciona el idioma de origen:");
        ComboBox<String> inputLangComboBox = new ComboBox<>();
        inputLangComboBox.getItems().addAll("Español", "Inglés");

        Label outputLangLabel = new Label("Selecciona el idioma de destino:");
        ComboBox<String> outputLangComboBox = new ComboBox<>();
        outputLangComboBox.getItems().addAll("Inglés", "Español", "Japonés");

        Label textToTranslateLabel = new Label("Texto a traducir:");
        TextField textField = new TextField();

        Button translateButton = new Button("Traducir");
        Label translatedTextLabel = new Label("Texto traducido:");

        translateButton.setOnAction(e -> {
            String inputLang = inputLangComboBox.getValue().equals("Español") ? "es" : "en";
            String outputLang = outputLangComboBox.getValue().equals("Español") ? "es" :
                    (outputLangComboBox.getValue().equals("Inglés") ? "en" : "ja");
            String text = textField.getText();
            String translatedText = translator.translateText(text, inputLang, outputLang);
            translatedTextLabel.setText("Texto traducido: " + translatedText);
        });


        VBox layout = new VBox(10, welcomeLabel, inputLangLabel, inputLangComboBox,
                outputLangLabel, outputLangComboBox, textToTranslateLabel, textField, translateButton, translatedTextLabel);
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center;");
        
        Scene scene = new Scene(layout, 400, 400);
        

        primaryStage.setTitle("Traductor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
