package com.FinalProject.model.Employees;

import com.FinalProject.model.Candidate.Candidate;

public abstract class Employee {
    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private String name;
    private String surname;

    abstract void reviewCandidate(Candidate candidate);

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


}
