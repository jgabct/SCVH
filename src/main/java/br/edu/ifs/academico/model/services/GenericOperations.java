package br.edu.ifs.academico.model.services;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import br.edu.ifs.academico.model.interfaces.IEntity;

// Essa classe est� encarregada de fazer as opera��es que pertecem a todas as entidades
public class GenericOperations<E extends IEntity> {
// O tipo "E" obrigatoriamente deve implementar a interface Ientity (Ou seja deve ser uma entidade)

	// O atributo operationEntity armazena o tipo de entidade que est� sendo
	// processada
	
	
	
	private Class<E> operationEntity;
	private EntityManager em;

	public Class<E> getOperationEntity() {
		return operationEntity;
	}

	public GenericOperations(Class<E> operationEntity) {
		this.operationEntity = operationEntity;
		this.em = EMFactory.createEntityManager();

		
	}

	public void register(E entity) throws EntityExistsException, RollbackException {

	      em.getTransaction().begin();

	      em.persist(entity);

	      em.getTransaction().commit();

	  }
	
	public void register(Object entity) throws EntityExistsException, RollbackException {

	      em.getTransaction().begin();

	      em.persist(entity);

	      em.getTransaction().commit();

	  }

	// OBS: O metodo retorna "E" que por natureza � o mesmo tipo do "E" da instancia
	// da classe
	// EX: Se GenericOperations<Visitor> ent�o select(pk) retorna um Visitor
	public E select(Object pk) {

		// pk � do tipo Object por causa que dessa maneira ela aceita qualquer objeto
		// que seja filho de Object
		// EX: String, Integer, Character etc.

		return em.find(operationEntity, pk);

	}

	public void delete(Object pk) throws RollbackException {

	    em.getTransaction().begin();

	    em.remove(select(pk));

	    em.getTransaction().commit();

	  }

	// OBS: O metodo update verifica se a Primary Key foi alterada, caso ela foi
	// alterada ele cria uma nova entidade e deleta a antiga
	public void update(E alteredEntity, E args) throws RollbackException {

	    if (alteredEntity.getKey().equals(args.getKey())) {

	      em.getTransaction().begin();

	      em.merge(args);

	      em.getTransaction().commit();

	    } else {

	      register(args);

	      delete(alteredEntity.getKey());

	    }

	  }
	
	public void update(Object alteredEntity, Object args) throws RollbackException {

	    if (((IEntity) alteredEntity).getKey().equals(((IEntity)args).getKey())) {

	      em.getTransaction().begin();

	      em.merge(args);

	      em.getTransaction().commit();

	    } else {

	      register(args);

	      delete(((IEntity) alteredEntity).getKey());

	    }

	  }

	public boolean exists(Object pk) {

		return (select(pk) == null) ? false : true;

	}

	public List<E> list() {

		String jpql = "SELECT e FROM " + operationEntity.getSimpleName() + " e";

		return em.createQuery(jpql, operationEntity).getResultList();

	}

	public void endOperations() {

		EMFactory.closeEntityManager(this.em);

	}

}