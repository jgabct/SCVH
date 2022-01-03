package br.edu.ifs.academico.model.entities;

import java.util.List;
import java.util.Objects;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.NameField;

public class Room implements IEntity {

	@NameField(value = "Código")
    private String roomCode;
	
	@NameField(value = "Regra")
    private Rule rule;
    
	@NameField(value = "Setor")
	private Sector sector;
	
	private List<Bed> listBeds;

    public Room() {/*Construtor vazio*/}

    public Room(String roomCode, Sector sectorCode) {
        setRoomCode(roomCode);
        setSector(sectorCode);
    }

    public Room(String roomCode, Rule ruleCode, Sector sectorCode) {
        this(roomCode, sectorCode);
        setRule(ruleCode);
    }
    
    public Room(String roomCode, Sector sectorCode, List<Bed> listBeds) {
    	this(roomCode, sectorCode);
    	setListBeds(listBeds);
    }
    public Room(String roomCode, Rule ruleCode, Sector sectorCode, List<Bed> listBeds) {
    	this(roomCode, ruleCode, sectorCode);
    	setListBeds(listBeds);
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

    public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public List<Bed> getListBeds() {
		return listBeds;
	}

	public void setListBeds(List<Bed> listBeds) {
		this.listBeds = listBeds;
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

	@Override
	public String toString() {
		return "Room [roomCode=" + roomCode + ", rule=" + rule + ", sector=" + sector + "]";
	}



	
}