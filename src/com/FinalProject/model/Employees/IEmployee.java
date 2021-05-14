package com.FinalProject.model.Employees;

import com.FinalProject.model.ReviewResult;

public abstract class IEmployee {
    private String name;
    private String surname;

    abstract ReviewResult reviewCandidate(IEmployee employee);
}
