package br.edu.ifs.academico.administrative;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.controllers.DashboardController;
import br.edu.ifs.academico.model.entities.Bed;
import br.edu.ifs.academico.model.entities.Patient;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.LoadScene;
import br.edu.ifs.academico.utils.enums.Frame;
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

public class AdministrativePatient implements Initializable{

    private Stage insideStage;
	
    private GenericOperations<Patient> go = new GenericOperations<>(Patient.class);
    
	@FXML private TableView<Patient> table;
	
	@FXML private TableColumn<Patient, String> colLinkCode;
	@FXML private TableColumn<Patient, String> colName;
	@FXML private TableColumn<Patient, String> colBirthDate;
	@FXML private TableColumn<Patient, String> colPropertyNumber;

    @FXML private VBox centerPanel;
    
    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button removeButton;
    @FXML private Button exitButton;

	public AdministrativePatient() {
		toAssemble();	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		colLinkCode.setCellValueFactory(cellData -> new SimpleStringProperty(((Patient) cellData.getValue()).getLinkCode()));
		colName.setCellValueFactory(cellData -> new SimpleStringProperty(((Patient) cellData.getValue()).getName()));
		colBirthDate.setCellValueFactory(cellData -> new SimpleStringProperty(((Patient) cellData.getValue()).getBirthDate().toString()));
		colPropertyNumber.setCellValueFactory(cellData -> new SimpleStringProperty(((Patient) cellData.getValue()).getOccupiedBed().getPropertyNumber()));
		
		ObservableList<Patient> teamMembers = FXCollections.observableArrayList(go.list());
		
		table.setItems(teamMembers);
		
		table.setRowFactory(new Callback<TableView<Patient>, TableRow<Patient>>() {  
	        @Override  
	        public TableRow<Patient> call(TableView<Patient> tableView2) {  
	            final TableRow<Patient> row = new TableRow<>();  
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
        	
        	insideStage.setTitle("SCVH - Painel Administrativo - Pacientes");    	
        	LoadScene<AdministrativePatient> lScene = new LoadScene<>(this);
            insideStage.setScene(lScene.toCharge(Frame.ADMPATIENT));
            
            insideStage.show();
        } catch (IOException e) {
            System.err.println(e);
        }
	}
	
    private void exit() { new DashboardController(); }
	
}
