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
package gueiros.lucas.bomsamaritano.service.util.propriedades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Essa classe serve para acessar arquivos de propriedades. Pode ser acesssada
 * estaticamente ou não!
 *
 * @author lucas
 *
 */
public class ValoresStrings  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7327998256231009889L;
	private final static Properties propriedades = new Properties();
    private final static Map<String,Properties> arquivos = new HashMap<>();
    private final static String PROPRIEDADES = "propriedades";
    private final static String TYPE = ".properties";
    
    static {
        load(propriedades,PROPRIEDADES);
        propriedades.put(PROPRIEDADES, propriedades);
        carregarArquivos();
    }

    public static String getPropriedade(String chave) {
        return getValorLinha(PROPRIEDADES, chave);
    }
    
    private static void clearAndLoad(Properties objeto, String arquivo) {
        objeto.clear();
        load(objeto,arquivo);
    }
    
    private static void load(Properties objeto, String arquivo) {
        InputStream inputStream = ValoresStrings.class.getClassLoader().getResourceAsStream(PROPRIEDADES + TYPE);
        try {
            if (inputStream == null) {
                throw new FileNotFoundException();
            }
            objeto.load(inputStream);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
    /**
     * Retorna um propriedade de tipo String.
     * @param arquivo arquivo onde será procurado
     * @param chave
     * @return
     */
    public static String getValorLinha(String arquivo, String chave) {
        if(arquivo.equals(PROPRIEDADES)){
            return propriedades.getProperty(chave);
        } else {
            return arquivos.get(arquivo).getProperty(chave);
        }
    }
    
    /**
     * Retorna um propriedade de tipo String com line breaks.
     * @param arquivo
     * @param chave
     * @return
     */
    public static String getValorTexto(String arquivo, String chave) {
        return StringEscapeUtils.unescapeJava(getValorLinha(arquivo, chave));
    }

    private static void carregarArquivos() {
        for(String s : getValorLinha(PROPRIEDADES, "arquivos").split(",")) {
            Properties p = new Properties();
            load(p,getValorLinha(PROPRIEDADES, "arquivo." + s));
            arquivos.put(s, p);
        }
        
        
    }
    
}
