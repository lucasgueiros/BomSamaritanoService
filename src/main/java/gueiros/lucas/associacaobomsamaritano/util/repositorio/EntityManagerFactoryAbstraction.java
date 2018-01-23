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
