package com.FinalProject.model.Employees;

import com.FinalProject.model.ReviewResult;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.view.DialogButton;

public class HumanResourceAssistant extends IEmployee { //Should make a seperate class HumanResource maybe
    private IEmployee successor;

    public HumanResourceAssistant(IEmployee successor,String name, String surname) {
        super(name,surname);
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

    public IEmployee getSuccessor() {
        return successor;
    }
}
