package gueiros.lucas.associacaobomsamaritano.util.repositorio;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class RepositorioJPA<Tipo> implements Repositorio<Tipo> {

	public RepositorioJPA(Class<Tipo> classe) {
		this.nomeDaClasse = classe.getName();
	}

	private String nomeDaClasse = null;

	@Override
	public void adicionar(Tipo tipo) {
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
		
		/*todos.removeIf(new Predicate<Tipo>() {

			@Override
			public boolean test(Tipo t) {
				return ! consulta.filtrar(t);
			}
			
		});*/
		// Feche a transaction
		manager.getTransaction().commit();
		// Feche o EntityManager
		manager.close();
		return aLista;
	}

}
