package br.edu.ifs.academico.utils.components;

import java.util.List;

import br.edu.ifs.academico.controllers.administrative.AdministrativePatient;
import br.edu.ifs.academico.utils.CustomButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ComponentsNurseDashboard extends Component {

	private final CustomButton patientsButton = new CustomButton("Pacientes", "idPatientsButton",
			event -> {
				System.out.println("patientsButton diz: click");
				new AdministrativePatient();
			}
		);

	public ComponentsNurseDashboard(Stage outsideStage) {
		super(outsideStage);
		initializeComponents();
		updateButtons(getButtonsList());
	}

	@Override
	protected void initializeComponents() {
		getButtonsList().add(patientsButton);
	}

	public void updateButtons(List<Node> btnList) {
		for(Node btn: btnList) {
			BorderPane pane = new BorderPane();
			pane.setPrefWidth((btnList.size() > 8)?150:170);
			pane.setPrefHeight(100);
			pane.setPadding(new Insets(0, 0, 10, 0));
			((CustomButton) btn).setPrefSize(getWidthButton(),getHeightButton());
			BorderPane.setAlignment(btn, Pos.BOTTOM_CENTER);
			pane.setBottom(btn);
//			pane.setStyle("-fx-background-color: rgba(251,199,90,0.5);");
			getPaneButtonsList().add(pane);
		}
	}

	@Override
	public List<Node> getListCompositionButtons() {
		return getButtonsList();
	}

	@Override
	public List<Node> getListCompositionPaneButtons() {
		return getPaneButtonsList();
	}
}
