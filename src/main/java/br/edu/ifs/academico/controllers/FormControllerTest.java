package br.edu.ifs.academico.controllers;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.model.entities.Sector;
import br.edu.ifs.academico.utils.LoadScene;
import br.edu.ifs.academico.utils.annotations.Bloq;
import br.edu.ifs.academico.utils.annotations.FriendlyName;
import br.edu.ifs.academico.utils.annotations.NameField;
import br.edu.ifs.academico.utils.enums.Frame;
import br.edu.ifs.academico.utils.enums.SystemObjects;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormControllerTest <T> implements Initializable {
	
    private Stage insideStage;
    private SystemObjects targetObject;
    
    private T object;
    
    private LinkedList<InputLine> listInputText;

    @FXML private VBox shelf;
    
    @FXML private Button cancelButton;
    @FXML private Button finishButton;
    
    public FormControllerTest(SystemObjects targetObject) {
    	this.targetObject = targetObject;
    	toAssemble();
    }
    
	public FormControllerTest(T obj ,SystemObjects targetObject) {
    	this.object = obj;
    	this.targetObject = targetObject;
    	toAssemble();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        System.out.println("Init - initialize - Controller Form");
        
//        LinkedHashMap<FriendlyName, InputLine> comp = 
//        		getListFieldCreation(targetObject.getSystemObjectsType());
        
//        comp.entrySet().stream().forEach(map -> {
//        	if(map.getKey().fieldType() == FieldType.COMBOBOX) {
//        		
//        		List<EmployeeType> li = Employee.getOffices();
//
//        		List<String> n = li.stream()
//        	    .map(it -> it.getOffice())
//        	    .collect(Collectors.toList());
//        		
//        		map.getValue().setListComboBox(n);
//        	}
//        });
        
        listInputText = getListFieldCreation(targetObject.getSystemObjectsType());
        
        shelf.getChildren().addAll(listInputText);
        
        cancelButton.setOnAction(event -> {
        	System.out.println("cancelButton diz: click");
        	exit();
        });
        
        finishButton.setOnAction(event -> {
        	System.out.println("finishButton diz: click");
//        	System.out.println(getObject(targetObject.getSystemObjectsType(), comp).toString());
        	exit();
        });
       
        try {
			setItemList(object);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.err.println("Deu ruim 1");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.err.println("Deu ruim 2");
		}
        
    }
    
    private void toAssemble() {
        try { 	
        	System.out.println("Init Constructor Form");
       
        	insideStage = Main.getGlobalStage(); 
        	insideStage.setTitle("SCVH - Formulário");
        	
        	LoadScene<FormControllerTest> lScene = new LoadScene<>(this);
            insideStage.setScene(lScene.toCharge(Frame.FORM));
            
            insideStage.show();
            
        } catch (IOException e) {
            System.err.println(e);
        }
    }

	
    private void exit() { new DashboardController(); }
    
//    public static <T> LinkedHashMap<FriendlyName, InputLine> getListFieldCreation(Class<T> typeClass) {
//		return (Arrays.asList(typeClass.getDeclaredFields()).stream()
//				.filter(trinket -> trinket.isAnnotationPresent(FriendlyName.class) == true)
//				.collect(
//						LinkedHashMap<FriendlyName, InputLine>::new,
//						(map, trinket)-> map.put(
//							trinket.getAnnotation(FriendlyName.class),
//							new InputLine(trinket.getAnnotation(FriendlyName.class))
//						),
//						Map::putAll))
//				.entrySet()
//				.stream()
//				.sorted((i1, i2) -> Integer.compare(i1.getKey().order(), i2.getKey().order()))
//				.collect(
//					Collectors.toMap(
//							Map.Entry::getKey, Map.Entry::getValue,
//							(e1, e2) -> e1, 
//							LinkedHashMap::new
//						)
//				);	
//	}
	
    public static LinkedList<InputLine> getListFieldCreation(Class<?> typeClass) {
    	return List.of(typeClass.getDeclaredFields())
    		.stream()
    		.filter(trinket -> trinket.isAnnotationPresent(NameField.class))
    		.collect(LinkedList<InputLine>::new, 
    				(list, trinket) -> list.add(new InputLine(trinket)), 
    				List::addAll);
    }
    
	public static <T> Object getObject(Class<T> clz, LinkedHashMap<FriendlyName, InputLine> list) {
		Object obj = null;
		try {
			obj = clz.getDeclaredConstructor().newInstance();
			
			for (Map.Entry<FriendlyName, InputLine> entry : list.entrySet()) {
				FriendlyName annot = entry.getKey();
				Method method = obj.getClass().getDeclaredMethod(annot.methodToSave(), annot.nameClassInput());
				switch (entry.getKey().fieldType()){
					case TEXTFIELD: 
						method.invoke(obj, entry.getValue().getInputLineText());
						break;
					case COMBOBOX:
						method.invoke(obj, entry.getValue().getInputLineTextComboBox());
					break;
    			}
			}
				
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | 
				InstantiationException | IllegalAccessException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;

	}
	
	public void setItemList(T obj) throws IllegalArgumentException, IllegalAccessException {
		System.out.println(obj.toString());
		
		if(obj != null) {
			Class<?> clazz = obj.getClass();
			for(Field field : clazz.getDeclaredFields()) {
				field.setAccessible(true);
				for(InputLine iL : listInputText) {
					if(field.equals(iL.getFieldF())) {
						if(field.get(obj) instanceof Sector) {
							iL.setTextInputLine(((Sector) field.get(obj)).getKey());
							continue;
						}
						iL.setTextInputLine((String) field.get(obj));
					}
				}
			}
		}
	}
    
     public static class InputLine extends HBox{
    	 	private Field fieldF;
    	 	private TextField field;
    		private ComboBox<Object> fieldBox;
    		
    		public InputLine(NameField annot) {
    			setPrefSize(600, 40);
    			setSpacing(10);
    			setAlignment(Pos.CENTER);
    			
    			setTitle(annot.value());
    			setField();
    		}    		
    		
    		public InputLine(Field field) {
    			setPrefSize(600, 40);
    			setSpacing(10);
    			setAlignment(Pos.CENTER);
    			
    			this.fieldF = field;
    			
    			setTitle(field.getAnnotation(NameField.class).value());
    			setField();
    		}
    		
    		public InputLine(FriendlyName annot){
    			setPrefSize(600, 40);
    			setSpacing(10);
    			setAlignment(Pos.CENTER);
    			
    			setTitle(annot.value());
    			
    			switch (annot.fieldType()){
					case TEXTFIELD: 
						setField();
						break;
					case COMBOBOX:
						setComboBox();
					break;
    			}

    		}
    		
    		private void setTitle(String title) {
    			Label containerTitle = new Label(title);
    			containerTitle.setPrefSize(100, 40);
    			containerTitle.setAlignment(Pos.CENTER_RIGHT);
    			getChildren().add(containerTitle);
    		}
    		
    		private void setField() {
    			field = new TextField();
    			field.setPrefSize(220, 30);
    			field.setAlignment(Pos.CENTER_LEFT);
    			getChildren().add(field);
    		}
    		
    		private void setComboBox() {
    			fieldBox = new ComboBox<Object>();
    			fieldBox.setPrefSize(220, 30);
    			getChildren().add(fieldBox);
    			
    		}
    		
    		public void setListComboBox(List<?> list) {
    			fieldBox.getItems().addAll(list);
    		}
    		
    		public void setTextInputLine(String text){
    			field.setText(text);
    			if(fieldF.isAnnotationPresent(Bloq.class)) {
    				field.setEditable(false);
    			}
    		}
    		
    		public String getInputLineText() {
    			return field.getText();
    		}
    		
    		public String getInputLineTextComboBox (){
    			String resp = fieldBox.getValue().toString(); 
    			System.out.println("-> "+resp);
    			return resp;
    		}

			public Field getFieldF() {
				return fieldF;
			}

			public void setFieldF(Field fieldF) {
				this.fieldF = fieldF;
			}
    		
     }
    
}
