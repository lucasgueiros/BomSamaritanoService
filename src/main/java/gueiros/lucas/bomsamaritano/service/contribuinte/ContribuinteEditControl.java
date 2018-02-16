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

import java.util.List;

import gueiros.lucas.bomsamaritano.service.endereco.Endereco;
import gueiros.lucas.bomsamaritano.service.endereco.EnderecoEditControl;
import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.nome.NomeEditControl;
import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.telefone.TelefoneEditControl;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Filtro;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioJDBC;
import gueiros.lucas.bomsamaritano.service.util.ui.EditControl;
import gueiros.lucas.bomsamaritano.service.util.ui.EditView;

/**
 *
 * @author lucasgueiros
 */
public class ContribuinteEditControl implements EditControl<Contribuinte>{
    
    private ContribuinteEditView editView;
    
    private NomeEditControl nomeEditControl;
    private EnderecoEditControl enderecoEditControl;
    private TelefoneEditControl telefoneEditControl;
    private Repositorio<Contribuinte> repositorio;

    public ContribuinteEditControl(ContribuinteEditView editView, 
            NomeEditControl nomeEditControl, 
            EnderecoEditControl enderecoEditControl, 
            TelefoneEditControl telefoneEditControl, 
            Repositorio<Contribuinte> repositorio) {
        this(editView,nomeEditControl,enderecoEditControl,telefoneEditControl);
        this.repositorio = repositorio;
    }

    private ContribuinteEditControl(ContribuinteEditView editView, 
            NomeEditControl nomeEditControl, 
            EnderecoEditControl enderecoEditControl, 
            TelefoneEditControl telefoneEditControl) {
        this.editView = editView;
        this.nomeEditControl = nomeEditControl;
        this.enderecoEditControl = enderecoEditControl;
        this.telefoneEditControl = telefoneEditControl;
    }
    
    public ContribuinteEditControl() {
        this(new ContribuinteEditView(),
                new NomeEditControl(),
                new EnderecoEditControl(),
                new TelefoneEditControl());
        this.repositorio = new RepositorioJDBC<Contribuinte>(new ContribuinteConversor(this));
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
        		.setNomeRC(nome)
        		.setEnderecoRC(endereco)
        		.setTelefoneRC(telefone)
        		.construir();
    }

    @Override
    public String getEntidade() {
        return "Contribuinte";
    }
    
    @Override
    public Contribuinte adicionar(Contribuinte tipo) {
        // desmebre
        Nome nome = tipo.getNome();
        Telefone telefone = tipo.getTelefone();
        Endereco endereco = tipo.getEndereco();
        
        // mande cada qual ao seu respectivo editcontrol
        // e receba de volta o objeto com ID
        nome = this.nomeEditControl.adicionar(nome);
        endereco = this.enderecoEditControl.adicionar(endereco);
        telefone = this.telefoneEditControl.adicionar(telefone);
        
        // Agora recire o seu usando os objetos com ID
        tipo = new Contribuinte.Construtor()
        .setNome(nome)
        .setEndereco(endereco)
        .setTelefone(telefone)
        .construir() // TODO é bom fazer verificacoes
        .getModel();
        
        // agora adicione o seu.
        return repositorio.adicionar(tipo);
    }

	@Override
	public List<Contribuinte> recuperar(Filtro<Contribuinte> filtro) {
		return this.repositorio.recuperar(filtro);
	}
    
    List<Nome> recuperarNome(Filtro<Nome> filtro) {
    	return this.nomeEditControl.recuperar(filtro);
    }
    
    List<Endereco> recuperarEndereco(Filtro<Endereco> filtro) {
    	return this.enderecoEditControl.recuperar(filtro);
    }
    
    List<Telefone> recuperarTelefone(Filtro<Telefone> filtro) {
    	return this.telefoneEditControl.recuperar(filtro);
    }
    
}
