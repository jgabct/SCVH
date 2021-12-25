package br.edu.ifs.academico.model.entities;

import java.util.Objects;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.FriendlyName;
import br.edu.ifs.academico.utils.enums.FieldType;

public class Bed implements IEntity {

	@FriendlyName(value="N° da Propriedade", methodToSave="setPropertyNumber", 	nameClassInput=String.class,	fieldType=FieldType.TEXTFIELD,	order=0)
	private String propertyNumber;
    @FriendlyName(value="N° da Cama",		 methodToSave="setBedNumber", 		nameClassInput=Byte.class,	fieldType = FieldType.TEXTFIELD,	order=1) 
    private byte bedNumber;

    public Bed() {/*Constructor vazio*/}

    public Bed(byte bedNumber, String propertyNumber) {
        setBedNumber(bedNumber);
        setPropertyNumber(propertyNumber);
    }

    public String getPropertyNumber() {
        return this.propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public byte getBedNumber() {
        return this.bedNumber;
    }

    public void setBedNumber(byte bedNumber) {
        this.bedNumber = bedNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bed bed = (Bed) o;
        return propertyNumber.equals(bed.propertyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyNumber);
    }

    //    public void register(Bed bed, Room room) {
//
//    }

//    public static List<Bed> list(EntityManager em) {
//
//        return em.createQuery("SELECT e FROM Bed e", Bed.class).getResultList();
//    }

    @Override
    public String getKey() {
        return getPropertyNumber();
    }

}