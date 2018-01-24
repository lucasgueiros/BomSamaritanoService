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
package gueiros.lucas.associacaobomsamaritano.util.repositorio;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Atenção! Essa classe tem Singleton!
 * @author lucas
 * 
 */
class EntityManagerFactoryAbstraction {
	
	// SINGLETON
	// Passo um: NÃO DEIXE NINGUÉM CRIAR OBJETOS
	private EntityManagerFactoryAbstraction() {
		// Criando Entity Manager Factory
		createEntityManagerFactory();
	}
	// Passo dois: DEIXE GUARDADA UMA INSTÂNCIA
	private static EntityManagerFactoryAbstraction instance = null;
	
	// Passo três: CRIE UM MÉTODO PARA RETORNA A INSTÂNCIA
	static EntityManagerFactoryAbstraction getInstance() {
		if(instance==null){
			instance = new EntityManagerFactoryAbstraction();
		}
		return instance;
	}
	
	// DA ENTIDADE
	private EntityManagerFactory factory = null;

	private final void createEntityManagerFactory() {
		this.factory = Persistence.createEntityManagerFactory("AssociacaoBomSamaritano");
	}
	
	/**
	 * Retorna um novo EntityManager!
	 * @return
	 */
	EntityManager createEntityManager() {
		// evitando possível NullPointerException
		if(factory==null){
			createEntityManagerFactory();
		}
		if (factory!=null)
			return factory.createEntityManager();
		else 
			return null;
	}
	
	/**
	 * Esse método é executado antes do contexto ser destruído (Applciation).
	 * Ou seja, ele será executado ao fim da execução da aplicação, fechando
	 * a conexão com o banco de dados. Amém!
	 */
	@PreDestroy
	void closeEntityManagerFactory(){
		this.factory.close();
		this.factory = null;
	}
	
	
}
