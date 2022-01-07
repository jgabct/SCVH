package br.edu.ifs.academico.controllers.administrative;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.controllers.DashboardController;
import br.edu.ifs.academico.controllers.FormControllerTest;
import br.edu.ifs.academico.model.entities.Employee;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.LoadScene;
import br.edu.ifs.academico.utils.enums.Frame;
import br.edu.ifs.academico.utils.enums.SystemObjects;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdministrativeEmployee implements Initializable{
	
    private GenericOperations<Employee> go = new GenericOperations<>(Employee.class);

    private Stage insideStage;
	
	@FXML private TableView<Employee> table;
	
	@FXML private TableColumn<Employee, String> colRegistration;
	@FXML private TableColumn<Employee, String> colName;
	@FXML private TableColumn<Employee, String> colCpf;
	@FXML private TableColumn<Employee, String> colPost;
	@FXML private TableColumn<Employee, String> colSector;

    @FXML private VBox centerPanel;
    
    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button removeButton;
    @FXML private Button exitButton;

	public AdministrativeEmployee() {
		toAssemble();	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	    colRegistration.setCellValueFactory(
	    		cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getRegistration())
	    	);
		colName	.setCellValueFactory(
				cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getName())
			);
		colCpf.setCellValueFactory(
				cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getCpf())
			);
		colPost.setCellValueFactory(
				cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getPost().get())
			);
		colSector.setCellValueFactory(
				cellData -> new SimpleStringProperty(((Employee) cellData.getValue()).getSector().getKey())
			);
		
		//
		
		ObservableList<Employee> teamMembers = FXCollections.observableArrayList(go.list());
		
		table.setItems(teamMembers);
		
		table.setRowFactory(new Callback<TableView<Employee>, TableRow<Employee>>() {  
	        @Override  
	        public TableRow<Employee> call(TableView<Employee> tableView2) {  
	            final TableRow<Employee> row = new TableRow<>();  
	            row.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {  
	                @Override  
	                public void handle(MouseEvent event) {  
	                    final int index = row.getIndex();  
	                    if (index >= 0 && index < table.getItems().size() && table.getSelectionModel().isSelected(index)  ) {
	                    	table.getSelectionModel().clearSelection();
	                        event.consume();  
	                    }  
	                }  
	            });  
	            return row;  
	        }  
	    }); 
		
		  addButton.setOnAction(event -> {
	        	System.out.println("addButton diz: click");
	        	new FormControllerTest(SystemObjects.EMPLOYEE, go, this.getClass());
	        });
	        
	        editButton.setOnAction(event -> {
	        	System.out.println("editButton diz: click");
	        	try {
		        	if(!table.getSelectionModel().selectedItemProperty().get().equals(null)) {
			        	System.out.println(table.getSelectionModel().selectedItemProperty().get().toString());
		        	}
				} catch (Exception e) {
					return;
				}
	        });
	        
	        removeButton.setOnAction(event -> {
	        	System.out.println("removeButton diz: click");
	        });
	        
	        exitButton.setOnAction(event -> {
	        	System.out.println("exitButton diz: click");
	        	exit();
	        });

	}
	
	protected void toAssemble() {
        try {
        	System.out.println("Init Constructor Adm");
        	insideStage = Main.getGlobalStage();
        	
        	insideStage.setTitle("SCVH - Painel Administrativo - Funcionários");    	
        	LoadScene<AdministrativeEmployee> lScene = new LoadScene<>(this);
            insideStage.setScene(lScene.toCharge(Frame.ADMEMPLOYEE));
            
            insideStage.show();
        } catch (IOException e) {
            System.err.println(e);
        }
	}
	
    private void exit() { new DashboardController(); }
	
}
