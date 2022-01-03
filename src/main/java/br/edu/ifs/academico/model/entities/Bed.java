package br.edu.ifs.academico.model.entities;

import java.util.Objects;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.Bloq;
import br.edu.ifs.academico.utils.annotations.FriendlyName;
import br.edu.ifs.academico.utils.annotations.NameField;
import br.edu.ifs.academico.utils.enums.FieldType;

public class Bed implements IEntity {

	@NameField(value="N° da Propriedade")
	@Bloq
	private String propertyNumber;
    @NameField(value="N° da Cama") 
    private String bedNumber;

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

	@Override
	public String toString() {
		return "Bed [propertyNumber=" + propertyNumber + ", bedNumber=" + bedNumber + "]";
	}


	
	
}