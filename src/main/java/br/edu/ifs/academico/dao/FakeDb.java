package br.edu.ifs.academico.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import br.edu.ifs.academico.model.entities.Bed;
import br.edu.ifs.academico.model.entities.Employee;
import br.edu.ifs.academico.model.entities.Patient;
import br.edu.ifs.academico.model.entities.Room;
import br.edu.ifs.academico.model.entities.Rule;
import br.edu.ifs.academico.model.entities.Sector;
import br.edu.ifs.academico.model.entities.Visitor;
import br.edu.ifs.academico.utils.enums.EmployeeType;
import br.edu.ifs.academico.utils.enums.SystemObjects;

public class FakeDb {

	private List<Bed> tableBed = new ArrayList<>();
	
	private List<Employee> tableEmployee = new ArrayList<>();
	
	private List<Patient> tablePatient = new ArrayList<>();
	
	private List<Room> tableRoom = new ArrayList<>();
	
	private List<Rule> tableRule = new ArrayList<>();
	
	private List<Sector> tableSector = new ArrayList<>();
	
	private List<Visitor> tableVisitor = new ArrayList<>();

	public FakeDb() {
		createRuleInformation();
		createSectorInformation();
		createBedInformation();
		createRoomInformation();
		
		createStaffInformation();
		createPatientInformation();
		createVisitorInformation();
	
	}
	
	public List<?> choiceList(@SuppressWarnings("exports") SystemObjects obj) {
		switch (obj) {
			case BED: 
				return getTableBed();
			case EMPLOYEE: 
				return getTableEmployee();
			case PATIENT: 
				return getTablePatient();
			case ROOM: 
				return getTableRoom();
			case RULE: 
				return getTableRule();
			case SECTOR: 
				return getTableSector();
			case VISITOR: 
				return getTableVisitor();
			default: return null;
		}
	}
	
	private void createBedInformation() {
		tableBed.add(new Bed("B_156452", "1"));
		tableBed.add(new Bed("B_168768", "2"));
		tableBed.add(new Bed("B_513848", "3"));
	}
	
	private void createStaffInformation() {
		tableEmployee.add(new Employee("E_12345", "Marta", "123.456.789-12", "(79)99988-7766", "123", EmployeeType.NURSE, tableSector.get(0)));
		tableEmployee.add(new Employee("E_45668", "Paulo", "456.886.789-43", "(79)99988-7766", "123", EmployeeType.ADMINISTRATOR, tableSector.get(1)));
		tableEmployee.add(new Employee("E_53988", "Paulo", "258.214.369-93", "(79)99988-7766", "123", EmployeeType.RECEPTIONIST, tableSector.get(2)));
	}
	
	private void createPatientInformation() {
		tablePatient.add(new Patient("123", "Marcos", "12/12/1988", tableEmployee.get(0).getKey(), "B_156452"));
	}
	
	private void createRoomInformation() {
		tableRoom.add(new Room("001", tableSector.get(0), tableBed));
		tableRoom.add(new Room("002", tableSector.get(0)));
		tableRoom.add(new Room("003", tableSector.get(0)));
	}
	
	private void createRuleInformation() {
		tableRule.add(new Rule("R_124578", 2, 6, 60));
	}
	
	private void createSectorInformation() {
		tableSector.add(new Sector("S_123457", "ENF", "Enfermaria", tableRule.get(0)));
		tableSector.add(new Sector("S_564567", "ADM", "Administrador"));
		tableSector.add(new Sector("S_415575", "REP", "Recepção"));
	}
	
	private void createVisitorInformation() {
		tableVisitor.add(new Visitor("147.258.369-36", "Andreia", "9.257.368-98", "+55(79)98855-2299", tableEmployee.get(2).getKey()));
	}

	public List<Bed> getTableBed() {
		return this.tableBed;
	}
	
	public List<Employee> getTableEmployee() {
		return this.tableEmployee;
	}

	public List<Patient> getTablePatient() {
		return this.tablePatient;
	}

	public List<Room> getTableRoom() {
		return this.tableRoom;
	}

	public List<Rule> getTableRule() {
		return this.tableRule;
	}

	public List<Sector> getTableSector() {
		return this.tableSector;
	}

	public List<Visitor> getTableVisitor() {
		return this.tableVisitor;
	}
	
	
	
	
}

