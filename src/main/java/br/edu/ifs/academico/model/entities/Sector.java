package br.edu.ifs.academico.model.entities;

import br.edu.ifs.academico.model.interfaces.IEntity;

import java.util.List;
import java.util.Objects;

public class Sector implements IEntity {

    private String sectorCode;
    private String acronym;
    private String sectorName;
    private Rule rule;
    private List<Room> rooms;

    public Sector() {/*Construtor vazio*/}

    public Sector(String sectorCode, String acronym, String sectorName, Rule rule, List<Room> rooms) {
        setSectorCode(sectorCode);
        setAcronym(acronym);
        setSectorName(sectorName);
        setRule(rule);
        setRooms(rooms);
    }

    public String getSectorCode() {
        return this.sectorCode;
    }

    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }

    public String getAcronym() {
        return this.acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getSectorName() {
        return this.sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public Rule getRule() {
        return this.rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sector sector = (Sector) o;
        return sectorCode.equals(sector.sectorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectorCode);
    }

    //    public void register(Sector sector) {
//
//    }

    @Override
    public String getKey() {
        return getSectorCode();
    }

}