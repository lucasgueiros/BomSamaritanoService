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
package gueiros.lucas.bomsamaritano.service.util.repositorio;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 * Repositório que usa a Java Persistenca API para persistir objetos.
 * @author lucasgueiros
 * @param <Tipo> tipo dos objetos que serão persistidos.
 */
public class RepositorioJPA<Tipo extends Identificavel> implements Repositorio<Tipo> {

    public RepositorioJPA(Class<Tipo> classe) {
		this.nomeDaClasse = classe.getName();
	}

	private String nomeDaClasse = null;

    @Override
	public Tipo adicionar(Tipo tipo) {
		try {
			// Recupero o EntityManager que vou usar
			EntityManager manager = EntityManagerFactoryAbstraction.getInstance().createEntityManager();
			// Inicio a transaction
			manager.getTransaction().begin();
			// Inserir o objeto
			manager.persist(tipo);
			// Feche a transaction
			manager.getTransaction().commit();
			// Feche o EntityManager
			manager.close();
		} catch (PersistenceException persistenceException) {
			persistenceException.printStackTrace(); // TODO Trate isso aqui
		}
		return tipo; // TODO ISSO TÁ CERTO? NÃO IMPORTA
	}

    @Override
	public void alterar(Alteracao<Tipo> alteracao, Filtro<Tipo> filtro) {
		try {
			// Recupero o EntityManager que vou usar
			EntityManager manager = EntityManagerFactoryAbstraction.getInstance().createEntityManager();
			// Inicio a transaction
			manager.getTransaction().begin();
			// Recupere os objetos
			List<Tipo> recuperados = this.recuperar(filtro);
			// Aplique as modificações
			recuperados.forEach(alteracao);
			// Os objetos são automaticamente atualizados!
			// Feche a transaction
			manager.getTransaction().commit();
			// Feche o EntityManager
			manager.close();
		} catch (PersistenceException persistenceException) {
			persistenceException.printStackTrace(); // TODO Trate isso aqui!
		}
	}

    @Override
	public void remover(Filtro<Tipo> filtro) {
		try {
			// Recupero o EntityManager que vou usar
			final EntityManager manager = EntityManagerFactoryAbstraction.getInstance().createEntityManager();
			// Inicio a transaction
			manager.getTransaction().begin();
			// Recupere os objetos
			List<Tipo> recuperados = this.recuperar(filtro);
			// Aplique as modificações
			recuperados.forEach(new Consumer<Tipo>() {

				@Override
				public void accept(Tipo t) {
					manager.remove(t);
				}
				
			});
			// Feche a transaction
			manager.getTransaction().commit();
			// Feche o EntityManager
			manager.close();
		} catch (PersistenceException persistenceException) {
			persistenceException.printStackTrace(); // TODO Trate isso aqui!
		}
	}

    @Override
	public List<Tipo> recuperar(Filtro<Tipo> consulta) {
		// ATENÇÃO: ISTO ESTÁ IMPLEMENTADA DE FORMA BEM ESCROTA!
		// Recupero o EntityManager que vou usar
		EntityManager manager = EntityManagerFactoryAbstraction.getInstance().createEntityManager();
		// Inicio a transaction
		manager.getTransaction().begin();
		// Recupere todos os objetos
		List todos = manager.createQuery("SELECT tipo FROM " + nomeDaClasse + " tipo").getResultList();
		// Filtre!
		List<Tipo> aLista = new LinkedList<>();
		
		for(Object o : todos) {
			Tipo tipo = (Tipo) o;
			if(consulta.filtrar(tipo)) {
				aLista.add(tipo);
			}
		}
		
		// Feche a transaction
		manager.getTransaction().commit();
		// Feche o EntityManager
		manager.close();
		return aLista;
	}

}
