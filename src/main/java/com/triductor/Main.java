package com.triductor;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        ConsoleInterface consoleInterface = new ConsoleInterface();

        consoleInterface.showWelcomeMessage();
        String inputLang = consoleInterface.selectInputLanguage();
        String outputLang = consoleInterface.selectOutputLanguage();
        String text = consoleInterface.getTextToTranslate();

        String translatedText = translator.translateText(text, inputLang, outputLang);

        consoleInterface.showTranslatedText(translatedText);
    }
}