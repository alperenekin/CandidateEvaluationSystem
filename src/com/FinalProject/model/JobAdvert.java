package com.FinalProject.model;

import java.util.ArrayList;

import com.FinalProject.model.Candidate.Candidate;

public class JobAdvert {
    private Team team;
    private String title;
    private String description;
    private String requirements;
    private String position;
    private boolean isActive;
    private ArrayList<Candidate> appliedCandidates;

    public JobAdvert(Team team, String title, String description, String requirements, String position, boolean isActive) {
        this.team = team;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.position = position;
        this.isActive = isActive;
        this.appliedCandidates = new ArrayList<Candidate>();
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public String getTitle() {
        return title;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getRequirements() {
        return requirements;
    }
    public void addCandidate(Candidate candidate) {
    	System.out.println("gelen candidate");
    	System.out.println(this.appliedCandidates.size());
    	this.appliedCandidates.add(candidate);
    }
}
