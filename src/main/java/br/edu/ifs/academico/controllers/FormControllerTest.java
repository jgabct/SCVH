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

    @FXML private VBox shelf;
    
    @FXML private Button cancelButton;
    @FXML private Button finishButton;
    
	public FormControllerTest(SystemObjects targetObject, GenericOperations<? extends IEntity> gen,  Class<?> clazzEscape) {
		this.targetObject = targetObject;
		this.gen = gen;
		this.clazzEscape = clazzEscape;
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
        	buildEntity();
        	exit();
        });

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
 
    						System.out.println("passei");
    						
    						ComboBox<Object> box = new ComboBox<>();
  
//    						Method summaryValues = null;
//							try {
//								summaryValues = trinket.getType().getMethod("summaryValues");
//								
//							} catch (NoSuchMethodException | SecurityException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//    						
//    						List<?> mapper = null;
//    						
//							try {
//								mapper = (List<?>) summaryValues.invoke(null);
//
//							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//    						List<?> l = List.of(trinket.getType().getDeclaredFields())
//    						.stream().filter( oty -> oty.isEnumConstant())
//    						.map(it ->  it.toString())
//    						.collect(Collectors.toList());
    						
//    						try {
////								box.getItems().addAll(List.of(trinket.getType().getMethod("summaryValues").invoke(null)));
//    							box.setItems( FXCollections.observableArrayList(List.of(trinket.getType().getMethod("summaryValues").invoke(null))));
//							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
//									| NoSuchMethodException | SecurityException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
    						
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
    
    
    public void buildEntity() {
    	
    	Class<?> clazz = targetObject.getSystemObjectsType();
    	
    	Object obj = null;
    	
		try {
			obj = clazz.getDeclaredConstructor(new Class[]{}).newInstance();
			
			for(InputLine input : listInputText) {
				
				Field field = clazz.getDeclaredField(input.getFieldKey().getName());
				
				field.setAccessible(true);
				
				if(field.getType().isEnum()) {
					
					System.out.println("2");
					if(field.getType() == Post.class) {
						System.out.println("yes");
						System.out.println(input.getValueInComboBox().getClass());
						System.out.println(input.getValueInComboBox());
						field.set(obj, Post.find(input.getValueInComboBox()));	
						
					}
					
				} else if (!field.getType().equals(String.class)) {

					Object outher = field.getType().getConstructor(new Class[]{}).newInstance();
					System.out.println("-> "+outher.getClass());
					
					((IEntity) outher).setKey(input.getValueInComboBox());
					
//					for(Field f : outher.getClass().getDeclaredFields()){
//						
//						if(f.isAnnotationPresent(KeyField.class)) {
//							System.out.println("3");
//							
//							f.set(outher, input.getValueInComboBox());
//						}
//					}
//					
					field.set(obj, outher);
					
				} else {
					System.out.println("1");
					field.set(obj, input.getTextInField());	
				}

			}
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((IEntity) obj).check();
    	
		gen.register(clazz.cast(obj));

    }
//    
//    public static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
//        try {
//            return clazz.cast(o);
//        } catch(ClassCastException e) {
//            return null;
//        }
//    }
    
//	public static <T> Object getObject(Class<T> clz, LinkedHashMap<FriendlyName, InputLine> list) {
//		Object obj = null;
//		try {
//			obj = clz.getDeclaredConstructor().newInstance();
//			
//			for (Map.Entry<FriendlyName, InputLine> entry : list.entrySet()) {
//				FriendlyName annot = entry.getKey();
//				Method method = obj.getClass().getDeclaredMethod(annot.methodToSave(), annot.nameClassInput());
//				switch (entry.getKey().fieldType()){
//					case TEXTFIELD: 
//						method.invoke(obj, entry.getValue().getInputLineText());
//						break;
//					case COMBOBOX:
//						method.invoke(obj, entry.getValue().getInputLineTextComboBox());
//					break;
//    			}
//			}
//				
//		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | 
//				InstantiationException | IllegalAccessException | SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return obj;
//
//	}
	
//	public void setItemList() throws IllegalArgumentException, IllegalAccessException {
//		System.out.println(obj.toString());
//		
//		if(obj != null) {
//			Class<?> clazz = obj.getClass();
//			for(Field field : clazz.getDeclaredFields()) {
//				field.setAccessible(true);
//				for(InputLine iL : listInputText) {
//					if(field.equals(iL.getFieldF())) {
//						if(field.get(obj) instanceof Sector) {
//							iL.setTextInputLine(((Sector) field.get(obj)).getKey());
//							continue;
//						}
//						iL.setTextInputLine((String) field.get(obj));
//					}
//				}
//			}
//		}
//	}
    
     public static class InputLine extends HBox{
    	 	private Field fieldKey;
    	 	private TextField textField;
    		private ComboBox<?> fieldBox;
    		
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
    			containerTitle.setPrefSize(100, 40);
    			containerTitle.setAlignment(Pos.CENTER_RIGHT);
    			getChildren().add(containerTitle);
    		}
    		
    		//Field
    		private void setField() {
    			textField = new TextField();
    			textField.setPrefSize(220, 30);
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
    		private void setComboBox(ComboBox<?> box) {
    			fieldBox = box;
    			fieldBox.setPrefSize(220, 30);
    			getChildren().add(fieldBox);
    			
    		}
    		
    		public String getValueInComboBox (){
    			return fieldBox.getSelectionModel().getSelectedItem().toString();
    		}

     }
    
}
