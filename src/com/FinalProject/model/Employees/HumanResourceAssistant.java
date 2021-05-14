package com.FinalProject.model.Employees;

import com.FinalProject.model.ReviewResult;

public class HumanResourceAssistant extends IEmployee { //Should make a seperate class HumanResource maybe
    private IEmployee successor;

    public HumanResourceAssistant(IEmployee successor,String name, String surname) {
        super(name,surname);
        this.successor = successor;
    }

    @Override
    ReviewResult reviewCandidate(IEmployee employee) {
        return null;
    }
}
