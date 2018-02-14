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
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioFactory;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;
import gueiros.lucas.bomsamaritano.service.util.ui.EditControl;
import gueiros.lucas.bomsamaritano.service.util.ui.EditView;

/**
 *
 * @author lucasgueiros
 */
public class ContribuinteEditControl implements EditControl<Contribuinte>{
    
    private ContribuinteEditView editView;
    private Contribuinte model;
    
    private NomeEditControl nomeEditControl;
    private EnderecoEditControl enderecoEditControl;
    private TelefoneEditControl telefoneEditControl;
    private Repositorio<Contribuinte> repositorio;

    public ContribuinteEditControl(ContribuinteEditView editView, 
            NomeEditControl nomeEditControl, 
            EnderecoEditControl enderecoEditControl, 
            TelefoneEditControl telefoneEditControl, 
            Repositorio<Contribuinte> repositorio) {
        this.editView = editView;
        this.nomeEditControl = nomeEditControl;
        this.enderecoEditControl = enderecoEditControl;
        this.telefoneEditControl = telefoneEditControl;
        this.repositorio = repositorio;
    }

    public ContribuinteEditControl() {
        this(new ContribuinteEditView(),
                new NomeEditControl(),
                new EnderecoEditControl(),
                new TelefoneEditControl(),
                RepositorioFactory.getRepositorio(Contribuinte.class));
    }

    @Override
    public void iniciar() {
        
        editView.setNomeEditView(nomeEditControl.getEditView());
        editView.setEnderecoEditView ( enderecoEditControl.getEditView());
        editView.setTelefoneEditView ( telefoneEditControl.getEditView());
        
        nomeEditControl.iniciar();
        enderecoEditControl.iniciar();
        telefoneEditControl.iniciar();
        
        editView.construirView();
        editView.setVisible(true);
    }

    @Override
    public EditView getEditView() {
        return editView;
    }

    @Override
    public ResultadoConstrucao<Contribuinte> getResultadoConstrucao() {
        ResultadoConstrucao<Nome> nome = nomeEditControl.getResultadoConstrucao();
        ResultadoConstrucao<Endereco> endereco = enderecoEditControl.getResultadoConstrucao();
            ResultadoConstrucao<Telefone> telefone = telefoneEditControl.getResultadoConstrucao();
        
        return new ContribuinteConstrutor()
        		.setNome(nome)
        		.setEndereco(endereco)
        		.setTelefone(telefone)
        		.construir();
    }

    @Override
    public String getEntidade() {
        return "Contribuinte";
    }
    
    @Override
    public void adicionar(Contribuinte tipo) {
        // desmebre
        Nome nome = tipo.getNome();
        Telefone telefone = tipo.getTelefone();
        Endereco endereco = tipo.getEndereco();
        
        // mande cada qual ao seu respectivo editcontrol
        this.nomeEditControl.adicionar(nome);
        this.enderecoEditControl.adicionar(endereco);
        this.telefoneEditControl.adicionar(telefone);
        
        // agora adicione o seu.
        repositorio.adicionar(tipo);
    }
    
}
