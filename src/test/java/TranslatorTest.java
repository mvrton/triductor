import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class TranslatorTest {
    public static void main(String[] args) {
        // Utiliza las credenciales configuradas en la variable de entorno
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        Translation translation = translate.translate(
            "Hola, ¿cómo estás?",
            Translate.TranslateOption.sourceLanguage("es"),
            Translate.TranslateOption.targetLanguage("en")
        );

        System.out.println("Translated text: " + translation.getTranslatedText());
    }
}
