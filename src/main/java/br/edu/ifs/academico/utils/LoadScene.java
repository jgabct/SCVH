package br.edu.ifs.academico.utils;

import java.io.IOException;

import br.edu.ifs.academico.utils.enums.Frame;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoadScene<T>{

	private final FXMLLoader loader;
	private Parent page_parent;
	private Scene page_scene;


	public LoadScene() {
		loader = new FXMLLoader();
		page_parent = null;
		page_scene = null;
	}
	
	public LoadScene(T control) {
		this();
		setController(control);
	}

	public Scene toCharge(Frame frame) throws IOException {

		String path = "/br.edu.ifs.academico/fxml/" + frame.toString()+".fxml";

		System.out.println("Dentro do loadScene: "+path);

		loader.setLocation(getClass().getResource(path));

		page_parent = (Parent) loader.load();

		page_parent.getStylesheets().add(getClass().getResource("/br.edu.ifs.academico/styles/" + frame.toString()+".css").toExternalForm());

		page_scene = new Scene(page_parent);

		return page_scene;
	}

	public void setController(T control) {
		loader.setController(control);
	}

	public T getController () {
		return loader.getController();
	}

}
