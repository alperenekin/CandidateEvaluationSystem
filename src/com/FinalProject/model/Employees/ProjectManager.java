package com.FinalProject.model.Employees;

import com.FinalProject.model.ReviewResult;

public class ProjectManager extends IEmployee{

    public ProjectManager(String name, String surname) {
        super(name, surname);
    }

    @Override
    ReviewResult reviewCandidate(IEmployee employee) {
        return null;
    }
}
