package com.FinalProject.model.Employees;

import com.FinalProject.model.ReviewResult;

public class HumanResourceAssistant extends IEmployee { //Should make a seperate class HumanResource maybe
    private IEmployee successor;

    public HumanResourceAssistant(IEmployee successor) {
        this.successor = successor;
    }

    @Override
    ReviewResult reviewCandidate(IEmployee employee) {
        return null;
    }
}
