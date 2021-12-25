package br.edu.ifs.academico.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.model.entities.Employee;
import br.edu.ifs.academico.utils.LoadScene;
import br.edu.ifs.academico.utils.enums.EmployeeType;
import br.edu.ifs.academico.utils.enums.Frame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    /*
     * Nota: essa janela tem os botões fixos no fxml
     * pq não sofrerá mudanças
     */

    //Início das variáveis da Classe
    private Stage insideStage;
    //Término das variáveis da Classe

    //Início das variáveis referentes ao fxml
    @FXML private Button commitButton;
    @FXML private TextField employeeEnrolmentTextField;
    @FXML private TextField employeePasswordTextField;
    //Término das variáveis referentes ao fxml

    //Início do Construtor da Classe
    public LoginController(){ toAssemble(); }
    //Término do Construtor da Classe

    //Início do método é invocado após a contrução da Classe
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        System.out.println("Init - initialize - Controller Login");

        commitButton.setOnAction(event -> commitButtonEvent());

    }

    private void toAssemble() {
    	try {
        	System.out.println("Init Constructor Login");
        	
        	//Pega o palco que fica disponibilizado globalmente
        	insideStage = Main.getGlobalStage(); 
        	
        	//Coloca um nome para o palco
        	insideStage.setTitle("SCVH - Login"); 
        	
        	/* Respons�vel por carregar o FXML e o CSS, assim criando a cena para o palco, 
        	 * o parametro serve para mostrar qual � o controller respons�vel pela cena */        	
        	LoadScene<LoginController> lScene = new LoadScene<>(this);
            
        	// Colocar a cena do palco
            insideStage.setScene(lScene.toCharge(Frame.LOGIN));
            
            // Mostra o palco com sua cena atual
            insideStage.show();
            
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    //Evento do botão de Entrar
    public void commitButtonEvent() {
        System.out.println("commitButton diz: click");

        String employeeEnrolment = employeeEnrolmentTextField.getText();

        if("".equals(employeeEnrolment)) {
            System.out.println(employeeEnrolment);
            return;
        }
        
        Main.setEmployee(new Employee());
        
        try {
            switch (employeeEnrolment) {
                case "123" -> {
                    System.out.println(EmployeeType.RECEPTIONIST);
                    Main.getEmployee().setOffice("Recepcionista");
                }
                case "456" -> {
                    System.out.println(EmployeeType.ADMINISTRATOR);
                    Main.getEmployee().setOffice("Administrador");
                }
                case "789" -> {
                    System.out.println(EmployeeType.NURSE);
                    Main.getEmployee().setOffice("Enfermeira");
                }
                default -> throw new IllegalArgumentException("Unexpected value: " + employeeEnrolment);
            }
            
            new DashboardController();
            
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //Término dos eventos dos botões
    
 }