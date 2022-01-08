package br.edu.ifs.academico.controllers.administrative;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.controllers.DashboardController;
import br.edu.ifs.academico.controllers.FormControllerTest;
import br.edu.ifs.academico.model.entities.Bed;
import br.edu.ifs.academico.model.entities.Room;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.AlertBox;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdministrativeBed implements Initializable{
	
	private GenericOperations<Bed> go = new GenericOperations<>(Bed.class);

    private Stage insideStage;
    
    @FXML private Label title;
    @FXML private Label employeeName;
	
	@FXML private TableView<Bed> table;
	
	@FXML private TableColumn<Bed, String> colPropertyNumber;
	@FXML private TableColumn<Bed, String> colBedNumber;
	@FXML private TableColumn<Bed, String> colOccupied;
	@FXML private TableColumn<Bed, String> colBelongingRoom;

    @FXML private VBox centerPanel;
    
    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button removeButton;
    @FXML private Button exitButton;

	public AdministrativeBed() {
		toAssemble();	
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		title.setText("Gerenciamento de Leitos");
		employeeName.setText(Main.getEmployee().getName());
		
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		colPropertyNumber.setCellValueFactory(
				cellData -> new SimpleStringProperty(((Bed) cellData.getValue()).getPropertyNumber())
			);
		colBedNumber.setCellValueFactory(
				cellData -> new SimpleStringProperty(((Bed) cellData.getValue()).getBedNumber())
			);
		colOccupied.setCellValueFactory(
				cellData -> {
					try {
						if(!((Bed) cellData.getValue()).getOccupyingPacient().equals(null)){
							return new SimpleStringProperty("Ocupado");
						}
						return null;
					} catch (Exception e) {
						return new SimpleStringProperty("Livre");
					}
				}
			);
		colBelongingRoom.setCellValueFactory(
				cellData -> {
					try {
						Room belongingRoom = ((Bed) cellData.getValue()).getBelongingRoom();
						return new SimpleStringProperty(belongingRoom.getKey());
					} catch (Exception e) {
						return new SimpleStringProperty("Sem Quarto");
					}
				}
		);
		
		ObservableList<Bed> teamMembers = FXCollections.observableArrayList(go.list());
		
		table.setItems(teamMembers);
		
		table.setRowFactory(new Callback<TableView<Bed>, TableRow<Bed>>() {  
	        @Override  
	        public TableRow<Bed> call(TableView<Bed> tableView2) {  
	            final TableRow<Bed> row = new TableRow<>();  
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
		
		table.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValuew) -> {

				}
			);
		
		  addButton.setOnAction(event -> {
	        	System.out.println("addButton diz: click");
	        	
	        	GenericOperations<?> temp = new GenericOperations<Room>(Room.class);
	        	if(temp.list().isEmpty()) {
	        		AlertBox.display("Aviso", "Cadastre um Quarto antes de proceguir com a operação");
	        		return;
	        	}
	        	
	        	new FormControllerTest(SystemObjects.BED, go, this.getClass());
	        });
	        
	        editButton.setOnAction(event -> {
	        	System.out.println("editButton diz: click");
	        	try {
		        	if(!table.getSelectionModel().selectedItemProperty().get().equals(null)) {
			        	Bed bedE = table.getSelectionModel().selectedItemProperty().get();
			        	
			        	new FormControllerTest(bedE, SystemObjects.BED, go, this.getClass());
		        	}
				} catch (Exception e) {
					return;
				}
	        });
	        
	        removeButton.setOnAction(event -> {
	        	System.out.println("removeButton diz: click");
	        	try {
		        	if(!table.getSelectionModel().selectedItemProperty().get().equals(null)) {
		        		Bed bedR = table.getSelectionModel().selectedItemProperty().get();
		        		
		        		try {
		        			go.delete(bedR.getKey());
				        	table.getItems().remove(bedR);
				        	
		        		}catch (Exception e) {
							AlertBox.display("Aviso", "Não pode ser excuido por ainda ter vinculo com outra entidade");
						}

		        	}
				} catch (Exception e) {
					return;
				}
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
        	
        	insideStage.setResizable(false);
        	   	
        	LoadScene<AdministrativeBed> lScene = new LoadScene<>(this);
            insideStage.setScene(lScene.toCharge(Frame.ADMBED));
            
        	insideStage.setTitle("SCVH - Painel Administrativo - Leito"); 
            
            insideStage.show();
        } catch (IOException e) {
            System.err.println(e);
        }
	}
	
    private void exit() { new DashboardController(); }
	
}
