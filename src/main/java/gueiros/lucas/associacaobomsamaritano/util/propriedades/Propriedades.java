/* 
 * Copyright 2018 Lucas Gueiros 
 *
 * This file is part of BomSamaritanoService.
 * BomSamaritanoService is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
