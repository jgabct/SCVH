package br.edu.ifs.academico.application;

import br.edu.ifs.academico.controllers.LoginController;
import br.edu.ifs.academico.model.entities.Employee;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Employee insideemployee;
	private static Stage insideStage;
	
	public static void setGlobalStage(Stage outsideStage) {insideStage = outsideStage;}
	public static Stage getGlobalStage() {return insideStage;}
	
	public static void setEmployee(Employee outsideEmployee) {insideemployee = outsideEmployee;}
	public static Employee getEmployee(){return insideemployee;} 
	
	@Override
    public void init(){/* chamado antes da aplicação abrir*/}

    @Override
    public void start(Stage primaryStage) throws Exception{
    	setGlobalStage(primaryStage);
		new LoginController();
    }

    public static void main(String[] args) {launch(args);}

    @Override
    public void stop() throws Exception {/* chamado quanto a aplicação fecha*/}
}
