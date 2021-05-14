package com.FinalProject.model.Employees;

import com.FinalProject.model.ReviewResult;

public class HumanResourceManager extends IEmployee {
    private IEmployee successor;

    public HumanResourceManager(IEmployee successor,String name, String surname) {
        super(name, surname);
        this.successor = successor;
    }

    @Override
    ReviewResult reviewCandidate(IEmployee employee) {
        return null;
    }
}
