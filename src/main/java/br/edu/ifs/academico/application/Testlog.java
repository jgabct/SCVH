package br.edu.ifs.academico.application;

import br.edu.ifs.academico.utils.enums.EmployeeType;

public class Testlog {

	public static void main(String[] args){
		
//		Arrays.asList(EmployeeType.values()).forEach(obj -> System.out.println(obj.getOffice()));
		System.out.println(EmployeeType.pegarFuncaoPorValor("Enfermeira"));
		
	}
}
 