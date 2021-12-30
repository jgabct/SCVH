package br.edu.ifs.academico.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.ifs.academico.model.interfaces.Ientity;

@Entity
public class Visitor implements Ientity {

	@Id
	private String cpf;
	private String name;
	private String password;
	private String rg;
	private String phone;
	private String employRgstry;

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

	// O query necessita do construtor padr�o (Vazio)
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

	
	@Override
	public Object getKey() {

		return this.cpf;
	}

	@Override
	public <E> void alter(E args) {
		// TODO Auto-generated method stub

		Visitor preparedArgs = (Visitor) args;
		this.name = preparedArgs.getName();
		this.password = preparedArgs.getPassword();
		this.rg = preparedArgs.getRg();
		this.phone = preparedArgs.getPhone();
		this.employRgstry = preparedArgs.getEmployRgstry();

	}

	@Override
	public String toString() {
		return "Visitor [cpf=" + cpf + ", name=" + name + ", password=" + password + ", rg=" + rg + ", phone=" + phone
				+ ", employRgstry=" + employRgstry + "]";
	}

	
	
	
}
