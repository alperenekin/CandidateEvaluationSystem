package com.FinalProject.model;

public class Candidate {
    private String name;
    private String surname;
    private int softSkills;
    private int technicalSkills;
    private int compatibleness;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Candidate(String name, String surname) {
        this.name = name;
        this.surname = surname;
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
