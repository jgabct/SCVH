package br.edu.ifs.academico.model.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.NameField;

@Entity
public class Patient implements IEntity {

	@Id
	@NameField(value = "Código de Referência")
	private String linkCode;
	@NameField(value = "Nome")
	private String name;
	private String employRgstry;

	@NameField(value = "Data de Nascimento")
	private LocalDate birthDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pacient")
	private Set<Visit> visits;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "occupiedBedId", referencedColumnName = "propertyNumber")
	@NameField(value = "Leito")
	private Bed occupiedBed;

	public String getLinkCode() {
		return linkCode;
	}

	public void setLinkCode(String linkCode) {
		this.linkCode = linkCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployRgstry() {
		return employRgstry;
	}

	public void setEmployRgstry(String employRgstry) {
		this.employRgstry = employRgstry;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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

	public Patient() {

	}

	public Patient(String linkCode, String name, String employRgstry, LocalDate birthDate, Bed occupiedBed) {
		this.linkCode = linkCode;
		this.name = name;
		this.employRgstry = employRgstry;
		this.birthDate = birthDate;
		this.occupiedBed = occupiedBed;
	}

	public Patient(String linkCode, String name, String employRgstry, LocalDate birthDate, Bed occupiedBed,
			Set<Visit> visits) {
		this.linkCode = linkCode;
		this.name = name;
		this.employRgstry = employRgstry;
		this.birthDate = birthDate;
		this.occupiedBed = occupiedBed;
		this.visits = visits;
	}

	// O metodo hospitalize(Internar) não fazeria mais sentido estar na classe
	// Employee ?
	// Já que uma ação realizada por um funcionario ?
	public void hospitalize(Patient pacient, Bed bed) {

	}

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return this.linkCode;
	}

}
