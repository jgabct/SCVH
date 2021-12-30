package br.edu.ifs.academico.model.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.ifs.academico.model.interfaces.Ientity;

@Entity
public class Bed implements Ientity {

	@Id
	private String propertyNumber;
	private byte bedNumber;

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}
	
	public byte getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(byte bedNumber) {
		this.bedNumber = bedNumber;
	}


	public Bed() {

	}

	public Bed(byte bedNumber, String propertyNumber) {

		this.bedNumber = bedNumber;
		this.propertyNumber = propertyNumber;

	}


	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return this.propertyNumber;
	}

	@Override
	public <E> void alter(E args) {
		// TODO Auto-generated method stub
		
		Bed preparedArgs = (Bed) args;
		
		this.bedNumber = preparedArgs.getBedNumber();
		
		
	}

}
