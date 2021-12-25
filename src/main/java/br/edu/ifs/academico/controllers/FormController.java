package br.edu.ifs.academico.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.utils.FriendlyName;
import br.edu.ifs.academico.utils.InputLineCustomContainer;
import br.edu.ifs.academico.utils.LoadScene;
import br.edu.ifs.academico.utils.components.ComponentsForm;
import br.edu.ifs.academico.utils.enums.Frame;
import br.edu.ifs.academico.utils.enums.SystemObjects;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormController implements Initializable {

    /*
     * Nota: por enquanto essa janela tem os botões fixos no fxml
     * pq foi feita antes da ideia de deixa-los flexveis
     */

    //Início das variáveis da Classe

    private Stage insideStage;
    private SystemObjects targetObject;
    
//    private EmployeeType employeeType;

    //Término das variáveis da Classe

    //Início das variáveis referentes ao fxml

    @FXML private VBox shelf;
    
    @FXML private Button cancelButton;
    @FXML private Button finishButton;

    //Término das variáveis referentes ao fxml

    //Início do Construtor da Classe
    
    @SuppressWarnings("exports")
	public FormController(SystemObjects targetObject) {
    	this.targetObject = targetObject;
    	toAssemble();
    }

    //Término do Construtor da Classe

    //Início do método é invocado após a contrução da Classe
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        System.out.println("Init - initialize - Controller Form");
        
        LinkedHashMap<FriendlyName, InputLineCustomContainer> comp = 
        		ComponentsForm.getListFieldCreation(targetObject.getSystemObjectsType());
        
        
        
        shelf.getChildren().addAll(comp.values());
        
        cancelButton.setOnAction(event -> {
        	System.out.println("cancelButton diz: click");
        	exit();
        });
        
        finishButton.setOnAction(event -> {
        	System.out.println("finishButton diz: click");
        	System.out.println(ComponentsForm.getObject(targetObject.getSystemObjectsType(), comp).toString());
        	exit();
        });
       
    }
    //Término do método é invocado após a contrução da Classe
    
    private void toAssemble() {
        try {
        	System.out.println("Init Constructor Form");
        	
        	//Pega o palco que fica disponibilizado globalmente
        	insideStage = Main.getGlobalStage(); 
        	
        	//Coloca um nome para o palco
        	insideStage.setTitle("SCVH - Formul�rio"); 
        	
        	/* Respons�vel por carregar o FXML e o CSS, assim criando a cena para o palco, 
        	 * o parametro serve para mostrar qual � o controller respons�vel pela cena */        	
        	LoadScene<FormController> lScene = new LoadScene<>(this);
            
        	// Colocar a cena do palco
            insideStage.setScene(lScene.toCharge(Frame.FORM));
            
            // Mostra o palco com sua cena atual
            insideStage.show();
            
        } catch (IOException e) {
            System.err.println(e);
        }
    }

	
    private void exit() { new DashboardController(); }
    
}
