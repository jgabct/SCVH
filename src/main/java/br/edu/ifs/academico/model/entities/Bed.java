package br.edu.ifs.academico.model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.Bloq;
import br.edu.ifs.academico.utils.annotations.NameField;

@Entity
public class Bed implements IEntity {

	@NameField(value="N° da Propriedade")
	@Bloq
	@Id
	private String propertyNumber;
	@NameField(value="N° da Cama") 
	private String bedNumber;
	private boolean occupied;

	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "occupiedBed")
	private Patient occupyingPacient;

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public String getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Patient getOccupyingPacient() {
		return occupyingPacient;
	}

	public Bed() {

	}

	public Bed(String bedNumber, String propertyNumber) {

		this.bedNumber = bedNumber;
		this.propertyNumber = propertyNumber;

	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return this.propertyNumber;
	}

	

}
