package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entity.Visitor;
import model.service.GenericOperations;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("administrator");

		EntityManager em = emf.createEntityManager();

		
		GenericOperations<Visitor> go = new GenericOperations<>(Visitor.class, em);
		

		
		for (Visitor visitor : go.list()) {
			
			System.out.println(visitor);
			
		}
		
	
		
 	go.update(go.select("111.111.333-45"),new Visitor("111.333.333-45","Mario", "174614798124", "124.173.123.10-9","079-999","Pirobau"));
		
	System.out.println("-----------");	
	
	for (Visitor visitor : go.list()) {
			
			System.out.println(visitor);
			
		}
		
		
		em.close();
		emf.close();

	}

}
