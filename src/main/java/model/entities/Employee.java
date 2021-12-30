package br.edu.ifs.academico.model.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.ifs.academico.model.interfaces.Ientity;
import br.edu.ifs.academico.utils.enums.EmployeeType;

@Entity
public class Employee implements Ientity {

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

	@Enumerated(EnumType.STRING)
	private EmployeeType post;

	private String password;
	private String cpf;
	private String rg;
	private String phone;

	/*
	 * As anotações abaixo criam uma relação Muitos para um (N:1) Além de criar uma
	 * coluna chamada sector que referencia a coluna sectorCode A JPA sabe qual
	 * tabela referencia pelo tipo de objeto
	 */
	@ManyToOne
	@JoinColumn(name = "sector", referencedColumnName = "sectorCode")
	private Sector sector;

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
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
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public Employee() {

	}

	public Employee(String registration, EmployeeType post, String password, String cpf, String rg, String phone,
			Sector sector) {
		this.registration = registration;
		this.post = post;
		this.password = password;
		this.cpf = cpf;
		this.rg = rg;
		this.phone = phone;
		this.sector = sector;
	}

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return this.registration;
	}

	@Override
	public <E> void alter(E args) {
		// TODO Auto-generated method stub

		Employee preparedArgs = (Employee) args;

		this.cpf = preparedArgs.getCpf();
		this.rg = preparedArgs.getRg();
		this.phone = preparedArgs.getPhone();
		this.sector = preparedArgs.getSector();

	}

}
