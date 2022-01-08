package br.edu.ifs.academico.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.model.entities.Employee;
import br.edu.ifs.academico.model.services.CryptoManager;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.AlertBox;
import br.edu.ifs.academico.utils.LoadScene;
import br.edu.ifs.academico.utils.enums.Post;
import br.edu.ifs.academico.utils.enums.Frame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	private GenericOperations<Employee> go = new GenericOperations<>(Employee.class);
	
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

        	
        	/* Respons�vel por carregar o FXML e o CSS, assim criando a cena para o palco, 
        	 * o parametro serve para mostrar qual � o controller respons�vel pela cena */        	
        	LoadScene<LoginController> lScene = new LoadScene<>(this);
            
        	// Colocar a cena do palco
            insideStage.setScene(lScene.toCharge(Frame.LOGIN));
            
        	insideStage.setTitle("SCVH - Login"); 
            
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
		String employeePassword = employeePasswordTextField.getText();

		if ("".equals(employeeEnrolment) || "".equals(employeePassword)) {
			System.out.println("---> "+employeeEnrolment);
			AlertBox.display("Aviso", "Campo n�o preenchido");
			return;

		} else {
			try {
				Employee employee = go.select(employeeEnrolment);

				if(!employee.equals(null)) {
					if (CryptoManager.descryptPswd(employeePassword, employee.getPassword())) {

						Main.setEmployee(employee);

						new DashboardController();
						
					} else {
						
						AlertBox.display("Aviso", "Matricula e/ou senha invalidos");
						
						return;
					}
				}else {
					throw new NullPointerException();
				}

			} catch (Exception e) {
				AlertBox.display("Aviso", "Nenhum funcion�rio foi encontrado ");
			}
		}
	}

    //Término dos eventos dos botões
    
 }