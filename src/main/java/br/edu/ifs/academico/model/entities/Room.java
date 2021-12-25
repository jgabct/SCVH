package br.edu.ifs.academico.model.entities;

import br.edu.ifs.academico.model.interfaces.IEntity;

import java.util.List;
import java.util.Objects;

public class Room implements IEntity {

    private String roomCode;
    private Rule rule;
    private List<Bed> beds;

    public Room() {/*Construtor vazio*/}

    public Room(String roomCode, List<Bed> beds) {
        setRoomCode(roomCode);
        setBeds(beds);
    }

    public Room(String roomCode, Rule rule, List<Bed> beds) {
        setRoomCode(roomCode);
        setRule(rule);
        setBeds(beds);
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

    public List<Bed> getBeds() {
        return this.beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomCode.equals(room.roomCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomCode);
    }

//    public void register(Room room, Sector sector) {
//
//    }

    @Override
    public String getKey() {
        return this.roomCode;
    }

}