package br.edu.ifs.academico.model.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.NameField;

@Entity
public class Visitor implements IEntity {

	@NameField(value="CPF")		 
	@Id
	private String cpf;
	@NameField(value="Nome")
	private String name;
	private String password;
	@NameField(value="RG")
	private String rg;
	@NameField(value = "Telefone")
	private String phone;
	private String employRgstry;

	@OneToMany(mappedBy = "visitor")
	private Set<Visit> visits;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmployRgstry() {
		return employRgstry;
	}

	public void setEmployRgstry(String employRgstry) {
		this.employRgstry = employRgstry;
	}

	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	// O query necessita do construtor padrão (Vazio)
	public Visitor() {

	}

	public Visitor(String cpf, String name, String password, String rg, String phone) {
		this.cpf = cpf;
		this.name = name;
		this.password = password;
		this.rg = rg;
		this.phone = phone;
	}

	public Visitor(String cpf, String name, String password, String rg, String phone, String employRgstry) {
		this.cpf = cpf;
		this.name = name;
		this.password = password;
		this.rg = rg;
		this.phone = phone;
		this.employRgstry = employRgstry;
	}

	public Visitor(String cpf, String name, String password, String rg, String phone, String employRgstry,
			Set<Visit> visits) {
		this.cpf = cpf;
		this.name = name;
		this.password = password;
		this.rg = rg;
		this.phone = phone;
		this.employRgstry = employRgstry;
		this.visits = visits;
	}

	@Override
	public Object getKey() {

		return this.cpf;
	}

	@Override
	public String toString() {
		return "Visitor [cpf=" + cpf + ", name=" + name + ", password=" + password + ", rg=" + rg + ", phone=" + phone
				+ ", employRgstry=" + employRgstry + "]";
	}

}
