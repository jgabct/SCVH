package structure;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bed {

	@Id
	private byte bedNumber;
	private String propertyNumber;

	public byte getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(byte bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public Bed(byte bedNumber, String propertyNumber) {

		this.bedNumber = bedNumber;
		this.propertyNumber = propertyNumber;

	}

	public void register(Bed bed, Room room) {

	}

	public List<Bed> list() {

		return new ArrayList<Bed>();
	}

}
