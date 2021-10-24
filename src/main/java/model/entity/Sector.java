package model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import model.interfaces.Ientity;


@Entity
public class Sector implements Ientity {

	@Id
	private String sectorCode;
	private String acronym;
	private String sectorName;
	@ManyToOne
	@JoinColumn(name = "rule", referencedColumnName = "ruleCode")
	private Rule rule;

	@OneToMany
	@JoinColumn(name = "sector", referencedColumnName = "sectorCode")
	private List<Room> rooms;

	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Sector() {

	}

	public Sector(String sectorCode, String acronym, String sectorName, Rule rule, List<Room> rooms) {
		this.sectorCode = sectorCode;
		this.acronym = acronym;
		this.sectorName = sectorName;
		this.rooms = rooms;
	}

	public void register(Sector sector) {

	}

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return this.sectorCode;
	}



	
}
