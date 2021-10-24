package model.entity;



import javax.persistence.Entity;
import javax.persistence.Id;

import model.interfaces.Ientity;



@Entity
public class Pacient implements Ientity {

	@Id
	private String linkCode;
	private String name;
	private String employRgstry;

	public String getLinkCode() {
		return linkCode;
	}

	public void setLinkCode(String linkCode) {
		this.linkCode = linkCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployRgstry() {
		return employRgstry;
	}

	public void setEmployRgstry(String employRgstry) {
		this.employRgstry = employRgstry;
	}

	public Pacient() {
		
	}
	
	public Pacient(String linkCode, String name, String employRgstry) {
		this.linkCode = linkCode;
		this.name = name;
		this.employRgstry = employRgstry;
	}

	// O metodo hospitalize(Internar) não fazeria mais sentido estar na classe
	// Employee ?
	// Já que uma ação realizada por um funcionario ?
	public void hospitalize(Pacient pacient, Bed bed) {

	}

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return  this.linkCode;
	}





}
