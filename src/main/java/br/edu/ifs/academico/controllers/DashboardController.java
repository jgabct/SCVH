package br.edu.ifs.academico.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.controllers.administrative.AdministrativePatient;
import br.edu.ifs.academico.utils.Factory;
import br.edu.ifs.academico.utils.LoadScene;
import br.edu.ifs.academico.utils.components.ComponentsAdministratorDashboard;
import br.edu.ifs.academico.utils.components.ComponentsNurseDashboard;
import br.edu.ifs.academico.utils.components.ComponentsReceptionistDashboard;
import br.edu.ifs.academico.utils.enums.Post;
import br.edu.ifs.academico.utils.enums.Frame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DashboardController implements Initializable {

    /*
     * Nota: por enquanto essa janela tem os botões fixos no fxml
     * pq foi feita antes da ideia de deixa-los flexveis
     */

    //Início das variáveis da Classe

    private Stage insideStage;
    private Post employeeType;

    //Término das variáveis da Classe

    //Início das variáveis referentes ao fxml

    @FXML private FlowPane flowPaneButtons;
    @FXML private Button exitButton;

    @FXML private Label title;
    @FXML private Label employeeName;
    
    //Término das variáveis referentes ao fxml

    //Início do Construtor da Classe
    
	public DashboardController(){
        this.employeeType = Main.getEmployee().getPost();
        toAssemble();
    }

    //Término do Construtor da Classe

    //Início do método é invocado após a contrução da Classe
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
		title.setText("Menu Principal");
		
		employeeName.setText(Main.getEmployee().getName());

        System.out.println("Init - initialize - Controller Home");
        
        exitButton.setOnAction(event -> {
        	Main.setEmployee(null);
        	new LoginController();
        });

        flowPaneButtons.getChildren().addAll(Objects.requireNonNull(getListButtonsBasedTypeFunctionary2(employeeType)));

    }
    
    private void toAssemble() {
    	try {
        	System.out.println("Init Constructor Dashboard");
        	
        	//Pega o palco que fica disponibilizado globalmente
        	insideStage = Main.getGlobalStage(); 
        	
        	//Coloca um nome para o palco

        	
        	/* Respons�vel por carregar o FXML e o CSS, assim criando a cena para o palco, 
        	 * o parametro serve para mostrar qual � o controller respons�vel pela cena */        	
        	LoadScene<DashboardController> lScene = new LoadScene<>(this);
            
        	// Colocar a cena do palco
            insideStage.setScene(lScene.toCharge(Frame.DASHBOARD));
            
        	insideStage.setTitle("SCVH - Dashboard"); 
            
            // Mostra o palco com sua cena atual
            insideStage.show();
            
        } catch (IOException e) {
            System.err.println(e);
        }
    }


    private List<Node> getListButtonsBasedTypeFunctionary2(Post type){
        switch (type) {
            case RECEPTIONIST -> {
                return ((ComponentsReceptionistDashboard) new Factory(insideStage).getDashboard(type)).getListCompositionPaneButtons();
            }
            case ADMINISTRATOR -> {
                return ((ComponentsAdministratorDashboard) new Factory(insideStage).getDashboard(type)).getListCompositionPaneButtons();
            }
            case NURSE -> {
                return ((ComponentsNurseDashboard) new Factory(insideStage).getDashboard(type)).getListCompositionPaneButtons();
            }
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
