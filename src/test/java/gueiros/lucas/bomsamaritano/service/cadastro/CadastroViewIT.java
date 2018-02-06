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
import gueiros.lucas.bomsamaritano.service.nome.NomeEditControl;
import gueiros.lucas.bomsamaritano.service.util.intefaces.EditControl;
import javax.swing.JComponent;
import javax.swing.JDialog;
import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.finder.NamedComponentFinder;
import org.junit.Test;
import javax.swing.JButton;
import static org.junit.Assert.*;

/**
 *
 * @author lucasgueiros
 */
public class CadastroViewIT extends JFCTestCase {
    
    private CadastroControl<Nome> control = null;
    private CadastroView<Nome> view = null;
    
    public CadastroViewIT(String nome) {
        super(nome);
    }
    
    public void setUp() throws Exception{
        super.setUp();
        setHelper(new JFCTestHelper());
        EditControl<Nome> editControl = new NomeEditControl();
        control = new CadastroControl<>(editControl);
        view = (CadastroView<Nome>) control.getView();
        control.iniciar();
    }
    
    public void tearDown() throws Exception {
        view = null;
        control = null;
        getHelper().cleanUp(this);
        super.tearDown();
    }

    /**
     * Tudo deve iniciar vazio, clicar vazio exibe um erro!
     */
    @Test
    public void testCadastrar1() {
        JDialog dialog;// ?
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "CadastrarButton" );
        JButton cadastrarButton = ( JButton ) finder.find( view, 0);
        assertNotNull( "Botao cadastrar não encontrado", cadastrarButton);

      //getHelper().enterClickAndLeave( new MouseEventData( this, enterButton ) );
      /*DialogFinder dFinder = new DialogFinder( loginScreen );
    18:   showingDialogs = dFinder.findAll();
    19:   assertEquals( "Number of dialogs showing is wrong", 1, showingDialogs.size( ) );
    20:   dialog = ( JDialog )showingDialogs.get( 0 );
    21:   assertEquals( "Wrong dialog showing up", "Login Error", dialog.getTitle( ) );
    22:   getHelper().disposeWindow( dialog, this );*/
    }
    
}
