package br.edu.ifs.academico.model.entities;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.annotations.Blocked;
import br.edu.ifs.academico.utils.annotations.NameField;

@Entity
public class Bed implements IEntity {

	@Id
	@Blocked
	@NameField(value="N° da Propriedade") 
	private String propertyNumber;
	
	@NameField(value="N° da Cama") 
	private String bedNumber;
	
	private boolean occupied;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "occupiedBed")
	private Patient occupyingPacient;

    public Bed() {/*Constructor vazio*/}

    public Bed(String propertyNumber, String bedNumber) {
    	setPropertyNumber(propertyNumber);
    	setBedNumber(bedNumber);
    }

    public String getPropertyNumber() { return this.propertyNumber; }
    
    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getBedNumber() { return this.bedNumber; }

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

	@Override
	public int hashCode() {
		return Objects.hash(propertyNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bed other = (Bed) obj;
		return Objects.equals(propertyNumber, other.propertyNumber);
	}

	@Override
    public String getKey() {
        return getPropertyNumber();
    }
	
	public static List<String> summaryValues() {
		return new GenericOperations<Bed>(Bed.class).list()
				.stream()
				.map( bed -> bed.getKey())
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "Bed [propertyNumber=" + propertyNumber + ", bedNumber=" + bedNumber + "]";
	}


	
	
}