package com.FinalProject.model.Employees;

import com.FinalProject.Utill.FileIO;
import com.FinalProject.model.Candidate.Candidate;

public class ProjectManager extends Employee{

    public ProjectManager(String name, String surname) {
        super(name, surname);
    }

    @Override
    public void reviewCandidate(Candidate candidate) {
        int technicalSkill = candidate.getTechnicalSkills();
        int softSkill = candidate.getSoftSkills();
        int compatibleness = candidate.getCompatibleness();
        int avg = (technicalSkill+softSkill+compatibleness)/3;
        if(avg > 6){
            candidate.changeState();
        }else{
            System.out.println("This candidate is eleminated");
        }
        FileIO.instance().saveCandidatesToFile();
    }
}
