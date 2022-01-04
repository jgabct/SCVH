package br.edu.ifs.academico.administrative;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.controllers.DashboardController;
import br.edu.ifs.academico.model.entities.Bed;
import br.edu.ifs.academico.utils.LoadScene;
import br.edu.ifs.academico.utils.MapTables;
import br.edu.ifs.academico.utils.TableAutoresizeModel;
import br.edu.ifs.academico.utils.enums.Frame;
import br.edu.ifs.academico.utils.enums.SystemObjects;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminPanelController implements Initializable{
	
    protected Stage insideStage;
    protected SystemObjects targetObject;

    @FXML private VBox centerPanel;
    
    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button removeButton;
    @FXML private Button exitButton;

	public AdminPanelController(SystemObjects systemObjects) {
		this.targetObject = systemObjects;
		toAssemble();		
	}

	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        System.out.println("Init - initialize - Controller Adm");

        addButton.setOnAction(event -> {
        	System.out.println("addButton diz: click");
        });
        
        editButton.setOnAction(event -> {
        	System.out.println("editButton diz: click");
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
        	insideStage.setTitle("SCVH - Painel Administrativo");    	
        	LoadScene<AdminPanelController> lScene = new LoadScene<>(this);
            insideStage.setScene(lScene.toCharge(Frame.ADM));
            insideStage.show();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
	
    private void exit() { new DashboardController(); }
	
//    public static void autoResizeColumns( TableView<?> table )
//    {
//        //Set the right policy
//        table.setColumnResizePolicy( TableView.UNCONSTRAINED_RESIZE_POLICY);
//        table.getColumns().stream().forEach( (column) ->
//        {
//            //Minimal width = columnheader
//            Text t = new Text( column.getText() );
//            double max = t.getLayoutBounds().getWidth();
//            for ( int i = 0; i < table.getItems().size(); i++ )
//            {
//                //cell must not be empty
//                if ( column.getCellData( i ) != null )
//                {
//                    t = new Text( column.getCellData( i ).toString() );
//                    double calcwidth = t.getLayoutBounds().getWidth();
//                    //remember new max-width
//                    if ( calcwidth > max )
//                    {
//                        max = calcwidth;
//                    }
//                }
//            }
//            //set the new max-widht with some extra space
//            column.setPrefWidth( max + 10.0d );
//        } );
//    }

}
