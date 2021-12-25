package br.edu.ifs.academico.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import br.edu.ifs.academico.utils.enums.FieldType;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class InputLineCustomContainer extends HBox {
	
	private TextField field;
	private ComboBox<Object> fieldBox;
	
	public InputLineCustomContainer(String title){
		setPrefSize(600, 40);
		setSpacing(10);
		setAlignment(Pos.CENTER);
		
		setTitle(title);
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
	
	private void setComboBox(ArrayList<?> list) {
		fieldBox = new ComboBox<Object>();
		
		for (int i = 1; i < list.size(); i++) {
			fieldBox.getItems().add(list.get(i));
		}
		
		fieldBox.setPrefSize(120, 30);

		getChildren().add(fieldBox);
		
	}
	
	public String getInputLineText() {
//		return field.getText();
		return fieldBox.getValue().toString();
	}
	
}
