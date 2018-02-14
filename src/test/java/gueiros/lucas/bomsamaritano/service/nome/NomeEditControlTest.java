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

import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.nome.NomeEditControl;
import gueiros.lucas.bomsamaritano.service.nome.NomeEditView;
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
public class NomeEditControlTest {
    
    private NomeEditView editView;
    private Repositorio<Nome> repositorio;
    private NomeEditControl editControl;
    
    @Before
    public void setandoMocks(){
        editView = mock(NomeEditView.class);
        repositorio = mock(Repositorio.class);
        editControl = new NomeEditControl(editView,repositorio);
    }
    
    /**
     * Test of iniciar method, of class NomeEditControl.
     */
    @Test
    public void testIniciar() {
        editControl.iniciar();
        verify(editView,times(1)).construirView();
        verify(editView,times(1)).setVisible(true);
    }

    /**
     * Test of getModel method, of class NomeEditControl.
     */
    @Test
    public void testGetModel() {
        when(editView.getPrimeiroNomeText()).thenReturn("Lucas");
        when(editView.getNomesDoMeioText()).thenReturn("Dantas");
        when(editView.getSobrenomeText()).thenReturn("Gueiros");
        Nome nome = editControl.getResultadoConstrucao().getModel();
        assertEquals("Lucas", nome.getPrimeiroNome());
        assertEquals("Dantas", nome.getNomesDoMeio());
        assertEquals("Gueiros", nome.getSobrenome());
    }
    
    // TODO adicionar mais testes de getModel()
}
