package br.edu.ifs.academico.utils.components;

import java.util.List;

import br.edu.ifs.academico.controllers.DashboardController;
import br.edu.ifs.academico.controllers.FormControllerTest;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.CustomButton;
import br.edu.ifs.academico.utils.enums.SystemObjects;
import br.edu.ifs.academico.model.entities.Patient;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ComponentsReceptionistDashboard extends Component{

	private final CustomButton registerButton = new CustomButton("Registrar", "idRegisterButton",
			event -> {
				System.out.println("registerButton diz: click");			
				new FormControllerTest(SystemObjects.PATIENT, new GenericOperations<Patient>(Patient.class), DashboardController.class);
			}
		);
	private final CustomButton validateButton = new CustomButton("Validar", "idValidateButton",
			event -> {System.out.println("validateButton diz: click");}
		);
	private final CustomButton moveButton = new CustomButton("Movimentar", "idMoveButton",
			event -> {System.out.println("moveButton diz: click");}
		);

	public ComponentsReceptionistDashboard(Stage outsideStage) {
		super(outsideStage);
		initializeComponents();
		updateButtons(getButtonsList());
	}

	@Override
	protected void initializeComponents() {
		getButtonsList().add(registerButton);
		getButtonsList().add(validateButton);
		getButtonsList().add(moveButton);
	}

	public void updateButtons(List<Node> btnList) {
		for(Node btn: btnList) {
			BorderPane pane = new BorderPane();
			pane.setPrefWidth((btnList.size() % 2 == 0)?150:170);
			pane.setPrefHeight(100);
			pane.setPadding(new Insets(0, 0, 10, 0));
			((CustomButton)btn).setPrefSize(getWidthButton(),getHeightButton());
			BorderPane.setAlignment(btn,Pos.BOTTOM_CENTER);
			pane.setBottom(btn);
			pane.setStyle("-fx-background-color: rgba(251,199,90,0.5);");
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
