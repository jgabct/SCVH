package br.edu.ifs.academico.model.entities;

import br.edu.ifs.academico.model.interfaces.IEntity;

import java.time.LocalTime;
import java.util.Objects;

public class Rule implements IEntity {

    private String ruleCode;
    private LocalTime morningEntryHour;
    private LocalTime morningExitHour;
    private LocalTime afternoonEntryHour;
    private LocalTime afternoonExitHour;
    private LocalTime nightEntryHour;
    private LocalTime nightExitHour;
    private Integer maximumVisitorsPerPatient;
    private Integer maximumVisitorsPerRoom;
    // O visitDuration armazena a duração da visita em minutos
    private Integer visitDuration;

    public Rule() {/*Construtor vazio*/}

    // Construtor com atributos minimos para um regra com limite de duração
    public Rule(String ruleCode, Integer maximumVisitorsPerPatient, Integer maximumVisitorsPerRoom, Integer visitDuration) {
        setRuleCode(ruleCode);
        setMaximumVisitorsPerPatient(maximumVisitorsPerPatient);
        setmaximumVisitorsPerRoom(maximumVisitorsPerRoom);
        setVisitDuration(visitDuration);
    }

    // Construtor com atributos minimos para um regra com limite de horario
    public Rule(String ruleCode, LocalTime morningEntryHour, LocalTime nightExitHour, Integer maximumVisitorsPerPatient, Integer maximumVisitorsPerRoom,
                Integer visitDuration) {
        setRuleCode(ruleCode);
        setMorningEntryHour(morningEntryHour);
        setNightExitHour(nightExitHour);
        setMaximumVisitorsPerPatient(maximumVisitorsPerPatient);
        setmaximumVisitorsPerRoom(maximumVisitorsPerRoom);
        setVisitDuration(visitDuration);
    }

    // Construtor completo
    public Rule(String ruleCode, LocalTime morningEntryHour, LocalTime morningExitHour, LocalTime afternoongEntryHour,
                LocalTime afternoonExitHour, LocalTime nightEntryHour, LocalTime nightExitHour, Integer maximumVisitorsPerPatient,
                Integer maximumVisitorsPerRoom, Integer visitDuration) {
        setRuleCode(ruleCode);
        setMorningEntryHour(morningEntryHour);
        setMorningExitHour(morningExitHour);
        setAfternoonEntryHour(afternoongEntryHour);
        setAfternoonExitHour(afternoonExitHour);
        setNightEntryHour(nightEntryHour);
        setNightExitHour(nightExitHour);
        setMaximumVisitorsPerPatient(maximumVisitorsPerPatient);
        setmaximumVisitorsPerRoom(maximumVisitorsPerRoom);
        setVisitDuration(visitDuration);
    }

    public String getRuleCode() {
        return this.ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public LocalTime getMorningEntryHour() {
        return this.morningEntryHour;
    }

    public void setMorningEntryHour(LocalTime morningEntryHour) {
        this.morningEntryHour = morningEntryHour;
    }

    public LocalTime getMorningExitHour() {
        return this.morningExitHour;
    }

    public void setMorningExitHour(LocalTime morningExitHour) {
        this.morningExitHour = morningExitHour;
    }

    public LocalTime getAfternoonEntryHour() {
        return this.afternoonEntryHour;
    }

    public void setAfternoonEntryHour(LocalTime afternoonEntryHour) {
        this.afternoonEntryHour = afternoonEntryHour;
    }

    public LocalTime getAfternoonExitHour() {
        return this.afternoonExitHour;
    }

    public void setAfternoonExitHour(LocalTime afternoonExitHour) {
        this.afternoonExitHour = afternoonExitHour;
    }

    public LocalTime getNightEntryHour() {
        return this.nightEntryHour;
    }

    public void setNightEntryHour(LocalTime nightEntryHour) {
        this.nightEntryHour = nightEntryHour;
    }

    public LocalTime getNightExitHour() {
        return this.nightExitHour;
    }

    public void setNightExitHour(LocalTime nightExitHour) {
        this.nightExitHour = nightExitHour;
    }

    public Integer getMaximumVisitorsPerPatient() {
        return this.maximumVisitorsPerPatient;
    }

    public void setMaximumVisitorsPerPatient(Integer maximumVisitorsPerPatient) {
        this.maximumVisitorsPerPatient = maximumVisitorsPerPatient;
    }

    public Integer getmaximumVisitorsPerRoom() {
        return this.maximumVisitorsPerRoom;
    }

    public void setmaximumVisitorsPerRoom(Integer maximumVisitorsPerRoom) {
        this.maximumVisitorsPerRoom = maximumVisitorsPerRoom;
    }

    public Integer getVisitDuration() {
        return this.visitDuration;
    }

    public void setVisitDuration(Integer visitDuration) {
        this.visitDuration = visitDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return ruleCode.equals(rule.ruleCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleCode);
    }

    //    public void register(Rule rule) {
//
//    }

    @Override
    public String getKey() {
        return getRuleCode();
    }

}