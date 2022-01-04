package br.edu.ifs.academico.utils.enums;

import java.util.HashMap;
import java.util.Map;

public enum EmployeeType {

	NURSE("Enfermeira"),
	RECEPTIONIST("Recepcionista"), 
	ADMINISTRATOR("Administrador");
	 
	private String office;
	
	private static final Map<String, EmployeeType> funcaoPorValor = new HashMap<>();
	
	static{
		for(EmployeeType employeeType : EmployeeType.values()) {
			funcaoPorValor.put(employeeType.getOffice(), employeeType);
		}
	}
	 
	EmployeeType(String office) {
		this.office = office;
	}
	 
	public String getOffice() {
		return office;
	}
	
	public static EmployeeType pegarFuncaoPorValor(String valor){
		return funcaoPorValor.get(valor);
	}
	     
}
