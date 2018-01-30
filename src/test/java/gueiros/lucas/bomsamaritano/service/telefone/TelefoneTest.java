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
package gueiros.lucas.bomsamaritano.service.telefone;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucasgueiros
 */
public class TelefoneTest {
    /**
     * Testa o método setDdd(String).
     * O DDD é limpo.
     */
    @Test
    public void testSetDddAsString1(){
        System.out.println("setDddAsString1");
        Telefone instance = new Telefone();
        instance.setDdd("87");
        int expected = 87;
        assertEquals(expected, instance.getDdd());
    }
    
    /**
     * Testa o método setDdd(String).
     * O DDD é sujo.
     */
    @Test
    public void testSetDddAsString2(){
        System.out.println("setDddAsString2");
        Telefone instance = new Telefone();
        instance.setDdd("(87)");
        int expected = 87;
        assertEquals(expected, instance.getDdd());
    }

    /**
     * Test of setDdd method, of class Telefone.
     * 
     * DDD comum.
     */
    @Test
    public void testSetDdd1() {
        System.out.println("setDdd1");
        int ddd = 87;
        Telefone instance = new Telefone();
        instance.setDdd(ddd);
        assertEquals(ddd, instance.getDdd());
    }
    
    /**
     * Test of setDdd method, of class Telefone.
     * Com DDD diferente, já que 87 é o padrão.
     */
    @Test
    public void testSetDdd2() {
        System.out.println("setDdd2");
        int ddd = 81;
        Telefone instance = new Telefone();
        instance.setDdd(ddd);
        assertEquals(ddd, instance.getDdd());
    }
    
    /**
     * Test of setDdd method, of class Telefone.
     * Com um DDD inválido menor que o possível.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetDdd3() {
        System.out.println("setDdd3");
        int ddd = 9;
        Telefone instance = new Telefone();
        instance.setDdd(ddd);
    }
    
    /**
     * Test of setDdd method, of class Telefone.
     * Com um DDD inválido maior que o possível.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetDdd4() {
        System.out.println("setDdd4");
        int ddd = 120;
        Telefone instance = new Telefone();
        instance.setDdd(ddd);
    }
    
    /**
     * Test of setDdd method, of class Telefone.
     * Com um DDD inválido menor que o possível, mas no limite
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetDdd5() {
        System.out.println("setDdd5");
        int ddd = 10;
        Telefone instance = new Telefone();
        instance.setDdd(ddd);
    }
    
    /**
     * Test of setDdd method, of class Telefone.
     * Com um DDD inválido maior que o possível, mas no limite
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetDdd6() {
        System.out.println("setDdd6");
        int ddd = 100;
        Telefone instance = new Telefone();
        instance.setDdd(ddd);
    }
    
    /**
     * Test of setDdd method, of class Telefone.
     * Com um DDD válido, mas no limite inferior.
     */
    @Test
    public void testSetDdd7() {
        System.out.println("setDdd7");
        int ddd = 11;
        Telefone instance = new Telefone();
        instance.setDdd(ddd);
        assertEquals(ddd, instance.getDdd());
    }
    
    /**
     * Test of setDdd method, of class Telefone.
     * Com um DDD válido, no limite superior.
     */
    @Test
    public void testSetDdd8() {
        System.out.println("setDdd8");
        int ddd = 99;
        Telefone instance = new Telefone();
        instance.setDdd(ddd);
        assertEquals(ddd, instance.getDdd());
    }

    /**
     * Test of setNumero method, of class Telefone.
     * Número válido de 9 dígitos limpo.
     */
    @Test
    public void testSetNumero1() {
        System.out.println("setNumero1");
        String numero = "123456789";
        Telefone instance = new Telefone();
        instance.setNumero(numero);
        assertEquals(numero, instance.getNumero());
    }
    
    /**
     * Test of setNumero method, of class Telefone.
     * Número válido de 8 dígitos limpo.
     */
    @Test
    public void testSetNumero2() {
        System.out.println("setNumero2");
        String numero = "12345678";
        Telefone instance = new Telefone();
        instance.setNumero(numero);
        assertEquals(numero, instance.getNumero());
    }
    
    /**
     * Test of setNumero method, of class Telefone.
     * Número válido de 9 dígitos limpo.
     */
    @Test
    public void testSetNumero3() {
        System.out.println("setNumero3");
        String numero = "1 2345-6789";
        Telefone instance = new Telefone();
        instance.setNumero(numero);
        assertEquals("123456789", instance.getNumero());
    }
    
    /**
     * Test of setNumero method, of class Telefone.
     * Número válido de 8 dígitos limpo.
     */
    @Test
    public void testSetNumero4() {
        System.out.println("setNumero4");
        String numero = "1234-5678";
        Telefone instance = new Telefone();
        instance.setNumero(numero);
        assertEquals("12345678", instance.getNumero());
    }
    
    /**
     * Test of setNumero method, of class Telefone.
     * Número inválido com digitos em ecvesso limpo.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetNumero5() {
        System.out.println("setNumero5");
        String numero = "9123456789";
        Telefone instance = new Telefone();
        instance.setNumero(numero);
    }
    
    /**
     * Test of setNumero method, of class Telefone.
     * Número inválido com dígitos faltando e limpo.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetNumero6() {
        System.out.println("setNumero6");
        String numero = "12345";
        Telefone instance = new Telefone();
        instance.setNumero(numero);
    }
    
    /**
     * Test of setNumero method, of class Telefone.
     * Número inválido com digitos em excesso sujo.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetNumero7() {
        System.out.println("setNumero7");
        String numero = "91 2345-6789"; // isto parece um DDD!!
        Telefone instance = new Telefone();
        instance.setNumero(numero);
    }
    
    /**
     * Test of setNumero method, of class Telefone.
     * Número inválido com dígitos faltando e sujo.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetNumero8() {
        System.out.println("setNumero8");
        String numero = "123-45";
        Telefone instance = new Telefone();
        instance.setNumero(numero);
    }
    
    /**
     * Test of setNumero method, of class Telefone.
     * Número válido e normal, mas SUJO.
     */
    @Test
    public void testSetNumero9() {
        System.out.println("setNumero9");
        String numero = "9 8101 8929";
        Telefone instance = new Telefone();
        instance.setNumero(numero);
        assertEquals("981018929", instance.getNumero());
    }
    
    /**
     * Test of setNumero method, of class Telefone.
     * Número válido e normal, mas SUJO.
     */
    @Test
    public void testSetNumero10() {
        System.out.println("setNumero10");
        String numero = "9 81-0189-29 ";
        Telefone instance = new Telefone();
        instance.setNumero(numero);
        assertEquals("981018929", instance.getNumero());
    }
    
    /**
     * Test of setNumero method, of class Telefone.
     * Número válido e normal, mas SUJO.
     */
    @Test
    public void testSetNumero11() {
        System.out.println("setNumero11");
        String numero = "--9 81a0189b29x";
        Telefone instance = new Telefone();
        instance.setNumero(numero);
        assertEquals("981018929", instance.getNumero());
    }

    /**
     * Test of toString method, of class Telefone.
     * 9 digitos.
     */
    @Test
    public void testToString1() {
        System.out.println("toString1");
        Telefone instance = new Telefone("87","981018929");
        String expResult = "(87) 9 8101-8929";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Telefone.
     * 8 digitos.
     */
    @Test
    public void testToString2() {
        System.out.println("toString2");
        Telefone instance = new Telefone("87","81018929");
        String expResult = "(87) 8101-8929";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
