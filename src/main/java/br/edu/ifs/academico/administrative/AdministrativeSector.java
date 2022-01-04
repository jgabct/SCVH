package br.edu.ifs.academico.administrative;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.controllers.DashboardController;
import br.edu.ifs.academico.model.entities.Bed;
import br.edu.ifs.academico.model.entities.Sector;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.LoadScene;
import br.edu.ifs.academico.utils.enums.Frame;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdministrativeSector implements Initializable{

    private Stage insideStage;
	
    private GenericOperations<Sector> go = new GenericOperations<>(Sector.class);
    
	@FXML private TableView<Sector> table;
	
	@FXML private TableColumn<Sector, String> colSectorCode;
	@FXML private TableColumn<Sector, String> colAcronym;
	@FXML private TableColumn<Sector, String> colSectorName;
	@FXML private TableColumn<Sector, String> colRule;

    @FXML private VBox centerPanel;
    
    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button removeButton;
    @FXML private Button exitButton;

	public AdministrativeSector() {
		toAssemble();	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		colSectorCode.setCellValueFactory(cellData -> new SimpleStringProperty(((Sector) cellData.getValue()).getSectorCode()));
		colAcronym.setCellValueFactory(cellData -> new SimpleStringProperty(((Sector) cellData.getValue()).getAcronym()));
		colSectorName.setCellValueFactory(cellData -> new SimpleStringProperty(((Sector) cellData.getValue()).getSectorName()));
		colRule.setCellValueFactory(cellData -> {
			try {
				return new SimpleStringProperty(((Sector) cellData.getValue()).getRule().getKey());
			} catch (Exception e) {
				return new SimpleStringProperty("Sem Regra");
			}
		});
		
		ObservableList<Sector> teamMembers = FXCollections.observableArrayList(go.list());
		
		table.setItems(teamMembers);
		
		table.setRowFactory(new Callback<TableView<Sector>, TableRow<Sector>>() {  
	        @Override  
	        public TableRow<Sector> call(TableView<Sector> tableView2) {  
	            final TableRow<Sector> row = new TableRow<>();  
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
        	
        	insideStage.setTitle("SCVH - Painel Administrativo - Setor");    	
        	LoadScene<AdministrativeSector> lScene = new LoadScene<>(this);
            insideStage.setScene(lScene.toCharge(Frame.ADMSECTOR));
            
            insideStage.show();
        } catch (IOException e) {
            System.err.println(e);
        }
	}
	
    private void exit() { new DashboardController(); }
	
}
