package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * A base de dados dever ser nomeada "gateway" 
		 * Todas as informações relativas a senhas e nomes de usuario estão nas persistence-units do arquivo persistence.xml
		 * O usuario "admin" tem todos os privilegios
		 * Os usuarios "nursery" e "recept" somente podem manipular dados
		 * 
		 */

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("administrator");

		EntityManager em = emf.createEntityManager();

		em.close();
		emf.close();

	}

}
