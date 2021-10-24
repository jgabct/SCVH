package model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;

import model.interfaces.Ientity;

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

	public void register(Bed bed, Room room) {

	}

	public static List<Bed> list(EntityManager em) {

		return em.createQuery("SELECT e FROM Bed e", Bed.class).getResultList();
	}

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return this.propertyNumber;
	}

}
