package visits;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;

import users.Visitor;

@Entity
public class Visit {

	@Id
	private String visitId;
	private String visitorCpf;
	private String pacientCode;
	private boolean accompanying;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getVisitorCpf() {
		return visitorCpf;
	}

	public void setVisitorCpf(String visitorCpf) {
		this.visitorCpf = visitorCpf;
	}

	public String getPacientCode() {
		return pacientCode;
	}

	public void setPacientCode(String pacientCode) {
		this.pacientCode = pacientCode;
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

	public Visit() {
		
	}
	
	public Visit(String visitId, String visitorCpf, String pacientCode, boolean accompanying, LocalDateTime entryDate,
			LocalDateTime exitDate) {
		this.visitId = visitId;
		this.visitorCpf = visitorCpf;
		this.pacientCode = pacientCode;
		this.accompanying = accompanying;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
	}

	public void register(Visitor visitor, Pacient pacient) {

	}

	public static List<Visit> list(EntityManager em) {

		return em.createQuery("SELECT e FROM Visit e", Visit.class).getResultList();

	}

	public void markEntryDate() {

	}

	public void markExitDate() {

	}

}
