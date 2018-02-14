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
package gueiros.lucas.bomsamaritano.service.contribuinte;

import gueiros.lucas.bomsamaritano.service.endereco.Endereco;
import gueiros.lucas.bomsamaritano.service.endereco.EnderecoEditControl;
import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.nome.NomeEditControl;
import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.telefone.TelefoneEditControl;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;

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
public class ContribuinteEditControlTest {
    
    private ContribuinteEditControl editControl;
    private ContribuinteEditView editView;
    private NomeEditControl nomeEditControl;
    private EnderecoEditControl enderecoEditControl;
    private TelefoneEditControl telefoneEditControl;
    private Repositorio<Contribuinte> repositorio;
    
    @Before
    public void before(){
        editView = mock(ContribuinteEditView.class);
        nomeEditControl = mock(NomeEditControl.class);
        enderecoEditControl = mock(EnderecoEditControl.class);
        telefoneEditControl = mock(TelefoneEditControl.class);
        repositorio = mock(Repositorio.class);
        editControl = new ContribuinteEditControl(editView, nomeEditControl, enderecoEditControl, telefoneEditControl, repositorio);
    }
    
    @Test public void testIniciar(){
        editControl.iniciar();
        verify(editView,times(1)).construirView();
        verify(editView,times(1)).setVisible(true);
        verify(nomeEditControl,times(1)).iniciar();
        verify(telefoneEditControl,times(1)).iniciar();
        verify(enderecoEditControl,times(1)).iniciar();
    }
    
    @Test public void testGetModel() {
        ResultadoConstrucao nome = mock(ResultadoConstrucao.class);
        ResultadoConstrucao endereco = mock(ResultadoConstrucao.class);
        ResultadoConstrucao telefone = mock(ResultadoConstrucao.class);
        when(nome.getModel()).thenReturn(new Nome("Lucas", "Gueiros"));
        when(endereco.getModel()).thenReturn(new Endereco("logradouro", 10, "bairro", "complemento"));
        when(telefone.getModel()).thenReturn(new Telefone("123456789"));
        
        when(nomeEditControl.getResultadoConstrucao()).thenReturn(nome);
        when(enderecoEditControl.getResultadoConstrucao()).thenReturn(endereco);
        when(telefoneEditControl.getResultadoConstrucao()).thenReturn(telefone);
        
        Contribuinte contribuinte = editControl.getResultadoConstrucao().getModel();
        
        assertEquals(endereco, contribuinte.getEndereco());
        assertEquals(nome, contribuinte.getNome());
        assertEquals(telefone, contribuinte.getTelefone());
    }
}
