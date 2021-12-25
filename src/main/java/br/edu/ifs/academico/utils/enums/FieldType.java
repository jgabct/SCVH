package br.edu.ifs.academico.utils.enums;

public enum FieldType {
	TEXTFIELD(Constants.TEXTFIELD), COMBOBOX(Constants.COMBOBOX);

	FieldType(String fieldTypeString) {
      if(!fieldTypeString.equals(this.name()))
        throw new IllegalArgumentException();
    }

    public static class Constants {
        public static final String TEXTFIELD = "TEXTFIELD";
        public static final String COMBOBOX = "COMBOBOX";
    }
}
