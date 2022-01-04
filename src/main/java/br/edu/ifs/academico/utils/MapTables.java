package br.edu.ifs.academico.utils;

import java.util.List;

import br.edu.ifs.academico.model.entities.Bed;
import br.edu.ifs.academico.model.entities.Employee;
import br.edu.ifs.academico.model.entities.Patient;
import br.edu.ifs.academico.model.entities.Room;
import br.edu.ifs.academico.model.entities.Rule;
import br.edu.ifs.academico.model.entities.Sector;
import br.edu.ifs.academico.model.entities.Visitor;
import br.edu.ifs.academico.utils.enums.SystemObjects;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MapTables{
	
	public MapTables(TableView<?> outTable, SystemObjects obj) {
		switch (obj) {
			case BED: 
				setListColumnsForBed(outTable);
				return;
			case EMPLOYEE: 
				setListColumnsForEmployee(outTable);
				return;
			case PATIENT: 
				setListColumnsForPacient(outTable);
				return;
			case ROOM: 
				setListColumnsForRoom(outTable);
				return;
			case RULE: 
			//	setListColumnsForRule(outTable);
				return;
			case SECTOR: 
				setListColumnsForSector(outTable);
				return;
			case VISITOR: 
				setListColumnsForVisitor(outTable);
				return;
			case VISIT:
				return;
		default:
			break;
		}
	}
	
	private void setListColumnsForBed(TableView<?> outTable){
		
		TableView<Bed> table = new TableView<>();
		
		TableColumn<Bed, String> colPropertyNumber = new TableColumn<>("N° da Propriedade");
		colPropertyNumber.setCellValueFactory(cellData -> new SimpleStringProperty(((Bed) cellData.getValue()).getPropertyNumber()));
		
		TableColumn<Bed, String> colBedNumber = new TableColumn<>("N° da Propriedade");
		colBedNumber.setCellValueFactory(cellData -> new SimpleStringProperty(((Bed) cellData.getValue()).getPropertyNumber()));
		
		table.getColumns().addAll(List.of(colPropertyNumber, colBedNumber));
		
		outTable = table;
	}
	

	public void setListColumnsForEmployee(TableView<?> outTable) {
		
		TableView<Employee> table = new TableView<>();
		
	    TableColumn<Employee, String> colRegistration = new TableColumn<>("Matrícula");
	    colRegistration.setCellValueFactory(cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getRegistration()));
	    
	    TableColumn<Employee, String> colName = new TableColumn<>("Nome");
		colName	.setCellValueFactory(cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getName()));
		
	    TableColumn<Employee, String> colCpf = new TableColumn<>("CPF");
		colCpf.setCellValueFactory(cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getCpf()));
	    
	    TableColumn<Employee, String> colNumberPhone = new TableColumn<>("Telefone");
		colNumberPhone.setCellValueFactory(cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getPhone()));
		
	    TableColumn<Employee, String> colOffice = new TableColumn<>("Cargo");
		colOffice.setCellValueFactory(cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getPost().getOffice()));
	    
	    TableColumn<Employee, String> colSector = new TableColumn<>("Setor");
		colSector.setCellValueFactory(cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getSector().getKey()));
		
		table.getColumns().addAll(List.of(colRegistration, colName, colCpf, colNumberPhone, colOffice, colSector));
		
		outTable = table;
	}
	
	
	public void setListColumnsForPacient(TableView<?> outTable) { 
		
		TableView<Patient> table = new TableView<>();
		
		TableColumn<Patient, String> colLinkCode = new TableColumn<>("Código de Referência");
		colLinkCode.setCellValueFactory(cellData -> new SimpleStringProperty(((Patient) cellData.getValue()).getLinkCode()));
		
		TableColumn<Patient, String> colName = new TableColumn<>("Nome");
		colName.setCellValueFactory(cellData -> new SimpleStringProperty(((Patient) cellData.getValue()).getName()));
		
		TableColumn<Patient, String> colBirthDate	= new TableColumn<>("Data de Nascimento");
		colBirthDate.setCellValueFactory(cellData -> new SimpleStringProperty(((Patient) cellData.getValue()).getBirthDate().toString()));
		
		TableColumn<Patient, String> colPropertyNumber	= new TableColumn<>("Código do Leito");
		colPropertyNumber.setCellValueFactory(cellData -> new SimpleStringProperty(((Patient) cellData.getValue()).getOccupiedBed().getPropertyNumber()));
		
		table.getColumns().addAll(List.of(colLinkCode, colName, colBirthDate, colPropertyNumber));
		
		outTable = table;
	}

	public void setListColumnsForRoom(TableView<?> outTable) {
		
		TableView<Room> table = new TableView<>();
		
		TableColumn<Room, String> colRoomCode = new TableColumn<>("Código");
		colRoomCode.setCellValueFactory(cellData -> new SimpleStringProperty(((Room) cellData.getValue()).getRoomCode()));

		TableColumn<Room, String> colRule = new TableColumn<>("Regra");
		colRule.setCellValueFactory(cellData -> new SimpleStringProperty(((Room) cellData.getValue()).getRule().getKey()));
		
		TableColumn<Room, String> colSector = new TableColumn<>("Setor");
		colSector.setCellValueFactory(cellData -> new SimpleStringProperty(((Room) cellData.getValue()).getBelongingSector().getKey()));
		
		table.getColumns().addAll(List.of(colRoomCode, colRule, colSector));
		
		outTable = table;
	}


	/*
	
	public void setListColumnsForRule(TableView<?> outTable) {
		
		TableView<Rule> table = new TableView<>();
		
		TableColumn<Rule, String> colRuleCode = new TableColumn<>("Código");
		colRuleCode.setCellValueFactory(cellData -> new SimpleStringProperty(((Rule) cellData.getValue()).getRuleCode()));

		TableColumn<Rule, String> colMaximumVisitorsPerPatient = new TableColumn<>("Max. Visitantes por Paciente");
		colMaximumVisitorsPerPatient.setCellValueFactory(cellData -> new SimpleStringProperty(((Rule) cellData.getValue()).getMaximumVisitorsPerPatient().toString()));
		
		TableColumn<Rule, String> colMaximumVisitorsPerRoom = new TableColumn<>("Max. Visitantes por Quarto");
		colMaximumVisitorsPerRoom.setCellValueFactory(cellData -> new SimpleStringProperty(((Rule) cellData.getValue()).getmaximumVisitorsPerRoom().toString()));
		
		TableColumn<Rule, String> colVisitDuration = new TableColumn<>("Duranção de Visita");
		colVisitDuration.setCellValueFactory(cellData -> new SimpleStringProperty(((Rule) cellData.getValue()).getVisitDuration().toString()));
		
		table.getColumns().addAll(List.of(colRuleCode, colMaximumVisitorsPerPatient, colMaximumVisitorsPerRoom, colVisitDuration));
		
		outTable = table;
	}

*/

	public void setListColumnsForSector(TableView<?> outTable) {
		
		TableView<Sector> table = new TableView<>();
		
		TableColumn<Sector, String> colSectorCode = new TableColumn<>("Código");
		colSectorCode.setCellValueFactory(cellData -> new SimpleStringProperty(((Sector) cellData.getValue()).getSectorCode()));
		
		TableColumn<Sector, String> colAcronym = new TableColumn<>("Sigla");
		colAcronym.setCellValueFactory(cellData -> new SimpleStringProperty(((Sector) cellData.getValue()).getAcronym()));
		
		TableColumn<Sector, String> colSectorName = new TableColumn<>("Nome");
		colSectorName.setCellValueFactory(cellData -> new SimpleStringProperty(((Sector) cellData.getValue()).getSectorName()));
		
		TableColumn<Sector, String> colRule = new TableColumn<>("Regra");
		colRule.setCellValueFactory(cellData -> new SimpleStringProperty(((Sector) cellData.getValue()).getRule().getKey()));
		
		table.getColumns().addAll(List.of(colSectorCode, colAcronym, colSectorName, colRule));
		
		outTable = table;
	}


	public void setListColumnsForVisitor(TableView<?> outTable){
		
		TableView<Visitor> table = new TableView<>();
		
		TableColumn<Visitor, String> colCpf = new TableColumn<>("CPF");
		colCpf.setCellValueFactory(cellData -> new SimpleStringProperty(((Visitor) cellData.getValue()).getCpf()));
		
		TableColumn<Visitor, String> colName = new TableColumn<>("Nome");
		colName.setCellValueFactory(cellData -> new SimpleStringProperty(((Visitor) cellData.getValue()).getName()));
		
		TableColumn<Visitor, String> colRg = new TableColumn<>("RG");
		colRg.setCellValueFactory(cellData -> new SimpleStringProperty(((Visitor) cellData.getValue()).getRg()));
		
		TableColumn<Visitor, String> colNumberPhone = new TableColumn<>("Telefone");
		colNumberPhone.setCellValueFactory(cellData -> new SimpleStringProperty(((Visitor) cellData.getValue()).getPhone()));
		
		table.getColumns().addAll(List.of(colCpf, colName, colRg, colNumberPhone));
		
		outTable = table;
	}

}

