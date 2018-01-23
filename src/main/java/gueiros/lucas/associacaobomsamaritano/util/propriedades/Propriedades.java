package gueiros.lucas.associacaobomsamaritano.util.propriedades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

/**
 * Essa classe serve para acessar arquivos de propriedades. Pode ser acesssada
 * estaticamente ou não!
 *
 * @author lucas
 *
 */
public class Propriedades  implements Serializable {

    private static Properties properties;
    
    static {
        properties = new Properties();
        InputStream inputStream = Propriedades.class.getClassLoader().getResourceAsStream("strings.properties");
        try {
            if (inputStream == null) {
                throw new FileNotFoundException();
            }
            properties.load(inputStream);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static String getString(String key) {
        return properties.getProperty(key);
    }
    
    public String get(String key) {
        return Propriedades.getString(key);
    }    
    
}
