package br.edu.ifs.academico.utils.enums;

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
	
	SystemObjects(Class<?> systemObjectsType) {
		this.systemObjectsType = systemObjectsType;
	}

	public Class<?> getSystemObjectsType(){
		return systemObjectsType;
	}

}
