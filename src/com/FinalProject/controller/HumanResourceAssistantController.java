package com.FinalProject.controller;

import com.FinalProject.model.Candidate;
import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.view.HumanResourceAssistantView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HumanResourceAssistantController {
    private HumanResourceAssistant assistant;
    private HumanResourceAssistantView view;
    private ArrayList<Candidate> pendingCandidates;
    private ArrayList<Candidate> approvedCandidates;


    public HumanResourceAssistantController(HumanResourceAssistant assistant, HumanResourceAssistantView view){
        this.assistant = assistant;
        this.view = view;
        pendingCandidates = new ArrayList<>();
        approvedCandidates = new ArrayList<>();
        Candidate candidate1 = new Candidate("alperen","ekin");
        Candidate candidate2 = new Candidate("ekin","tepebas");
        Candidate candidate3 = new Candidate("ahmet","yilmaz");
        pendingCandidates.add(candidate1); pendingCandidates.add(candidate2); pendingCandidates.add(candidate3);
        view.addCandidateListToTable(view.getPendingCandidates(),pendingCandidates);
        view.addListenerToButton(view.getRateCandidateButton(),new RateCandidateListener());

    }

    class RateCandidateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Candidate candidate = pendingCandidates.remove(0);
            approvedCandidates.add(candidate);
            view.removeRowFromTable(view.getPendingCandidates(),0);
            view.addCandidateToTable(view.getApprovedCandidates(),candidate);
        }
    }

}
