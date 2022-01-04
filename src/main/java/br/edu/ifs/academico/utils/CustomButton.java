package br.edu.ifs.academico.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CustomButton extends Button {

	public CustomButton() {/*Construtor vazio*/}

	public CustomButton(String name, String id, EventHandler<ActionEvent> event){
		this.setText(name);
		this.setId(id);
		this.setOnAction(event);
	}
	
	public CustomButton(String name, String id, Integer width, Integer height, EventHandler<ActionEvent> event) {
		this(name, id, event);
		this.setPrefSize(width, height);
	}
}
