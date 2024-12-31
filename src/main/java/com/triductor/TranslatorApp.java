package com.triductor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TranslatorApp extends Application {
    private Translator translator = new Translator();

    @Override
    public void start(Stage primaryStage) {

        Label welcomeLabel = new Label("¡Bienvenido a 3ductor!");
        welcomeLabel.setFont(Font.font("Arial", 20));
        welcomeLabel.getStyleClass().add("welcome");

        Label inputLangLabel = new Label("Selecciona el idioma de origen:");
        ComboBox<String> inputLangComboBox = new ComboBox<>();
        inputLangComboBox.getItems().addAll("Español", "Inglés");
        inputLangComboBox.setValue("Español");

        Label outputLangLabel = new Label("Selecciona el idioma de destino:");
        ComboBox<String> outputLangComboBox = new ComboBox<>();
        outputLangComboBox.getItems().addAll("Inglés", "Español", "Japonés");
        outputLangComboBox.setValue("Inglés");

        Label textToTranslateLabel = new Label("Texto a traducir:");
        TextField textField = new TextField();

        Button translateButton = new Button("Traducir");
        Label translatedTextLabel = new Label();
        translatedTextLabel.getStyleClass().add("text-output");

        Button copyButton = new Button("Copiar");
        copyButton.setDisable(true);

        translateButton.setOnAction(e -> {
            String inputLang = inputLangComboBox.getValue().equals("Español") ? "es" : "en";
            String outputLang = outputLangComboBox.getValue().equals("Español") ? "es" :
                    (outputLangComboBox.getValue().equals("Inglés") ? "en" : "ja");
            String text = textField.getText();

            if (text.isEmpty()) {
                translatedTextLabel.setText("Por favor, introduce texto para traducir.");
                copyButton.setDisable(true);
            } else {
                String translatedText = translator.translateText(text, inputLang, outputLang);
                translatedTextLabel.setText("Texto traducido: " + translatedText);
                copyButton.setDisable(false);
            }
        });

        copyButton.setOnAction(e -> {
            String translatedText = translatedTextLabel.getText().replace("Texto traducido: ", "");
            if (!translatedText.isEmpty()) {
                final Clipboard clipboard = Clipboard.getSystemClipboard();
                final ClipboardContent content = new ClipboardContent();
                content.putString(translatedText);
                clipboard.setContent(content);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Texto copiado al portapapeles.");
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, welcomeLabel, inputLangLabel, inputLangComboBox,
                outputLangLabel, outputLangComboBox, textToTranslateLabel, textField,
                translateButton, translatedTextLabel, copyButton);
        layout.getStyleClass().add("root");

        Scene scene = new Scene(layout, 400, 400);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setTitle("3ductor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
