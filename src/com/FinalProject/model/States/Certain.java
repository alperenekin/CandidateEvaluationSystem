package com.FinalProject.model.States;

import com.FinalProject.model.Candidate;

public class Certain extends BaseState{ //moves to this state at the end of process(Approval of project manager ?)
    private static Certain instance = new Certain();

    private Certain() {
        super("Certain");
    }

    public static Certain instance() {
        return instance;
    }

    @Override
    public void changeState(Candidate candidate) {
        if(candidate.getApplicationState().getName().equals("Certain")){
            System.out.println("The current state is already certain");
        }
    }
}
