package br.edu.ifs.academico.model.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.ifs.academico.model.interfaces.IEntity;

@Entity
public class Rule implements IEntity {

	@Id
	private String ruleCode;

	// Os atributos s�o dividos por ","
	// Os atributos dos args s�o indicados por "="
	// Os atributos dos args s�o divididos por "-"
	// Os conjuntos de args s�o divido pelas posi��es no List
	// Ex List.get(0) -> arg1=atr1-atr2 || List.get(1) -> arg1=atr1

	// A List turnArgs armazena os periodos aptos a visita
	// Suas informa��es s�o armazenadas puras: xx:xx - xx:xx

	@ElementCollection
	List<String> turnArgs;

	@ElementCollection
	List<String> capacityArgs;
	// A List capacityArgs armazena as regras dos periodos
	// Ou seja os args da posi��o 0 s�o equivalentes ao turnArgs na posi��o 0

	public Rule() {

	}

	public Rule(List<String> turnArgs, List<String> capacityArgs) {
		this.turnArgs = turnArgs;
		this.capacityArgs = capacityArgs;

	}

	public Rule(String ruleCode, List<String> turnArgs, List<String> capacityArgs) {
		this.ruleCode = ruleCode;
		this.turnArgs = turnArgs;
		this.capacityArgs = capacityArgs;
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public List<String> getTurnArgs() {
		return turnArgs;
	}

	public void setTurnArgs(List<String> turnArgs) {
		this.turnArgs = turnArgs;
	}

	public List<String> getCapacityArgs() {
		return capacityArgs;
	}

	public void setCapacityArgs(List<String> capacityArgs) {
		this.capacityArgs = capacityArgs;
	}

	/*
	 * Caracteres:
	 * 
	 * maxv = xxx -> Define a quantidade de maxima de visitantes por area (Setor ou
	 * quarto). abrevia��o de max visitors
	 * 
	 * mxpp = xxx -> Define a quantidade maxima de vistantes por paciente.
	 * abrevia��o de max visitors per patient
	 * 
	 * vipu = xxx -> Define a quantidade de aumento de visitantes por leito
	 * desocupado. abrevia��o de visitor increase per unocuppied bed
	 * 
	 * 
	 */

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return this.ruleCode;
	}

	@Override
	public String toString() {
		return "Rule [ruleCode=" + ruleCode + ", turnArgs=" + turnArgs + ", capacityArgs=" + capacityArgs + "]";
	}

	
	
	
}
