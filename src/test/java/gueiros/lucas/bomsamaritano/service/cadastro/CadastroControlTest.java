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
package gueiros.lucas.bomsamaritano.service.cadastro;

import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.util.intefaces.EditControl;
import javax.swing.JPanel;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Fiz estes testes usando a Classe NOME.
 * @author lucasgueiros
 */
public class CadastroControlTest {
    
    @Before public void before(){
        model = new Nome("Lucas", "Gueiros");
        editControl = mock(EditControl.class);
        editView = mock(JPanel.class);
        view = mock(CadastroView.class);
        when(editControl.getEditView()).thenReturn(editView);
        cadastroControl = new CadastroControl<>(view,editControl);
        when(editControl.getModel()).thenReturn(model);
    }

    private EditControl<Nome> editControl;
    private CadastroControl<Nome> cadastroControl;
    private JPanel editView;
    private CadastroView<Nome> view;
    private Nome model;
    
    @Test
    public void testInicar() {
        cadastroControl.iniciar();
        verify(editControl,times(1)).iniciar();
        verify(view,times(1)).setEditView(editView);
        verify(view,times(1)).addCadastrarListener(any());
        verify(view,times(1)).iniciar();
        verify(view,times(1)).setVisible(true);
    }
    
}
