package com.FinalProject.model.Employees;

import com.FinalProject.model.ReviewResult;

public abstract class IEmployee {
    public IEmployee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private String name;
    private String surname;

    abstract ReviewResult reviewCandidate(IEmployee employee);

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


}
