package br.edu.ifs.academico.model.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("administrator");

	public static EntityManager createEntityManager() {

		return emf.createEntityManager();

	}

	public static void closeEntityManager(EntityManager em) {

		em.close();

	}

	public static void closeEntityManagerFactory() {

		emf.close();

	}
	
}
