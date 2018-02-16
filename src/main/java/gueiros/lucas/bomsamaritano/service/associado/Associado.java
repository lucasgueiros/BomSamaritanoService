/*******************************************************************************
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
 *******************************************************************************/
package gueiros.lucas.bomsamaritano.service.associado;

import gueiros.lucas.bomsamaritano.service.contribuinte.Contribuinte;
import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.endereco.Endereco;
import gueiros.lucas.bomsamaritano.service.util.tipos.*;
import java.time.LocalDate;

/**
 *
 * @author lucasgueiros
 */
public class Associado {
    
    private int id;

    private Contribuinte contribuinte;

    private LocalDate dataDeNascimento;

    private RG identidade;

    private CPF cpf;

    private NIS nis;

    private TituloEleitoral tituloDeEleitor;

    private Email email;

    private Endereco endereco;

    private Facebook facebook;

    private Profissao profissao;

    private Religiao religiao;

    private Telefone telefone;

    private int numeroDeFilhos;

    private LocalDate dataDeAssociacao;

    public Associado(int id, Contribuinte contribuinte, LocalDate dataDeNascimento, RG identidade, CPF cpf, NIS nis, TituloEleitoral tituloDeEleitor, Email email, Endereco endereco, Facebook facebook, Profissao profissao, Religiao religiao, Telefone telefone, int numeroDeFilhos, LocalDate dataDeAssociacao) {
        this.id = id;
        this.contribuinte = contribuinte;
        this.dataDeNascimento = dataDeNascimento;
        this.identidade = identidade;
        this.cpf = cpf;
        this.nis = nis;
        this.tituloDeEleitor = tituloDeEleitor;
        this.email = email;
        this.endereco = endereco;
        this.facebook = facebook;
        this.profissao = profissao;
        this.religiao = religiao;
        this.telefone = telefone;
        this.numeroDeFilhos = numeroDeFilhos;
        this.dataDeAssociacao = dataDeAssociacao;
    }

    /**
     * Get the value of dataDeAssociacao
     *
     * @return the value of dataDeAssociacao
     */
    public LocalDate getDataDeAssociacao() {
        return dataDeAssociacao;
    }

    /**
     * Set the value of dataDeAssociacao
     *
     * @param dataDeAssociacao new value of dataDeAssociacao
     */
    public void setDataDeAssociacao(LocalDate dataDeAssociacao) {
        this.dataDeAssociacao = dataDeAssociacao;
    }

    /**
     * Get the value of numeroDeFilhos
     *
     * @return the value of numeroDeFilhos
     */
    public int getNumeroDeFilhos() {
        return numeroDeFilhos;
    }

    /**
     * Set the value of numeroDeFilhos
     *
     * @param numeroDeFilhos new value of numeroDeFilhos
     */
    public void setNumeroDeFilhos(int numeroDeFilhos) {
        this.numeroDeFilhos = numeroDeFilhos;
    }

    /**
     * Get the value of telefone
     *
     * @return the value of telefone
     */
    public Telefone getTelefone() {
        return telefone;
    }

    /**
     * Set the value of telefone
     *
     * @param telefone new value of telefone
     */
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    /**
     * Get the value of religiao
     *
     * @return the value of religiao
     */
    public Religiao getReligiao() {
        return religiao;
    }

    /**
     * Set the value of religiao
     *
     * @param religiao new value of religiao
     */
    public void setReligiao(Religiao religiao) {
        this.religiao = religiao;
    }

    /**
     * Get the value of profissao
     *
     * @return the value of profissao
     */
    public Profissao getProfissao() {
        return profissao;
    }

    /**
     * Set the value of profissao
     *
     * @param profissao new value of profissao
     */
    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    /**
     * Get the value of facebook
     *
     * @return the value of facebook
     */
    public Facebook getFacebook() {
        return facebook;
    }

    /**
     * Set the value of facebook
     *
     * @param facebook new value of facebook
     */
    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }

    /**
     * Get the value of endereco
     *
     * @return the value of endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Set the value of endereco
     *
     * @param endereco new value of endereco
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * Get the value of tituloDeEleitor
     *
     * @return the value of tituloDeEleitor
     */
    public TituloEleitoral getTituloDeEleitor() {
        return tituloDeEleitor;
    }

    /**
     * Set the value of tituloDeEleitor
     *
     * @param tituloDeEleitor new value of tituloDeEleitor
     */
    public void setTituloDeEleitor(TituloEleitoral tituloDeEleitor) {
        this.tituloDeEleitor = tituloDeEleitor;
    }

    /**
     * Get the value of nis
     *
     * @return the value of nis
     */
    public NIS getNis() {
        return nis;
    }

    /**
     * Set the value of nis
     *
     * @param nis new value of nis
     */
    public void setNis(NIS nis) {
        this.nis = nis;
    }

    /**
     * Get the value of cpf
     *
     * @return the value of cpf
     */
    public CPF getCpf() {
        return cpf;
    }

    /**
     * Set the value of cpf
     *
     * @param cpf new value of cpf
     */
    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    /**
     * Get the value of identidade
     *
     * @return the value of identidade
     */
    public RG getIdentidade() {
        return identidade;
    }

    /**
     * Set the value of identidade
     *
     * @param identidade new value of identidade
     */
    public void setIdentidade(RG identidade) {
        this.identidade = identidade;
    }

    /**
     * Get the value of dataDeNascimento
     *
     * @return the value of dataDeNascimento
     */
    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    /**
     * Set the value of dataDeNascimento
     *
     * @param dataDeNascimento new value of dataDeNascimento
     */
    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     * Get the value of contribuinte
     *
     * @return the value of contribuinte
     */
    public Contribuinte getContribuinte() {
        return contribuinte;
    }

    /**
     * Set the value of contribuinte
     *
     * @param contribuinte new value of contribuinte
     */
    public void setContribuinte(Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

}
