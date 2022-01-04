package br.edu.ifs.academico.model.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.NameField;

@Entity
public class Room implements IEntity {

	@NameField(value = "Código")
	@Id
	private String roomCode;

	@NameField(value = "Regra")
	@ManyToOne
	@JoinColumn(name = "rule", referencedColumnName = "ruleCode")
	private Rule rule;

	@OneToMany
	@JoinColumn(name = "room", referencedColumnName = "roomCode")
	private Set<Bed> beds;

	//OBS: O campo currentVisits não é armazenado no banco 
	@Transient
	private Set<Visit> currentVisits;

	@ManyToOne(fetch = FetchType.LAZY)
	private Sector belongingSector;
	
	
	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public Set<Bed> getBeds() {
		return beds;
	}

	public void setBeds(Set<Bed> beds) {
		this.beds = beds;
	}

	public Set<Visit> getCurrentVisits() {
		return currentVisits;
	}
	
	public void setCurrentVisits(Set<Visit> currentVisits) {
		this.currentVisits = currentVisits;
	}
	
	
	public Sector getBelongingSector() {
		return belongingSector;
	}

	public void setBelongingSector(Sector belongingSector) {
		this.belongingSector = belongingSector;
	}

	public Room() {

	}

	public Room(String roomCode, Rule rule, Set<Bed> beds, Sector belongingSector) {
		this.roomCode = roomCode;
		this.rule = rule;
		this.beds = beds;
		this.belongingSector = belongingSector;
	}

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return this.roomCode;
	}


	
	@Override
	public String toString() {
		return "Room [roomCode=" + roomCode + ", rule=" + rule + ", beds=" + beds + ", currentVisits=" + currentVisits
				+ "]";
	}

	public void addVisit(Visit visit) {
		
		this.currentVisits.add(visit);
		
		
	}
	
	
	private void findVisits() {
		
		
		
	}
	

	
}
