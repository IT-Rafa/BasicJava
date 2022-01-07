/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.international;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author it-ra
 */
public class BasicTranslation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Lista de idiomas en los que mostrar el mensaje
        List<Locale> locales = Arrays.asList(new Locale[]{Locale.getDefault(), Locale.UK, Locale.ITALY, Locale.FRANCE, Locale.forLanguageTag("pl-PL")});
        // Mostrar mensajes
        BasicTranslation.run(locales);
    }

    public static void run(List<Locale> locales) {
        System.out.println("Java formatter");

        // Captura dia actual
        Date date = new Date();

        // Mostramos mensaje para cada idioma
        locales.forEach(locale -> {
            // Guardamos lista recursos, indicando donde está(ruta) y cual buscar(idioma)
            ResourceBundle bundle = ResourceBundle.getBundle("international\\formats", locale);
            
            // guardamos el recurso concreto del mensaje 
            String pattern = bundle.getString("label");
            
            // Preparamos el mensaje con el formato para el idioma actual 
            MessageFormat formatter = new MessageFormat(pattern, locale);
            
            // Mostramos string traducido (sin patrón)
            System.out.printf("%n%s%n", bundle.getString("lang"));

            // distintos mensajes según cantidad
            for (int i = 0; i <= 3; i++) {
                // Creamos array de objetos con datos mensaje
                Object[] data = {date, "Alice", i};
                // Pasamos datos al mensaje con formato según idioma y mostramos
                System.out.printf("%s%n", formatter.format(data));
            }
        });

    }
}
