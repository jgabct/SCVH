package br.edu.ifs.academico.model.entities;


import br.edu.ifs.academico.model.interfaces.IEntity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Visit implements IEntity {

    private String visitId;
    private String visitorCpf;
    private String patientLinkCode;
    private Boolean accompanying;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;

    public Visit() {/*Construtor vazio*/}

    public Visit(String visitId, String visitorCpf, String patientLinkCode, Boolean accompanying,
                 LocalDateTime entryDate, LocalDateTime exitDate) {
        setVisitId(visitId);
        setVisitorCpf(visitorCpf);
        setPatientLinkCode(patientLinkCode);
        setAccompanying(accompanying);
        setEntryDate(entryDate);
        setExitDate(exitDate);
    }

    public String getVisitId() {
        return this.visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getVisitorCpf() {
        return this.visitorCpf;
    }

    public void setVisitorCpf(String visitorCpf) {
        this.visitorCpf = visitorCpf;
    }

    public String getPatientLinkCode() {
        return this.patientLinkCode;
    }

    public void setPatientLinkCode(String patientLinkCode) {
        this.patientLinkCode = patientLinkCode;
    }

    public Boolean isAccompanying() {
        return this.accompanying;
    }

    public void setAccompanying(Boolean accompanying) {
        this.accompanying = accompanying;
    }

    public LocalDateTime getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getExitDate() {
        return this.exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return visitId.equals(visit.visitId) && visitorCpf.equals(visit.visitorCpf)
                && patientLinkCode.equals(visit.patientLinkCode) && accompanying.equals(visit.accompanying)
                && entryDate.equals(visit.entryDate) && exitDate.equals(visit.exitDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitId, visitorCpf, patientLinkCode, accompanying, entryDate, exitDate);
    }

    //    public void register(Visitor visitor, Patient patient) {
//
//    }
//
//    public void markEntryDate() {
//
//    }
//
//    public void markExitDate() {
//
//    }

    @Override
    public String getKey() {
        return getVisitId();
    }

}