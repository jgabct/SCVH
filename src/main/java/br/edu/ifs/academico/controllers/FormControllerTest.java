package br.edu.ifs.academico.controllers;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.Id;

import br.edu.ifs.academico.application.Main;
import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.AlertBox;
import br.edu.ifs.academico.utils.IdentityOfEnumerators;
import br.edu.ifs.academico.utils.LoadScene;
import br.edu.ifs.academico.utils.annotations.Blocked;
import br.edu.ifs.academico.utils.annotations.NameField;
import br.edu.ifs.academico.utils.enums.Frame;
import br.edu.ifs.academico.utils.enums.KeyField;
import br.edu.ifs.academico.utils.enums.Post;
import br.edu.ifs.academico.utils.enums.SystemObjects;
import javafx.collections.FXCollections;
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

public class FormControllerTest implements Initializable {
	
    private Stage insideStage;
    private SystemObjects targetObject;
    
    private Class<?> clazzEscape;
    
    private GenericOperations<? extends IEntity> gen;
    
    private LinkedList<InputLine> listInputText;
    
    private Object objClass = null;

    @FXML private VBox shelf;
    
    @FXML private Button cancelButton;
    @FXML private Button finishButton;
    
	public FormControllerTest(SystemObjects targetObject, GenericOperations<? extends IEntity> gen,  Class<?> clazzEscape) {
		this.targetObject = targetObject;
		this.gen = gen;
		this.clazzEscape = clazzEscape;
    	toAssemble();
    }
	
	public FormControllerTest(Object objClass, SystemObjects targetObject, GenericOperations<? extends IEntity> gen,  Class<?> clazzEscape) {
		this.objClass = objClass;
		this.targetObject = targetObject;
		this.gen = gen;
		this.clazzEscape = clazzEscape;
		toAssemble();
	}

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        System.out.println("Init - initialize - Controller Form");
        
        listInputText = getListFieldCreation(targetObject.getSystemObjectsType());
        
        shelf.getChildren().addAll(listInputText);
        
        if(objClass != null) {
        	setItems();
        }
        
        cancelButton.setOnAction(event -> {
        	System.out.println("cancelButton diz: click");
        	exit();
        });
        
        finishButton.setOnAction(event -> {
        	System.out.println("finishButton diz: click");
        	if(buildEntity()) {
            	exit();
        	} else {
        		return;
        	}

        });

    }
    
    private void toAssemble() {
        try { 	
        	System.out.println("Init Constructor Form");
       
        	insideStage = Main.getGlobalStage();
        	
        	LoadScene<FormControllerTest> lScene = new LoadScene<>(this);
            insideStage.setScene(lScene.toCharge(Frame.FORM));
            
            insideStage.setTitle("SCVH - Formulário");
            
            insideStage.show();
            
        } catch (IOException e) {
            System.err.println(e);
        }
    }

	
    private void exit() { 
    	try {
			clazzEscape.getConstructor(new Class[]{}).newInstance();
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
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
	
    private static LinkedList<InputLine> getListFieldCreation(Class<?> typeClass) {
    	return List.of(typeClass.getDeclaredFields())
    		.stream()
    		.filter(trinket -> trinket.isAnnotationPresent(NameField.class))
    		.collect(LinkedList<InputLine>::new, 
    				(list, trinket) -> {
    					InputLine input = new InputLine(trinket);
    					if(trinket.getType().isEnum()) {
    						
    						ComboBox<Object> box = new ComboBox<>();
    						
    						box.setItems( FXCollections.observableArrayList(trinket.getType().getEnumConstants()));
    							
    						box.getSelectionModel().selectFirst();

    						input.setComboBox(box);
    						
    						} else if (!trinket.getType().equals(String.class)) {
    						
    						
//    						System.out.println("Tá diferente");
//    						System.out.println(trinket.getType());
    						ComboBox<Object> box = new ComboBox<>();
    						
    						try {
    							Object obj = trinket.getType().getConstructor().newInstance();
    							//.getMethod("summaryValues").invoke(null)
								box.getItems().addAll(((IEntity) obj).summaryValues());
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
									| NoSuchMethodException | SecurityException | InstantiationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
    						
    						box.getSelectionModel().selectFirst();

    						input.setComboBox(box);  						
    						
    					} else {
    						input.setField();
    					}
    					
    					
    					list.add(input);
    				},
    				List::addAll);
    }
    
    
    public Boolean buildEntity() {
    	
    	Class<?> clazz = targetObject.getSystemObjectsType();
    	
    	Object obj = null;
    	
		try {
			obj = clazz.getDeclaredConstructor(new Class[]{}).newInstance();
			
			for(InputLine input : listInputText) {
				try {
					String text = null;
					
					if(input.getFieldKey().getType().isEnum() || 
							!input.getFieldKey().getType().equals(String.class)) {	
						text = input.getValueInComboBox();
					} else {
						text = input.getTextInField();
					}
					
					if("".equals(text)) {
						AlertBox.display("Aviso", "Campo não preenchido");
						return false;
					}
				} catch (Exception e) {
					AlertBox.display("Aviso", "Campo não preenchido");
					return false;
				}

			}
			
			for(InputLine input : listInputText) {
				
				Field field = clazz.getDeclaredField(input.getFieldKey().getName());
				
				if(field.isAnnotationPresent(NameField.class)) {
					
					field.setAccessible(true);
					
					if(field.getType().isEnum()) {
						if(field.getType() == Post.class) {
							field.set(obj, Post.find(input.getValueInComboBox()));	
							
						}
						
					} else if (!field.getType().equals(String.class)) {

						Object outher = field.getType().getConstructor(new Class[]{}).newInstance();
						
						((IEntity) outher).setKey(input.getValueInComboBox());

						field.set(obj, outher);
						
					} else {

						field.set(obj, input.getTextInField());	
					}
				}

			}
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((IEntity) obj).check();
    	
        if(objClass != null) {
        	gen.update(clazz.cast(objClass), clazz.cast(obj));
        }else{
    		gen.register(clazz.cast(obj));
        }

		return true;

    }
	
	public void setItems(){

		Class<?> clazz = targetObject.getSystemObjectsType();
    	
		for(InputLine input : listInputText) {
			
			try {
				Field field = clazz.getDeclaredField(input.getFieldKey().getName());
			
			
				if(field.isAnnotationPresent(NameField.class)) {
				
				field.setAccessible(true);
				
				if(field.getType().isEnum()) {
					if(field.getType() == Post.class) {
						input.setValueInComboBox(field.get(objClass).toString());
					}
					
				} else if (!field.getType().equals(String.class)) {
					
					input.setValueInComboBox(((IEntity) field.get(objClass)).getKey().toString());
					
				} else {
					input.setTextInField(field.get(objClass).toString());
				}
				}
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
		
	}
    
     public static class InputLine extends HBox{
    	 	private Field fieldKey;
    	 	private TextField textField;
    		private ComboBox<Object> fieldBox;
    		
    		public InputLine(Field fieldKey) {
    			setPrefSize(600, 40);
    			setSpacing(10);
    			setAlignment(Pos.CENTER);
    			
    			this.fieldKey = fieldKey;
    			
    			setTitle(fieldKey.getAnnotation(NameField.class).value());
    		}
    		//Key
			public Field getFieldKey() {
				return fieldKey;
			}
    		
    		//Title
    		private void setTitle(String title) {
    			Label containerTitle = new Label(title);
    			containerTitle.setPrefSize(150, 40);
    			containerTitle.setAlignment(Pos.CENTER_RIGHT);
    			getChildren().add(containerTitle);
    		}
    		
    		//Field
    		private void setField() {
    			textField = new TextField();
    			textField.setPrefSize(200, 30);
    			textField.setAlignment(Pos.CENTER_LEFT);
    			getChildren().add(textField);
    		}
    		
    		public void setTextInField(String text){
    			textField.setText(text);
    			if(fieldKey.isAnnotationPresent(Blocked.class)) {
    				textField.setEditable(false);
    			}
    		}
    		
    		public String getTextInField() {
    			return textField.getText();
    		}
    		
    		//Combobox
    		private void setComboBox(ComboBox<Object> box) {
    			fieldBox = box;
    			fieldBox.setPrefSize(200, 30);
    			getChildren().add(fieldBox);
    			
    		}
    		
    		public void setValueInComboBox(String text){
    			fieldBox.setValue(text);
    		}
    		
    		public String getValueInComboBox (){
    			return fieldBox.getSelectionModel().getSelectedItem().toString();
    		}
    		
    		

     }
    
}
