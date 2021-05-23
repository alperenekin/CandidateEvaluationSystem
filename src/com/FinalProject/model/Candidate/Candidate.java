package com.FinalProject.model.Candidate;

import com.FinalProject.Utill.AppUtill;
import com.FinalProject.model.States.BaseState;
import com.FinalProject.model.States.Starter;

public abstract class Candidate {
    private int candidateId;
    private String name;
    private String surname;
    private BaseState applicationState;
    private int softSkills;
    private int technicalSkills;
    private int compatibleness;
    private String cv;
    private String passwd;

    public Candidate(String name, String surname) {
        candidateId = AppUtill.candidateId;
        AppUtill.candidateId +=1;
        this.name = name;
        this.surname = surname;
        applicationState = Starter.instance();
        this.cv = "simdilik bos diger constructorda asl cv alan";
    }
    public Candidate(String name, String surname,String cv) {
    	this.name = name;
        this.surname = surname;
        applicationState = Starter.instance();
        this.cv = cv;
        this.passwd=name+surname;
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
    public String getPasswd() {
    	return this.passwd;
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


    public int getCandidateId() {
        return candidateId;
    }
}
