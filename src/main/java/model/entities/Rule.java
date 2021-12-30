package br.edu.ifs.academico.model.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.ifs.academico.model.interfaces.Ientity;


@Entity
public class Rule implements Ientity {

	@Id
	private String ruleCode;
	private LocalTime morningEntryHour;
	private LocalTime morningExitHour;
	private LocalTime afternoongEntryHour;
	private LocalTime afternoonExitHour;
	private LocalTime nightEntryHour;
	private LocalTime nightExitHour;
	private int maxPerpacient;
	private int maxPerRoom;
	// O visitDuration armazena a duração da visita em minutos
	private int visitDuration;

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public LocalTime getMorningEntryHour() {
		return morningEntryHour;
	}

	public void setMorningEntryHour(LocalTime morningEntryHour) {
		this.morningEntryHour = morningEntryHour;
	}

	public LocalTime getMorningExitHour() {
		return morningExitHour;
	}

	public void setMorningExitHour(LocalTime morningExitHour) {
		this.morningExitHour = morningExitHour;
	}

	public LocalTime getAfternoongEntryHour() {
		return afternoongEntryHour;
	}

	public void setAfternoongEntryHour(LocalTime afternoongEntryHour) {
		this.afternoongEntryHour = afternoongEntryHour;
	}

	public LocalTime getAfternoonExitHour() {
		return afternoonExitHour;
	}

	public void setAfternoonExitHour(LocalTime afternoonExitHour) {
		this.afternoonExitHour = afternoonExitHour;
	}

	public LocalTime getNightEntryHour() {
		return nightEntryHour;
	}

	public void setNightEntryHour(LocalTime nightEntryHour) {
		this.nightEntryHour = nightEntryHour;
	}

	public LocalTime getNightExitHour() {
		return nightExitHour;
	}

	public void setNightExitHour(LocalTime nightExitHour) {
		this.nightExitHour = nightExitHour;
	}

	public int getMaxPerpacient() {
		return maxPerpacient;
	}

	public void setMaxPerpacient(int maxPerpacient) {
		this.maxPerpacient = maxPerpacient;
	}

	public int getMaxPerRoom() {
		return maxPerRoom;
	}

	public void setMaxPerRoom(int maxPerRoom) {
		this.maxPerRoom = maxPerRoom;
	}

	public int getVisitDuration() {
		return visitDuration;
	}

	public void setVisitDuration(int visitDuration) {
		this.visitDuration = visitDuration;
	}

	
	public Rule() {
		
	}
	
	
	// Construtor com atributos minimos para um regra com limite de duração
	public Rule(String ruleCode, int maxPerpacient, int maxPerRoom, int visitDuration) {
		this.ruleCode = ruleCode;
		this.maxPerpacient = maxPerpacient;
		this.maxPerRoom = maxPerRoom;
		this.visitDuration = visitDuration;
	}

	// Construtor com atributos minimos para um regra com limite de horario
	public Rule(String ruleCode, LocalTime morningEntryHour, LocalTime nightExitHour, int maxPerpacient, int maxPerRoom,
			int visitDuration) {
		this.ruleCode = ruleCode;
		this.morningEntryHour = morningEntryHour;
		this.nightExitHour = nightExitHour;
		this.maxPerpacient = maxPerpacient;
		this.maxPerRoom = maxPerRoom;
		this.visitDuration = visitDuration;
	}

	// Construtor completo
	public Rule(String ruleCode, LocalTime morningEntryHour, LocalTime morningExitHour, LocalTime afternoongEntryHour,
			LocalTime afternoonExitHour, LocalTime nightEntryHour, LocalTime nightExitHour, int maxPerpacient,
			int maxPerRoom, int visitDuration) {
		this.ruleCode = ruleCode;
		this.morningEntryHour = morningEntryHour;
		this.morningExitHour = morningExitHour;
		this.afternoongEntryHour = afternoongEntryHour;
		this.afternoonExitHour = afternoonExitHour;
		this.nightEntryHour = nightEntryHour;
		this.nightExitHour = nightExitHour;
		this.maxPerpacient = maxPerpacient;
		this.maxPerRoom = maxPerRoom;
		this.visitDuration = visitDuration;
	}



	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return this.ruleCode;
	}

	@Override
	public <E> void alter(E args) {
		// TODO Auto-generated method stub
		
		Rule preparedArgs = (Rule) args;
		
		this.morningEntryHour = preparedArgs.getMorningEntryHour();
		this.morningExitHour = preparedArgs.getMorningExitHour();
		this.afternoongEntryHour = preparedArgs.getAfternoongEntryHour();
		this.afternoonExitHour = preparedArgs.getAfternoonExitHour();
		this.nightEntryHour = preparedArgs.getNightEntryHour();
		this.nightExitHour = preparedArgs.getNightExitHour();
		this.maxPerpacient = preparedArgs.getMaxPerpacient();
		this.maxPerRoom = preparedArgs.getMaxPerRoom();
		this.visitDuration = preparedArgs.getVisitDuration();
		
	}

	



}
