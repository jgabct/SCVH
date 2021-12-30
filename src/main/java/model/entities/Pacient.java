package br.edu.ifs.academico.model.entities;



import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.ifs.academico.model.interfaces.Ientity;



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

	// O metodo hospitalize(Internar) n�o fazeria mais sentido estar na classe
	// Employee ?
	// J� que uma a��o realizada por um funcionario ?
	public void hospitalize(Pacient pacient, Bed bed) {

	}

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return  this.linkCode;
	}

	@Override
	public <E> void alter(E args) {
		// TODO Auto-generated method stub
		
		Pacient preparedArgs = (Pacient) args;
		
		this.name = preparedArgs.getName();
		this.employRgstry = preparedArgs.getEmployRgstry();
		
	}





}
