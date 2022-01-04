package br.edu.ifs.academico.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.NameField;

@Entity
public class Sector implements IEntity {

	@NameField(value = "Código")
	@Id
	private String sectorCode;
	
	@NameField(value = "Sigla")
	private String acronym;
	@NameField(value = "Nome")
	private String sectorName;
	@NameField(value = "Regra")
	@ManyToOne
	@JoinColumn(name = "rule", referencedColumnName = "ruleCode")
	private Rule rule;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "belongingSector")
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

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public Sector() {

	}

	public Sector(String sectorCode, String acronym, String sectorName, Rule rule, List<Room> rooms) {
		this.sectorCode = sectorCode;
		this.acronym = acronym;
		this.sectorName = sectorName;
		this.rule = rule;
		this.rooms = rooms;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return this.sectorCode;
	}



}
