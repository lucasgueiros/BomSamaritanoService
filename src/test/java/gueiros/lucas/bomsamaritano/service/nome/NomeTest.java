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
package gueiros.lucas.bomsamaritano.service.nome;

import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucasgueiros
 */
public class NomeTest {
    
    public NomeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setSufixo method, of class Nome.
     */
    @Test public void testSetSufixo1() {
        System.out.println("setSufixo1");
        String sufixo = "";
        Nome instance = new Nome();
        instance.setSufixo(sufixo);
        assertNull(instance.getSufixo());
    }
    
    /**
     * Test of setSufixo method, of class Nome.
     */
    @Test public void testSetSufixo2() {
        System.out.println("setSufixo2");
        String sufixo = "OSB";
        Nome instance = new Nome();
        instance.setSufixo(sufixo);
        assertEquals("OSB",instance.getSufixo());
    }
    
    /**
     * Test of setSufixo method, of class Nome.
     */
    @Test public void testSetSufixo3() {
        System.out.println("setSufixo3");
        String sufixo = null;
        Nome instance = new Nome();
        instance.setSufixo(sufixo);
        assertNull(instance.getSufixo());
    }
    
    /**
     * Test of setSufixo method, of class Nome.
     */
    @Test public void testSetPrefixo1() {
        System.out.println("setPrefixo1");
        String prefixo = "";
        Nome instance = new Nome();
        instance.setPrefixo(prefixo);
        assertNull(instance.getPrefixo());
    }
    
    /**
     * Test of setSufixo method, of class Nome.
     */
    @Test public void testSetPrefixo2() {
        System.out.println("setPrefixo2");
        String prefixo = "Pe.";
        Nome instance = new Nome();
        instance.setPrefixo(prefixo);
        assertEquals("Pe.",instance.getPrefixo());
    }
    
    /**
     * Test of setSufixo method, of class Nome.
     */
    @Test public void testSetPrefixo3() {
        System.out.println("setPrefixo3");
        String prefixo = null;
        Nome instance = new Nome();
        instance.setPrefixo(prefixo);
        assertNull(instance.getPrefixo());
    }

    /**
     * Test of setSobrenome method, of class Nome.
     * /
    @Test (expected = ForaDeRestricaoException.class)
    public void testSetSobrenome1() {
        System.out.println("setSobrenome1");
        String sobrenome = null;
        Nome instance = new Nome();
        instance.setSobrenome(sobrenome);
    }
    
    /**
     * Test of setSobrenome method, of class Nome.
     * /
    @Test (expected = ForaDeRestricaoException.class)
    public void testSetSobrenome2() {
        System.out.println("setSobrenome2");
        String sobrenome = "";
        Nome instance = new Nome();
        instance.setSobrenome(sobrenome);
    }*/

    /**
     * Test of setSobrenome method, of class Nome.
     */
    @Test
    public void testSetSobrenome3() {
        System.out.println("setSobrenome3");
        String sobrenome = "Gueiros";
        Nome instance = new Nome();
        instance.setSobrenome(sobrenome);
        assertEquals("Gueiros", instance.getSobrenome());
    }
    
    /**
     * Test of setSobrenome method, of class Nome.
     * /
    @Test (expected = ForaDeRestricaoException.class)
    public void testSetPrimeiroNome1() {
        System.out.println("setPrimeiroNome1");
        String primeiroNome = null;
        Nome instance = new Nome();
        instance.setPrimeiroNome(primeiroNome);
    }
    
    /**
     * Test of setSobrenome method, of class Nome.
     * /
    @Test (expected = ForaDeRestricaoException.class)
    public void testSetPrimeiroNome2() {
        System.out.println("setPrimeiroNome2");
        String primeiroNome = "";
        Nome instance = new Nome();
        instance.setPrimeiroNome(primeiroNome);
    }*/

    /**
     * Test of setSobrenome method, of class Nome.
     */
    @Test
    public void testSetPrimeiroNome3() {
        System.out.println("setPrimeiroNome3");
        String primeiroNome = "Lucas";
        Nome instance = new Nome();
        instance.setPrimeiroNome(primeiroNome);
        assertEquals("Lucas", instance.getPrimeiroNome());
    }
    
    /**
     * Test of setSufixo method, of class Nome.
     */
    @Test public void testSetNomesDoMeio1() {
        System.out.println("setNomesDoMeio1");
        String nomesDoMeio = "";
        Nome instance = new Nome();
        instance.setNomesDoMeio(nomesDoMeio);
        assertNull(instance.getNomesDoMeio());
    }
    
    /**
     * Test of setSufixo method, of class Nome.
     */
    @Test public void testSetNomesDoMeio2() {
        System.out.println("setNomesDoMeio2");
        String nomesDoMeio = "Dantas de Oliveira";
        Nome instance = new Nome();
        instance.setNomesDoMeio(nomesDoMeio);
        assertEquals("Dantas de Oliveira",instance.getNomesDoMeio());
    }
    
    /**
     * Test of setSufixo method, of class Nome.
     */
    @Test public void testSetNomesDoMeio3() {
        System.out.println("setSufixo3");
        String nomesDoMeio = null;
        Nome instance = new Nome();
        instance.setNomesDoMeio(nomesDoMeio);
        assertNull(instance.getNomesDoMeio());
    }
    
    /**
     * Test of toString method, of class Nome.
     */
    @Test
    public void testToString1() {
        System.out.println("toString");
        Nome instance = new Nome("Frei", "João", "da Silva", "Machado", "OFM");
        String expResult = "Frei João da Silva Machado, OFM";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Nome.
     */
    @Test
    public void testToString2() {
        System.out.println("toString");
        Nome instance = new Nome("João", "Machado");
        String expResult = "João Machado";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Nome.
     */
    @Test
    public void testToString3() {
        System.out.println("toString");
        Nome instance = new Nome("Dom", "João", null, "Machado","OSB");
        String expResult = "Dom João Machado, OSB";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
