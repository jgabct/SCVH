package br.edu.ifs.academico.utils;

import javafx.stage.Stage;

public class PagesInMemory {
	
	private Stage lastPage;
	private Stage currentPage;
	
	public PagesInMemory() {}

	public Stage getLastPage() {
		return this.lastPage;
	}

	public void setLastPage(Stage lastPage) {
		this.lastPage = lastPage;
	}

	public Stage getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(Stage currentPage) {
		this.currentPage = currentPage;
	}

}
