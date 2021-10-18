package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import users.Visitor;

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

		// em.getTransaction().begin();
		
			// em.persist(new Visitor("111.222.333-45", "Jubscleiton", "514212", "12.123.123.12-0", "079-111", "Irineu"));
			
		// em.getTransaction().commit();
		
		List<Visitor> visitors = Visitor.list(em);
		
		for (Visitor visitor : visitors) {
			
			System.out.println(visitor.getCpf());
			
		}
		
		
		em.close();
		emf.close();

	}

}
