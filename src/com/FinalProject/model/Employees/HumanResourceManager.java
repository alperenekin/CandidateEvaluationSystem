package com.FinalProject.model.Employees;

import com.FinalProject.Utill.FileIO;
import com.FinalProject.model.Candidate.Candidate;

public class HumanResourceManager extends Employee {
    private ProjectManager successor;

    public HumanResourceManager(ProjectManager successor,String name, String surname) {
        super(name, surname);
        this.successor = successor;
    }

    @Override
    public void reviewCandidate(Candidate candidate) {
        int technicalSkill = candidate.getTechnicalSkills();
        int softSkill = candidate.getSoftSkills();
        int compatibleness = candidate.getCompatibleness();
        int avg = (technicalSkill+softSkill+compatibleness)/3;
        if(avg > 6){
            candidate.changeState();
            candidate.resetCandidateSkills();
        }else{
            System.out.println("This candidate is eleminated");
        }
        FileIO.instance().saveCandidatesToFile();
    }

    public ProjectManager getSuccessor() {
        return successor;
    }
}
