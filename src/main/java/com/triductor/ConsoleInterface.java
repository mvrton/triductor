package com.triductor;
import java.util.Scanner;

public class ConsoleInterface {
    private Scanner scanner = new Scanner(System.in);

    public void showWelcomeMessage(){
        System.out.println("¡Bienvenido a 3ductor!");
    }

    public String selectInputLanguage(){
        System.out.println("Selecciona el idioma de origen:");
        System.out.println("(1) Español");
        System.out.println("(2) Inglés");
        int choice = scanner.nextInt();
        return (choice == 1) ? "es" : "en";
    }

    public String selectOutputLanguage() {
        System.out.println("Selecciona el idioma al que deseas traducir:");
        System.out.println("(1) Español");
        System.out.println("(2) Inglés");
        System.out.println("(3) Japonés");
        int choice = scanner.nextInt();
        return switch (choice) {
            case 1 -> "es";
            case 2 -> "en";
            case 3 -> "ja";
            default -> "en";
        };
    }

    public String getTextToTranslate() {
        scanner.nextLine();
        System.out.println("Escribe el texto que quieres traducir:");
        return scanner.nextLine();
    }

    public void showTranslatedText(String translatedText) {
        System.out.println("Texto traducido: " + translatedText);
    }
}

