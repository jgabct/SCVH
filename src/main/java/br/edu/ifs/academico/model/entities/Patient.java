package br.edu.ifs.academico.model.entities;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.NameField;

import java.util.Objects;

public class Patient implements IEntity {
	
	@NameField(value = "Código de Referência")
    private String linkCode;
	
	@NameField(value = "Nome")
    private String name;
	
	@NameField(value = "Data de Nascimento")
    private String birthDate;
	
    private String employeeRegistry;
    
	@NameField(value = "Leito")
    private String propertyNumber;

    public Patient() {/*Construtor vazio*/}

    public Patient(String linkCode, String name, String birthDate, String employeeRegistry, String propertyNumber) {
        setLinkCode(linkCode);
        setName(name);
        setBirthDate(birthDate);
        setEmployeeRegistry(employeeRegistry);
        setPropertyNumber(propertyNumber); //leito
    }

    public String getLinkCode() {
        return this.linkCode;
    }

    public void setLinkCode(String linkCode) {
        this.linkCode = linkCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmployeeRegistry() {
        return this.employeeRegistry;
    }

    public void setEmployeeRegistry(String employeeRegistry) {
        this.employeeRegistry = employeeRegistry;
    }

    public String getPropertyNumber() {
		return this.propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, linkCode, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(linkCode, other.linkCode)
				&& Objects.equals(name, other.name);
	}

	@Override
    public String getKey() {
        return getLinkCode();
    }

	@Override
	public String toString() {
		return "Patient [linkCode=" + linkCode + ", name=" + name + ", birthDate=" + birthDate + ", employeeRegistry="
				+ employeeRegistry + ", propertyNumber=" + propertyNumber + "]";
	}

	
}