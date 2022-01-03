package br.edu.ifs.academico.utils.enums;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifs.academico.model.entities.*;


public enum SystemObjects {
    BED(Bed.class), 
    EMPLOYEE(Employee.class), 
    PATIENT(Patient.class), 
    ROOM(Room.class), 
    RULE(Rule.class), 
    SECTOR(Sector.class), 
    VISIT(Visit.class), 
    VISITOR(Visitor.class);

	private final Class<?> systemObjectsType;
	
	private static final Map<Class<?>, SystemObjects> objectByClass = new HashMap<>();
	
	static{
		for(SystemObjects employeeType : SystemObjects.values()) {
			objectByClass.put(employeeType.getSystemObjectsType(), employeeType);
		}
	}
	
	SystemObjects(Class<?> systemObjectsType) {
		this.systemObjectsType = systemObjectsType;
	}

	public Class<?> getSystemObjectsType(){
		return systemObjectsType;
	}

	public static SystemObjects takeObjectByClass(Class<?> clazz){
		return objectByClass.get(clazz);
	}
	
}
