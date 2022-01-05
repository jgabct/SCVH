package br.edu.ifs.academico.model.entities;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.model.services.CryptoManager;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.annotations.Blocked;
import br.edu.ifs.academico.utils.annotations.ItIsABox;
import br.edu.ifs.academico.utils.annotations.NameField;
import br.edu.ifs.academico.utils.enums.EmployeeType;

@Entity
public class Employee implements IEntity {
	
	@Id
	@Blocked
	@NameField(value = "Matrícula")
	private String registration;

	/*
	 * O JPA por padrão salva um indice que é referente a constante da enum contudo
	 * dessa maneira pode ocorrer de uma alteração no enum alterar o indice assim
	 * tornando necessario alterar toda a base de dados
	 * 
	 * Com a anotação abaixo agente especifica que o campo é uma enum e com o
	 * parametro EnumType é possivel definir qual é o valor salvo na base de dados
	 * nesse caso é uma String com o nome da constante(Assim não é necessario
	 * atualizar a base de dados)
	 */

	@NameField(value = "Nome")	
	private String name;
	
	@NameField(value = "Cargo")
	@Enumerated(EnumType.STRING)
	@ItIsABox
	private EmployeeType post;

	@NameField(value = "Senha")
	private String password;

	@NameField(value = "CPF")
	private String cpf;

	@NameField(value = "Telefone")
	private String phone;

	/*
	 * As anotações abaixo criam uma relação Muitos para um (N:1) Além de criar uma
	 * coluna chamada sector que referencia a coluna sectorCode A JPA sabe qual
	 * tabela referencia pelo tipo de objeto
	 */
	@NameField(value = "Setor")
	@ManyToOne
	@JoinColumn(name = "sector", referencedColumnName = "sectorCode")
	@ItIsABox
	private Sector sector;

    public Employee() {/*Construtor vazio*/}
    
    public Employee(String registration, String name, String cpf, String phone, String password, EmployeeType post, Sector sector) {
    	setRegistration(registration);
        setName(name);
        setCpf(cpf);
        setPhone(phone);
        setPassword(password);
        setPost(post);
        setSector(sector);
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

    public String getPhone() { return this.phone; }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getPassword() { return this.password; }

	public void setPassword(String password) {
		this.password = CryptoManager.encryptPswd(password);
	}

	public EmployeeType getPost() { return this.post; }

	public void setPost(EmployeeType enrollment) {
		this.post = enrollment;
	}

    public Sector getSector() { return this.sector; }

    public void setSector(Sector sector) {
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
	
	public static List<String> summaryValues() {
		return new GenericOperations<Employee>(Employee.class).list()
				.stream()
				.map( employee -> employee.getKey())
				.collect(Collectors.toList());
	}
    
	@Override
	public String toString() {
		return "Employee [registration=" + registration + ", name=" + name + ", cpf=" + cpf + ", numberPhone="
				+ phone + ", password=" + password + ", post=" + post + ", sector=" + sector + "]";
	}

}

