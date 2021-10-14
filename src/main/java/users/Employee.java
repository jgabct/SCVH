package users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import structure.Sector;

@Entity
public class Employee {

	@Id
	private String registration;
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

	public Employee(String registration, String cpf, String rg, String phone, Sector sector) {
		this.registration = registration;
		this.cpf = cpf;
		this.rg = rg;
		this.phone = phone;
		this.sector = sector;
	}

	public void register(Employee emplo) {

	}

	public List<Employee> list() {

		return new ArrayList<Employee>();

	}

}
