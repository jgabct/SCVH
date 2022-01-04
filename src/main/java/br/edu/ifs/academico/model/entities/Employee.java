package br.edu.ifs.academico.model.entities;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.model.services.CryptoManager;
import br.edu.ifs.academico.utils.annotations.Bloq;
import br.edu.ifs.academico.utils.annotations.FriendlyName;
import br.edu.ifs.academico.utils.annotations.NameField;
import br.edu.ifs.academico.utils.enums.EmployeeType;
import br.edu.ifs.academico.utils.enums.FieldType;

@Entity
public class Employee implements IEntity {

	@NameField(value = "Matrícula")
	@Bloq
	@Id
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
	
	@NameField(value = "CPF")
	@Enumerated(EnumType.STRING)
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
	private Sector sector;

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeType getPost() {
		return post;
	}

	public void setPost(EmployeeType enrollment) {
		this.post = enrollment;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = CryptoManager.encryptPswd(password);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;

	}

	public static List<EmployeeType> getPosts() {
		return Arrays.asList(EmployeeType.values());
	}

	public Employee() {

	}

	public Employee(String registration,String name, EmployeeType post, String password, String cpf, String phone,
			Sector sector) {
		this.registration = registration;
		this.name = name;
		this.post = post;
		this.password = CryptoManager.encryptPswd(password);
		this.cpf = cpf;
		this.phone = phone;
		this.sector = sector;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return this.registration;
	}

}
