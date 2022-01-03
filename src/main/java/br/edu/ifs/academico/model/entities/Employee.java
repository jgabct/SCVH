package br.edu.ifs.academico.model.entities;

import java.util.Objects;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.Bloq;
import br.edu.ifs.academico.utils.annotations.NameField;
import br.edu.ifs.academico.utils.enums.EmployeeType;


public class Employee implements IEntity {

    @NameField(value = "Matrícula")
    @Bloq
    private String registration;
    
    @NameField(value = "Nome")	
    private String name;

    @NameField(value = "CPF")
    private String cpf;
	
    @NameField(value = "Telefone")
    private String numberPhone;
    
    @NameField(value = "Senha")
    private String password;
    
    @NameField(value = "Cargo")
    private EmployeeType post;
    
    @NameField(value = "Setor")
    private Sector sector;

    public Employee() {/*Construtor vazio*/}
    
    public Employee(String registration, String name, String cpf, String numberPhone, 
    		String password, @SuppressWarnings("exports") EmployeeType enrollment, Sector sector) {
    	setRegistration(registration);
        setName(name);
        setCpf(cpf);
        setNumberPhone(numberPhone);
        setPassword(password);
        setPost(enrollment);
        setSectorCode(sector);
    }
    
    public String getRegistration() { return this.registration; }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() { return this.name;	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() { return this.cpf; }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumberPhone() { return this.numberPhone; }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
    
    public String getPassword() { return this.password; }

	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings("exports")
	public EmployeeType getPost() { return this.post; }

	public void setPost(@SuppressWarnings("exports") EmployeeType enrollment) {
		this.post = enrollment;
	}

    public Sector getSector() { return this.sector; }

    public void setSectorCode(Sector sector) {
        this.sector = sector;

    }

	@Override
	public int hashCode() {
		return Objects.hash(cpf, registration);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(registration, other.registration);
	}

	@Override
    public String getKey() {
        return getRegistration();
    }
    
	@Override
	public String toString() {
		return "Employee [registration=" + registration + ", name=" + name + ", cpf=" + cpf + ", numberPhone="
				+ numberPhone + ", password=" + password + ", post=" + post + ", sector=" + sector + "]";
	}

}

