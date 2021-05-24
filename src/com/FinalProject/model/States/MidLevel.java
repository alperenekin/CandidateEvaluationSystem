package com.FinalProject.model.States;

import com.FinalProject.model.Candidate.Candidate;

public class MidLevel extends BaseState{//state after humanResourceAssistant Approval
    private static MidLevel instance = new MidLevel();

    private MidLevel() {
        super("MidLevel");
    }

    public static MidLevel instance() {
        return instance;
    }

    @Override
    public void changeState(Candidate candidate) {
        if(candidate.getApplicationState().getName().equals("MidLevel")){
            System.out.println("Switched application status from MidLevel to HighLevel");
            candidate.setApplicationState(HighLevel.instance());
        }else{
            System.out.println("Status remained MidLevel");
        }
    }
}
