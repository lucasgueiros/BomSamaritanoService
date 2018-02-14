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

import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author lucasgueiros
 */
public class EnderecoEditControlTest {
    
    private EnderecoEditView editView;
    private Repositorio<Endereco> repositorio;
    private EnderecoEditControl editControl;
    
    @Before
    public void setandoMocks(){
        editView = mock(EnderecoEditView.class);
        repositorio = mock(Repositorio.class);
        editControl = new EnderecoEditControl(editView,repositorio);
    }
    
    /**
     * Test of iniciar method, of class EnderecoEditControl.
     */
    @Test
    public void testIniciar() {
        editControl.iniciar();
        verify(editView,times(1)).construirView();
        verify(editView,times(1)).setVisible(true);
    }

    /**
     * Test of getModel method, of class EnderecoEditControl.
     */
    @Test
    public void testGetModel() {
        when(editView.getLogradouroText()).thenReturn("logradouro");
        when(editView.getBairroText()).thenReturn("bairro");
        when(editView.getNumeroText()).thenReturn("321");
        when(editView.getComplementoText()).thenReturn("Complemento");
        Endereco endereco = editControl.getResultadoConstrucao().getModel();
        assertEquals("logradouro", endereco.getLogradouro());
        assertEquals("bairro", endereco.getBairro());
        assertEquals(321, endereco.getNumero());
        assertEquals("Complemento", endereco.getComplemento());
    }
    
    // TODO adicionar mais testes de getModel()
}
