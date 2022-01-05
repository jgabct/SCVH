package br.edu.ifs.academico.model.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.utils.annotations.Blocked;

@Entity
public class Rule implements IEntity {

	@Id
	@Blocked
	private String ruleCode;

	// Os atributos são dividos por ","
	// Os atributos dos args são indicados por "="
	// Os atributos dos args são divididos por "-"
	// Os conjuntos de args são divido pelas posições no List
	// Ex List.get(0) -> arg1=atr1-atr2 || List.get(1) -> arg1=atr1

	// A List turnArgs armazena os periodos aptos a visita
	// Suas informações são armazenadas puras: xx:xx - xx:xx

	@ElementCollection
	List<String> turnArgs;

	@ElementCollection
	List<String> capacityArgs;
	// A List capacityArgs armazena as regras dos periodos
	// Ou seja os args da posição 0 são equivalentes ao turnArgs na posição 0

    public Rule() {/*Construtor vazio*/}

	public Rule(List<String> turnArgs, List<String> capacityArgs) {
		setTurnArgs(turnArgs);
		setCapacityArgs(capacityArgs);
	}

	public Rule(String ruleCode, List<String> turnArgs, List<String> capacityArgs) {
		this(turnArgs,capacityArgs);
		setRuleCode(ruleCode);
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

	
	
	@Override
	public int hashCode() {
		return Objects.hash(ruleCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule other = (Rule) obj;
		return Objects.equals(ruleCode, other.ruleCode);
	}

	@Override
    public String getKey() {
        return getRuleCode();
    }

	@Override
	public String toString() {
		return "Rule [ruleCode=" + ruleCode + ", turnArgs=" + turnArgs + ", capacityArgs=" + capacityArgs + "]";
	}
	
}