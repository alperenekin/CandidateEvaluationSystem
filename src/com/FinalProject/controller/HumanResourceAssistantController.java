package com.FinalProject.controller;

import com.FinalProject.model.Candidate;
import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.model.States.MidLevel;
import com.FinalProject.view.DialogButton;
import com.FinalProject.view.HumanResourceAssistantView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HumanResourceAssistantController {
    private HumanResourceAssistant assistant;
    private HumanResourceAssistantView view;
    private ArrayList<Candidate> pendingCandidates;
    private ArrayList<Candidate> approvedCandidates;
    private Candidate candidate;


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
        private String evaluation1 = "";
        private String evaluation2 = "";
        private String evaluation3 = "";
        DialogButton dialogButton;
        @Override
        public void actionPerformed(ActionEvent e) {

            String result = (String) JOptionPane.showInputDialog(
                    view.getFrame(),
                    "Enter a candidate to evaluate",
                    "Evaluate a candidate",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "1"
            );
            if(result != null && result.length() > 0){
                dialogButton= new DialogButton("Enter your evaluation.","Evaluate",view.getFrame());
                dialogButton.addListenerToButton(new ConfirmButtonListener(result));
            }

        }

        class ConfirmButtonListener implements ActionListener{
            private int result;

            public ConfirmButtonListener(String result){
                this.result = Integer.parseInt(result);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                evaluation1 =  dialogButton.getSkill1();
                evaluation2 =  dialogButton.getSkill2();
                evaluation3 =  dialogButton.getSkill3();// Takes the evaluation input from user

                candidate = pendingCandidates.remove(result);
                view.removeRowFromTable(view.getPendingCandidates(),result);

                candidate.setCompatibleness(Integer.parseInt(evaluation1)); // Assign taken input to candidate
                candidate.setSoftSkills(Integer.parseInt(evaluation2));
                candidate.setTechnicalSkills(Integer.parseInt(evaluation3));
                assistant.reviewCandidate(candidate); //Review candidate and see if he passes the it
                if(candidate.getApplicationState() == MidLevel.instance()){//If succesfull the stat will change, the candidate will be deleted from pending and added to approved
                    System.out.println("Review is successful");
                    approvedCandidates.add(candidate);
                    view.addCandidateToTable(view.getApprovedCandidates(),candidate);
                }

                dialogButton.setVisible(false);
                dialogButton.dispose();
            }
        }
    }

}
