package com.FinalProject.model;

import com.FinalProject.model.States.BaseState;
import com.FinalProject.model.States.Starter;

public class Candidate {
    private String name;
    private String surname;
    private BaseState applicationState;
    private int softSkills;
    private int technicalSkills;
    private int compatibleness;

    public Candidate(String name, String surname) {
        this.name = name;
        this.surname = surname;
        applicationState = Starter.instance();
    }

    public void changeState(){
        applicationState.changeState(this);
    }

    public BaseState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(BaseState applicationState) {
        this.applicationState = applicationState;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(int softSkills) {
        this.softSkills = softSkills;
    }

    public int getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(int technicalSkills) {
        this.technicalSkills = technicalSkills;
    }

    public int getCompatibleness() {
        return compatibleness;
    }

    public void setCompatibleness(int compatibleness) {
        this.compatibleness = compatibleness;
    }


}
