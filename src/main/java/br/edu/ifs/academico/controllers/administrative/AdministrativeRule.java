package br.edu.ifs.academico.controllers.administrative;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.controllers.DashboardController;
import br.edu.ifs.academico.model.entities.Room;
import br.edu.ifs.academico.model.entities.Rule;
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

public class AdministrativeRule implements Initializable{

    private Stage insideStage;
	
	@FXML private TableView<Rule> table;
	
	@FXML private TableColumn<Rule, String> colRuleCode;
	@FXML private TableColumn<Rule, String> colMaximumVisitorsPerPatient;
	@FXML private TableColumn<Rule, String> colMaximumVisitorsPerRoom;
	@FXML private TableColumn<Rule, String> colVisitDuration;

    @FXML private VBox centerPanel;
    
    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button removeButton;
    @FXML private Button exitButton;

	public AdministrativeRule() {
		toAssemble();	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		colRuleCode.setCellValueFactory(cellData -> new SimpleStringProperty(((Rule) cellData.getValue()).getRuleCode()));
		colMaximumVisitorsPerPatient.setCellValueFactory(cellData -> new SimpleStringProperty(((Rule) cellData.getValue()).getMaximumVisitorsPerPatient().toString()));
		colMaximumVisitorsPerRoom.setCellValueFactory(cellData -> new SimpleStringProperty(((Rule) cellData.getValue()).getmaximumVisitorsPerRoom().toString()));		
		colVisitDuration.setCellValueFactory(cellData -> new SimpleStringProperty(((Rule) cellData.getValue()).getVisitDuration().toString()));
		
		
		ObservableList<Rule> teamMembers = FXCollections.observableArrayList(Main.getDatabase().getTableRule());
		
		table.setItems(teamMembers);
		
		table.setRowFactory(new Callback<TableView<Rule>, TableRow<Rule>>() {  
	        @Override  
	        public TableRow<Rule> call(TableView<Rule> tableView2) {  
	            final TableRow<Rule> row = new TableRow<>();  
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
        	
        	insideStage.setTitle("SCVH - Painel Administrativo - Regras");    	
        	LoadScene<AdministrativeRule> lScene = new LoadScene<>(this);
            insideStage.setScene(lScene.toCharge(Frame.ADMRULE));
            
            insideStage.show();
        } catch (IOException e) {
            System.err.println(e);
        }
	}
	
    private void exit() { new DashboardController(); }
	
}
