package br.edu.ifs.academico.model.entities;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.FriendlyName;
import br.edu.ifs.academico.utils.InputLineCustomContainer;
import br.edu.ifs.academico.utils.enums.EmployeeType;
import br.edu.ifs.academico.utils.enums.FieldType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Employee implements IEntity {

    @FriendlyName(value="Matrícula",	methodToSave="setRegistration", 	
    		nameClassInput=String.class,  		fieldType=FieldType.TEXTFIELD,  order=0) 	
    private String registration;
    
    @FriendlyName(value="Cpf",			methodToSave="setCpf",				
    		nameClassInput=String.class,		fieldType=FieldType.TEXTFIELD,	order=1) 	
    private String cpf;
    
    @FriendlyName(value="Rg",			methodToSave="setRg",				
    		nameClassInput=String.class,		fieldType=FieldType.TEXTFIELD,	order=2) 	
    private String rg;
    
    @FriendlyName(value="Telefone",		methodToSave="setNumberPhone",		
    		nameClassInput=String.class,		fieldType=FieldType.TEXTFIELD,	order=3) 	
    private String numberPhone;
    
    @FriendlyName(value="Cargo",		methodToSave="setOffice",			
    		nameClassInput=String.class,	fieldType=FieldType.COMBOBOX,	order = 4)
    private EmployeeType office;
    
//    private Sector sector;

    public Employee() {/*Construtor vazio*/}

    public Employee(String registration, String cpf, String rg, String numberPhone, EmployeeType office/*, Sector sector*/) {
        setRegistration(registration);
        setCpf(cpf);
        setRg(rg);
        setNumberPhone(numberPhone);
        setOffice(office.getOffice());
//        this.sector = sector;
    }

//    public void register(Employee emplo) {
//
//    }

    public String getRegistration() {return this.registration;}

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getCpf() {return this.cpf;}

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {return this.rg;}

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getPhone() {return this.numberPhone;}

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
    
    public EmployeeType getOffice() {
		return this.office;
	}

	public void setOffice(String office) {
		this.office = EmployeeType.pegarFuncaoPorValor(office);
		
	}

//    public Sector getSector() {
//        return sector;
//    }
//
//    public void setSector(Sector sector) {
//        this.sector = sector;
//
//    }

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return registration.equals(employee.registration) && cpf.equals(employee.cpf) && rg.equals(employee.rg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registration, cpf, rg);
    }

    @Override
    public String getKey() {
        return this.registration;
    }

	@Override
	public String toString() {
		return "Employee [registration=" + registration + ", cpf=" + cpf + ", rg=" + rg + ", numberPhone=" + numberPhone
				+ ", office=" + office + "]";
	}
    
	public static List<EmployeeType> getOffices() {
		return  Arrays.asList(EmployeeType.values());
	}
    

}

