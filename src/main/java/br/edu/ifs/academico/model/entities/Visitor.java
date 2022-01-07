package br.edu.ifs.academico.model.entities;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.edu.ifs.academico.model.interfaces.IEntity;
import br.edu.ifs.academico.model.services.GenericOperations;
import br.edu.ifs.academico.utils.annotations.Blocked;
import br.edu.ifs.academico.utils.annotations.NameField;

@Entity
public class Visitor implements IEntity {

	@Id
	@Blocked
	@NameField(value="CPF")		 
	private String cpf;
	
	@NameField(value="Nome")
	private String name;

	@NameField(value="RG")
	private String rg;
	
	@NameField(value = "Telefone")
	private String phone;
	
	private String employeeRegistry;
	
	@OneToMany(mappedBy = "visitor")
	private Set<Visit> visits;

    // O query necessita do construtor padrão (Vazio)
    public Visitor() {/*Construtor vazio*/}

    public Visitor(String cpf, String name, String rg, String phone) {
        setCpf(cpf);
        setName(name);
        setRg(rg);
        setPhone(phone);
	}
    
    public Visitor(String cpf, String name, String rg, String phone, String employeeRegistry) {
    	this(cpf,  name,  rg,  phone);
        setEmployeeRegistry(employeeRegistry);
    }

	public Visitor(String cpf, String name, String password, String rg, String phone, String employeeRegistry, Set<Visit> visits) {
		this(cpf, name, rg, phone, employeeRegistry);
		this.visits = visits;
	}

    public String getCpf() { return this.cpf; }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() { return this.name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() { return this.rg; }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getPhone() { return this.phone; }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployeeRegistry() { return this.employeeRegistry; }

    public void setEmployeeRegistry(String employeeRegistry) {
        this.employeeRegistry = employeeRegistry;
    }
    
	public Set<Visit> getVisits() { return this.visits;	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitor other = (Visitor) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
    public String getKey() {
        return getCpf();
    }
	
	@Override
    public void setKey(String key) {
        setCpf(key);
    }
	
	@Override
	public void check() {
	}
	
	@Override
	public List<String> summaryValues() {
		return new GenericOperations<Visitor>(Visitor.class).list()
				.stream()
				.map( visitor -> visitor.getKey())
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "Visitor [cpf=" + cpf + ", name=" + name + ", rg=" + rg + ", phone=" + phone + ", employeeRegistry="
				+ employeeRegistry + ", visits=" + visits + "]";
	}

}