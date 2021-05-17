package com.FinalProject.controller;

import com.FinalProject.model.Candidate;
import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.model.States.Certain;
import com.FinalProject.model.States.MidLevel;
import com.FinalProject.view.DialogButton;
import com.FinalProject.view.EmployeeDialogView;
import com.FinalProject.view.TeamView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeamController {
    private HumanResourceAssistant assistant;
    private TeamView view;
    private ArrayList<Candidate> pendingCandidates;
    private ArrayList<Candidate> approvedCandidates;
    private Candidate candidate;


    public TeamController(HumanResourceAssistant assistant, TeamView view){
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

    private String showInputDialog(){
        String result = (String) JOptionPane.showInputDialog(
                view.getFrame(),
                "Enter a candidate to evaluate",
                "Evaluate a candidate",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "1"
        );
        return  result;
    }

    class RateCandidateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int result =  Integer.parseInt(showInputDialog());
            candidate = pendingCandidates.remove(result);
            EmployeeDialogView view2 = new EmployeeDialogView(assistant,view.getFrame());
            HumanResourceAssistantController controller = new HumanResourceAssistantController(candidate,assistant,view2);
            if(candidate.getApplicationState() == Certain.instance()){ //if candidate can pass all, it will be added to approved.
                view.removeRowFromTable(view.getPendingCandidates(),result);
                approvedCandidates.add(candidate);
                view.addCandidateToTable(view.getApprovedCandidates(),candidate);
            }else{//If eliminated, candidate will be deleted from list
                view.removeRowFromTable(view.getPendingCandidates(),result);
                //Here maybe we can show something like eliminated in a pop up.
            }
        }
    }


}
