package br.edu.ifs.academico.utils.components;

import java.util.List;

import br.edu.ifs.academico.controllers.administrative.AdministrativeBed;
import br.edu.ifs.academico.controllers.administrative.AdministrativeEmployee;
import br.edu.ifs.academico.controllers.administrative.AdministrativePatient;
import br.edu.ifs.academico.controllers.administrative.AdministrativeRoom;
import br.edu.ifs.academico.controllers.administrative.AdministrativeRule;
import br.edu.ifs.academico.controllers.administrative.AdministrativeSector;
import br.edu.ifs.academico.controllers.administrative.AdministrativeVisitor;
import br.edu.ifs.academico.utils.CustomButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ComponentsAdministratorDashboard extends Component {

	private final CustomButton roomButton = new CustomButton("Quartos", "idRoomButton",
				event -> {
					System.out.println("roomButton diz: click");
					new AdministrativeRoom();
				}
			);
	
	private final CustomButton bedButton = new CustomButton("Leitos", "idBedButton",
				event -> {
					System.out.println("bedButton diz: click");
					new AdministrativeBed();
				}
			);
	
	private final CustomButton ruleButton = new CustomButton("Regras", "idRuleButton",
				event -> {
					System.out.println("ruleButton diz: click");
					new AdministrativeRule();
				}
			);

	private final CustomButton employeeButton = new CustomButton("Funcionários", "idEmployeeButton",
				event -> {
					System.out.println("employeeButton diz: click");
					new AdministrativeEmployee();
				}
			);
	
	private final CustomButton patientsButton = new CustomButton("Pacientes", "idPatientsButton",
				event -> {
					System.out.println("patientsButton diz: click");
					new AdministrativePatient();
				}
			);
	private final CustomButton visitorsButton = new CustomButton("Visitantes", "idVisitorsButton",
				event -> {
					System.out.println("visitorsButton diz: click");
					new AdministrativeVisitor();
				}
			);
	private final CustomButton sectorButton = new CustomButton("Setores", "idSectorButton",
				event -> {
					System.out.println("sectorButton diz: click");
					new AdministrativeSector();
				}
			);
//	private final CustomButton administratorButton = new CustomButton("Admin", "idAdministratorButton",
//			event -> {System.out.println("sectorButton diz: click");}
//			);
//	private final CustomButton reportsButton = new CustomButton("RelatÃ³rios", "idReportsButton",
//			event -> {System.out.println("reportsButton diz: click");}
//			);

	public ComponentsAdministratorDashboard(Stage outsideStage) {
		super(outsideStage);
		initializeComponents();
		updateButtons(getButtonsList());
	}

	@Override
	protected void initializeComponents() {
		getButtonsList().add(employeeButton);
		getButtonsList().add(patientsButton);
		getButtonsList().add(visitorsButton);
		getButtonsList().add(ruleButton);
		getButtonsList().add(sectorButton);
		getButtonsList().add(roomButton);
		getButtonsList().add(bedButton);
//		getButtonsList().add(administratorButton);
//		getButtonsList().add(reportsButton);
	}
	
	public void updateButtons(List<Node> btnList) {
		for(Node btn: btnList) {
			BorderPane pane = new BorderPane();
			pane.setPrefWidth((btnList.size() > 8)?150:170);
			pane.setPrefHeight(100);
			pane.setPadding(new Insets(0, 0, 10, 0));
			((CustomButton) btn).setPrefSize(getWidthButton(),getHeightButton());
			BorderPane.setAlignment(btn,Pos.BOTTOM_CENTER);
			pane.setBottom(btn);
//			pane.setStyle("-fx-background-color: rgba(251,199,90,0.5);");
			getPaneButtonsList().add(pane);
		}
	}

	@Override
	public List<Node> getListCompositionButtons(){
		return getButtonsList();
	}
	
	public List<Node> getListCompositionPaneButtons(){
		return getPaneButtonsList();
	}
	
}
