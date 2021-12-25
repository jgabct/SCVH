package br.edu.ifs.academico.model.entities;

import br.edu.ifs.academico.model.interfaces.IEntity;

import java.util.Objects;

public class Patient implements IEntity {

    private String linkCode;
    private String name;
    private String employeeRegistry;

    public Patient() {/*Construtor vazio*/}

    public Patient(String linkCode, String name, String employeeRegistry) {
        setLinkCode(linkCode);
        setName(name);
        setEmployeeRegistry(employeeRegistry);
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

    public String getEmployeeRegistry() {
        return this.employeeRegistry;
    }

    public void setEmployeeRegistry(String employeeRegistry) {
        this.employeeRegistry = employeeRegistry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return linkCode.equals(patient.linkCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkCode);
    }

    // O metodo hospitalize(Internar) não fazeria mais sentido estar na classe
    // Employee ?
    // Já que uma ação realizada por um funcionario ?
//    public void hospitalize(Pacient pacient, Bed bed) {
//
//    }

    @Override
    public String getKey() {
        return getLinkCode();
    }

}