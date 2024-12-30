package com.triductor;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class Translator {

    public String translateText(String text, String inputLang, String outputLang) {
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        
        Translation translation = translate.translate(
            text,
            Translate.TranslateOption.sourceLanguage(inputLang),
            Translate.TranslateOption.targetLanguage(outputLang)
        );

        return translation.getTranslatedText();
    }
}
