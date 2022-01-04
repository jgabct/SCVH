package br.edu.ifs.academico.utils.enums;

public enum FormType {

	REGISTER_VISITOR(1), REGISTER_PACIENT(2), REGISTER_EMPLOYEE(3), VALIDADE_VISITOR(4);

	private FormType(int id) {
		this.id = id;
	}

	private int id;

	public int getId() {
		return id;
	}

}
