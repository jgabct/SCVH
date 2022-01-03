package br.edu.ifs.academico.model.entities;

import java.util.Objects;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.NameField;

public class Visitor implements IEntity {

	@NameField(value="CPF")		 
	private String cpf;
	@NameField(value="Nome")
	private String name;
	@NameField(value="RG")
	private String rg;
	@NameField(value = "Telefone")
	private String numberPhone;
	
	private String employeeRegistry;

    // O query necessita do construtor padrão (Vazio)
    public Visitor() {/*Construtor vazio*/}

    public Visitor(String cpf, String name, String rg, String numberPhone, String employeeRegistry) {
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
    
    @Override
	public int hashCode() {
		return Objects.hash(cpf, employeeRegistry, name, numberPhone, rg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitor other = (Visitor) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(employeeRegistry, other.employeeRegistry)
				&& Objects.equals(name, other.name) && Objects.equals(numberPhone, other.numberPhone)
				&& Objects.equals(rg, other.rg);
	}

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