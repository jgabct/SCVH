package br.edu.ifs.academico.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.edu.ifs.academico.model.entities.Bed;
import br.edu.ifs.academico.model.entities.Employee;
import br.edu.ifs.academico.model.entities.Room;
import br.edu.ifs.academico.model.entities.Rule;
import br.edu.ifs.academico.model.services.EMFactory;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.enums.EmployeeType;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//OBS: ESSA � UMA CLASSE FEITA SOMENTE PARA DEBUG
		// NA COMPILA��O FINAL ELA SER� DELETADA
		

		GenericOperations<Employee> go = new GenericOperations<>(Employee.class);

		
		String pk = "R500";
		
		Employee entity = new Employee(pk,EmployeeType.RECEPTIONIST,"113355","618092","113231","113123",null);
		
	
		
		go.register(entity);
		
		System.out.println(go.select("A500"));
		
	
		
		go.endOperations();
	
		
		EMFactory.closeEntityManagerFactory();	
		
	}

}
