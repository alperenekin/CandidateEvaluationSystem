package com.FinalProject.model.JobAdvert;

import java.util.ArrayList;

import com.FinalProject.FileIO;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Team;

public class JobAdvert {
    private Team team;
    private String title;
    private String description;
    private String requirements;
    private Position position;
    private boolean isActive;
    private ArrayList<Candidate> appliedCandidates;

    public JobAdvert(Team team, String title, String description, String requirements, Position position, boolean isActive) {
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

    public Position getPosition() {
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
    	System.out.println(this.appliedCandidates.size());
    	this.appliedCandidates.add(candidate);
        FileIO.instance().saveJobAdvertToFile();
    }

    public ArrayList<Candidate> getAppliedCandidates() {
        return appliedCandidates;
    }

    public void setAppliedCandidates(ArrayList<Candidate> appliedCandidates) {
        this.appliedCandidates = appliedCandidates;
    }

}
