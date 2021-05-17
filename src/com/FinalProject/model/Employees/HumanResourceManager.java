package com.FinalProject.model.Employees;

import com.FinalProject.model.Candidate;
import com.FinalProject.model.ReviewResult;

public class HumanResourceManager extends IEmployee {
    private IEmployee successor;

    public HumanResourceManager(IEmployee successor,String name, String surname) {
        super(name, surname);
        this.successor = successor;
    }

    @Override
    public ReviewResult reviewCandidate(Candidate candidate) {
        int technicalSkill = candidate.getTechnicalSkills();
        int softSkill = candidate.getSoftSkills();
        int compatibleness = candidate.getCompatibleness();
        int avg = (technicalSkill+softSkill+compatibleness)/3;
        if(avg > 6){
            candidate.changeState();
        }else{
            System.out.println("This candidate is eleminated");
        }
        return null;
    }
}
