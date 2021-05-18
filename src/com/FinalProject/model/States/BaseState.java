package com.FinalProject.model.States;

import com.FinalProject.model.Candidate.Candidate;

public abstract class BaseState {
    private String name;

    public BaseState(String name) {
        this.name = name;
    }

    public abstract void changeState(Candidate candidate);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
