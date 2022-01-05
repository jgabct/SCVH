package br.edu.ifs.academico.model.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.ifs.academico.model.interfaces.IEntity;

@Entity
public class Visit implements IEntity {

	@Id
	private String visitId;

	@ManyToOne
	@JoinColumn(name = "visitorCpf")
	private Visitor visitor;
	
	@ManyToOne
	@JoinColumn(name = "pacientCode")
	private Patient pacient;

	private String roomCode;
	private boolean accompanying;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;

    public Visit() {/*Construtor vazio*/}
    
    public Visit(String visitId, Visitor visitor, Patient pacient, String roomCode, boolean accompanying,
			LocalDateTime entryDate) {
		this.visitId = visitId;
		this.visitor = visitor;
		this.pacient = pacient;
		this.roomCode = roomCode;
		this.accompanying = accompanying;
		this.entryDate = entryDate;
	}

	public Visit(String visitId, Visitor visitor, Patient pacient, String roomCode, boolean accompanying,
			LocalDateTime entryDate, LocalDateTime exitDate) {
		this.visitId = visitId;
		this.visitor = visitor;
		this.pacient = pacient;
		this.roomCode = roomCode;
		this.accompanying = accompanying;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Patient getPacient() {
		return pacient;
	}

	public void setPacient(Patient pacient) {
		this.pacient = pacient;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public boolean isAccompanying() {
		return accompanying;
	}

	public void setAccompanying(boolean accompanying) {
		this.accompanying = accompanying;
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public LocalDateTime getExitDate() {
		return exitDate;
	}

	public void setExitDate(LocalDateTime exitDate) {
		this.exitDate = exitDate;
	}

    @Override
	public int hashCode() {
		return Objects.hash(pacient, visitId, visitor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;
		return Objects.equals(pacient, other.pacient) && Objects.equals(visitId, other.visitId)
				&& Objects.equals(visitor, other.visitor);
	}

	@Override
    public String getKey() {
        return getVisitId();
    }
	
//	public void markEntryDate() {
//
//	}
//
//	public void markExitDate() {
//
//	}

	@Override
	public String toString() {
		return "Visit [visitId=" + visitId + ", visitor=" + visitor + ", pacient=" + pacient + ", roomCode=" + roomCode
				+ ", accompanying=" + accompanying + ", entryDate=" + entryDate + ", exitDate=" + exitDate + "]";
	}

}