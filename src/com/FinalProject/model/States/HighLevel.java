package com.FinalProject.model.States;

import com.FinalProject.model.Candidate.Candidate;

public class HighLevel extends BaseState{//probably state after humanResourceManager Approval
    private static HighLevel instance = new HighLevel();

    private HighLevel() {
        super("HighLevel");
    }

    public static HighLevel instance() {
        return instance;
    }

    @Override
    public void changeState(Candidate candidate) {
        if(candidate.getApplicationState().getName().equals("HighLevel")){
            System.out.println("Switched application status from MidLevel to HighLevel");
            candidate.setApplicationState(Certain.instance());
        }else{
            System.out.println("Status remained MidLevel");
        }
    }
}
