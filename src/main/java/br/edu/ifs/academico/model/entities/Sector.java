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

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.annotations.Blocked;
import br.edu.ifs.academico.utils.annotations.ItIsABox;
import br.edu.ifs.academico.utils.annotations.NameField;
import br.edu.ifs.academico.utils.enums.KeyField;

@Entity()
public class Sector implements IEntity {

	@Id
	@Blocked
	@KeyField
	@NameField(value = "Código")
	private String sectorCode;
	
	@NameField(value = "Sigla")
	private String acronym;
	
	@NameField(value = "Nome")
	private String sectorName;
	
//	@NameField(value = "Regra")
	@ManyToOne
	@JoinColumn(name = "rule", referencedColumnName = "ruleCode")
	@ItIsABox
	private Rule rule;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "belongingSector")
	private Set<Room> rooms;


    public Sector() {/*Construtor vazio*/}
    
    public Sector(String sectorCode, String acronym, String sectorName, Rule rule) {
        setSectorCode(sectorCode);
        setAcronym(acronym);
        setSectorName(sectorName);
        setRuleCode(rule);
    }

    public String getSectorCode() { return this.sectorCode; }

    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }

    public String getAcronym() { return this.acronym; }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getSectorName() { return this.sectorName; }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public Rule getRuleCode() { return this.rule; }

    public void setRuleCode(Rule rule) {
        this.rule = rule;
    }
    
	public Set<Room> getRooms() { return this.rooms; }

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
    public void setKey(String key) {
        setSectorCode(key);
    }
	
	@Override
	public void check() {
	}
	
	@Override
	public List<String> summaryValues() {
		return new GenericOperations<Sector>(Sector.class).list()
				.stream()
				.map( sector -> sector.getKey())
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "Sector [sectorCode=" + sectorCode + ", acronym=" + acronym + ", sectorName=" + sectorName + ", rule="
				+ rule + ", rooms=" + rooms + "]";
	}



}