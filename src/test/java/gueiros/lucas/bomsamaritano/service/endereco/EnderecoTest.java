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
package gueiros.lucas.bomsamaritano.service.endereco;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 *
 * @author lucasgueiros
 */
public class EnderecoTest {
    
    @Test
    public void testSetLogradouro1() {
        String esperado = "Rua Ailton Vilela de Moraes";
        Endereco instance = new Endereco();
        instance.setLogradouro(esperado);
        Assert.assertEquals(esperado,instance.getLogradouro());
    }
 
    @Test (expected = IllegalArgumentException.class)
    public void testSetLogradouro2() {
        String esperado = "";
        Endereco instance = new Endereco();
        instance.setLogradouro(esperado);
    }
  
    @Test (expected = IllegalArgumentException.class)
    public void testSetLogradouro3() {
        String esperado = null;
        Endereco instance = new Endereco();
        instance.setLogradouro(esperado);
    }

    @Test
    public void testSetNumero1() {
        int numero = 12;
        Endereco instance = new Endereco();
        instance.setNumero(numero);
        Assert.assertTrue(instance.getNumero()==12);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetNumero2() {
        int numero = 0;
        Endereco instance = new Endereco();
        instance.setNumero(numero);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetNumero3() {
        int numero = -10;
        Endereco instance = new Endereco();
        instance.setNumero(numero);
    }

    @Test
    public void testSetBairro1() {
        String esperado = "Rosarinho";
        Endereco instance = new Endereco();
        instance.setBairro(esperado);
        Assert.assertEquals(esperado,instance.getBairro());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetBairro2() {
        String esperado = "";
        Endereco instance = new Endereco();
        instance.setBairro(esperado);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetBairro3() {
        String esperado = null;
        Endereco instance = new Endereco();
        instance.setBairro(esperado);
    }

    @Test
    public void testSetComplemento1() {
        String esperado = "apto. 502";
        Endereco instance = new Endereco();
        instance.setComplemento(esperado);
        Assert.assertEquals(esperado,instance.getComplemento());
    }
    
    @Test
    public void testSetComplemento2() {
        String esperado = "";
        Endereco instance = new Endereco();
        instance.setComplemento(esperado);
        Assert.assertNull(instance.getComplemento());
    }
    
    @Test
    public void testSetComplemento3() {
        String esperado = null;
        Endereco instance = new Endereco();
        instance.setComplemento(esperado);
        Assert.assertNull(instance.getComplemento());
    }
}
