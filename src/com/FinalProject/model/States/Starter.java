package com.FinalProject.model.States;

import com.FinalProject.model.Candidate.Candidate;

public class Starter extends BaseState{ //beginning state for a candidate
    private static Starter instance = new Starter();

    private Starter() {
        super("Starter");
    }

    public static Starter instance() {
        return instance;
    }

    @Override
    public void changeState(Candidate candidate) {
        System.out.println("Changed from starter to mid level");
        candidate.setApplicationState(MidLevel.instance());
    }
}
