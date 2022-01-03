package br.edu.ifs.academico.model.entities;

import java.util.Objects;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.NameField;

public class Sector implements IEntity {

	@NameField(value = "Código")
    private String sectorCode;
    
	@NameField(value = "Sigla")
	private String acronym;
    
	@NameField(value = "Nome")
	private String sectorName;
    
	@NameField(value = "Regra")
	private Rule rule;

    public Sector() {/*Construtor vazio*/}

    public Sector(String sectorCode, String acronym, String sectorName) {
        setSectorCode(sectorCode);
        setAcronym(acronym);
        setSectorName(sectorName);
    }
    
    public Sector(String sectorCode, String acronym, String sectorName, Rule rule) {
        setSectorCode(sectorCode);
        setAcronym(acronym);
        setSectorName(sectorName);
        setRuleCode(rule);
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

    public Rule getRuleCode() {
        return this.rule;
    }

    public void setRuleCode(Rule rule) {
        this.rule = rule;
    }

	@Override
	public int hashCode() {
		return Objects.hash(sectorCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sector other = (Sector) obj;
		return Objects.equals(sectorCode, other.sectorCode);
	}

	@Override
    public String getKey() {
        return getSectorCode();
    }

	@Override
	public String toString() {
		return "Sector [sectorCode=" + sectorCode + ", acronym=" + acronym + ", sectorName=" + sectorName + ", rule="
				+ rule + "]";
	}

}