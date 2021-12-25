package br.edu.ifs.academico.model.entities;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.FriendlyName;
import br.edu.ifs.academico.utils.enums.FieldType;

public class Visitor implements IEntity {

	@FriendlyName(value="CPF",		methodToSave="setCpf", 			nameClassInput=String.class,	fieldType = FieldType.TEXTFIELD,	order=1) 
	private String cpf;
	@FriendlyName(value="Nome",		methodToSave="setName", 		nameClassInput=String.class,	fieldType = FieldType.TEXTFIELD,	order=0) 
	private String name;
	@FriendlyName(value="RG",		methodToSave="setRg", 			nameClassInput=String.class,	fieldType = FieldType.TEXTFIELD,	order=2) 
	private String rg;
	@FriendlyName(value="Telefone",	methodToSave="setNumberPhone",	nameClassInput=String.class,	fieldType = FieldType.TEXTFIELD,	order=3) 
	private String numberPhone;
	private String employeeRegistry;

    // O query necessita do construtor padrão (Vazio)
    public Visitor() {/*Construtor vazio*/}

    public Visitor(String cpf, String name, String password, String rg, String numberPhone, String employeeRegistry) {
        setCpf(cpf);
        setName(name);
        setRg(rg);
        setNumberPhone(numberPhone);
        setEmployeeRegistry(employeeRegistry);
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNumberPhone() {
        return this.numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmployeeRegistry() {
        return this.employeeRegistry;
    }

    public void setEmployeeRegistry(String employeeRegistry) {
        this.employeeRegistry = employeeRegistry;
    }

//    public void register(Visitor visitor) {
//
//    }

    @Override
    public String getKey() {
        return getCpf();
    }

	@Override
	public String toString() {
		return "Visitor [cpf=" + cpf + ", name=" + name + ", rg=" + rg + ", numberPhone=" + numberPhone
				+ ", employeeRegistry=" + employeeRegistry + "]";
	}
    
    

}