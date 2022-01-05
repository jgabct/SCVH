package br.edu.ifs.academico.model.entities;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.annotations.Blocked;
import br.edu.ifs.academico.utils.annotations.ItIsABox;
import br.edu.ifs.academico.utils.annotations.NameField;

@Entity
public class Room implements IEntity {

	@Id
	@Blocked
	@NameField(value = "Código")
	private String roomCode;

	@NameField(value = "Regra")
	@ManyToOne
	@JoinColumn(name = "rule", referencedColumnName = "ruleCode")
	@ItIsABox
	private Rule rule;

	@OneToMany
	@JoinColumn(name = "room", referencedColumnName = "roomCode")
	private Set<Bed> beds;

	//OBS: O campo currentVisits não é armazenado no banco 
	@Transient
	private Set<Visit> currentVisits;

	@ManyToOne(fetch = FetchType.LAZY)
	@ItIsABox
	private Sector belongingSector;
	

    public Room() {/*Construtor vazio*/}

    public Room(String roomCode, Sector belongingSector) {
        setRoomCode(roomCode);
        setBelongingSector(belongingSector);
    }

    public Room(String roomCode, Rule rule, Sector belongingSector) {
        this(roomCode, belongingSector);
        setRule(rule);
    }
    
    public Room(String roomCode, Sector sectorCode, Set<Bed> listBeds) {
    	this(roomCode, sectorCode);
    	setBeds(listBeds);
    }
    public Room(String roomCode, Rule ruleCode, Sector sectorCode, Set<Bed> listBeds) {
    	this(roomCode, ruleCode, sectorCode);
    	setBeds(listBeds);
    }

    public String getRoomCode() {
        return this.roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public Rule getRule() {
        return this.rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Sector getBelongingSector() {
		return this.belongingSector;
	}

	public void setBelongingSector(Sector belongingSector) {
		this.belongingSector = belongingSector;
	}

	public Set<Bed> getBeds() {
		return this.beds;
	}

	public void setBeds(Set<Bed> beds) {
		this.beds = beds;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(roomCode, other.roomCode);
	}

	@Override
    public String getKey() {
        return getRoomCode();
    }
	
	public void addVisit(Visit visit) {
		this.currentVisits.add(visit);
	}
	
	public static List<String> summaryValues() {
		return new GenericOperations<Room>(Room.class).list()
				.stream()
				.map( room -> room.getKey())
				.collect(Collectors.toList());
	}
	
//	private void findVisits() {
//		
//	}

	@Override
	public String toString() {
		return "Room [roomCode=" + roomCode + ", rule=" + rule + ", beds=" + beds + ", currentVisits=" + currentVisits
				+ ", belongingSector=" + belongingSector + "]";
	}




	
}