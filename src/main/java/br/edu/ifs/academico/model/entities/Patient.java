package br.edu.ifs.academico.model.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.annotations.Blocked;
import br.edu.ifs.academico.utils.annotations.ItIsABox;
import br.edu.ifs.academico.utils.annotations.NameField;

@Entity
public class Patient implements IEntity {

	@Id
	@Blocked
	@NameField(value = "Código de Referência")
	private String linkCode;
	
	@NameField(value = "Nome")
	private String name;
	
	private String employeeRegistry;

//	@NameField(value = "Data de Nascimento")
	private LocalDate birthDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pacient")
	private Set<Visit> visits;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "occupiedBedId", referencedColumnName = "propertyNumber")
	@NameField(value = "Leito")
	@ItIsABox
	private Bed occupiedBed;

//    public Patient() {/*Construtor vazio*/}
//
//    public Patient(String linkCode, String name, LocalDate birthDate, String employeeRegistry, String propertyNumber) {
//        setLinkCode(linkCode);
//        setName(name);
//        setBirthDate(birthDate);
//        setEmployeeRegistry(employeeRegistry);
//        setPropertyNumber(propertyNumber); //leito
//    }
	
	public Patient() {/*Construtor vazio*/}

	public Patient(String linkCode, String name, String employeeRegistry, LocalDate birthDate, Bed occupiedBed) {
		setLinkCode(linkCode);
		setName(name);
		setEmployeeRegistry(employeeRegistry);
		setBirthDate(birthDate);
		setOccupiedBed(occupiedBed);
	}

	public Patient(String linkCode, String name, String employeeRegistry, LocalDate birthDate, Bed occupiedBed, Set<Visit> visits) {
		this(linkCode, name, employeeRegistry, birthDate, occupiedBed);
		setVisits(visits);
	}

    public String getLinkCode() {
        return this.linkCode;
    }

    public void setLinkCode(String linkCode) {
        this.linkCode = linkCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmployeeRegistry() {
        return this.employeeRegistry;
    }

    public void setEmployeeRegistry(String employeeRegistry) {
        this.employeeRegistry = employeeRegistry;
    }

    public Bed getOccupiedBed() {
		return occupiedBed;
	}

	public void setOccupiedBed(Bed occupiedBed) {
		this.occupiedBed = occupiedBed;
	}

	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, linkCode, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(linkCode, other.linkCode)
				&& Objects.equals(name, other.name);
	}
	
	public void hospitalize(Patient pacient, Bed bed) {

	}

	@Override
    public String getKey() {
        return getLinkCode();
    }
	
	@Override
    public void setKey(String key) {
    }
	
	@Override
	public void check() {
		getOccupiedBed().check();
	}
	
	@Override
	public List<String> summaryValues() {
		return new GenericOperations<Patient>(Patient.class).list()
				.stream()
				.map( patient -> patient.getKey())
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "Patient [linkCode=" + linkCode + ", name=" + name + ", employeeRegistry=" + employeeRegistry
				+ ", birthDate=" + birthDate + ", visits=" + visits + ", occupiedBed=" + occupiedBed + "]";
	}
	
}