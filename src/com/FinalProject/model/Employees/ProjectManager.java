package com.FinalProject.model.Employees;

import com.FinalProject.model.ReviewResult;

public class ProjectManager extends IEmployee{
    private IEmployee successor;

    public ProjectManager(IEmployee successor) {
        this.successor = successor;
    }

    @Override
    ReviewResult reviewCandidate(IEmployee employee) {
        return null;
    }
}
