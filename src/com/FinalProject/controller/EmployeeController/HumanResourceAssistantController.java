package com.FinalProject.controller.EmployeeController;

import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.model.States.MidLevel;
import com.FinalProject.view.TeamView.EmployeeDialogView;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumanResourceAssistantController extends EmployeeController{
    private HumanResourceAssistant assistant;
    private EmployeeController successor;
    private String evaluation1;
    private String evaluation2;
    private String evaluation3; //TODO change with real criteria

    public HumanResourceAssistantController(Candidate candidate, HumanResourceAssistant assistant, EmployeeDialogView view){
        super(candidate,view);
        this.assistant =  assistant;
        super.getDialogView().createDialogButton(candidate);
    }

    @Override
    public void reviewACandidate(){
        super.getDialogView().getDialogButton().addListenerToButton(new ConfirmButtonListener(super.getDialogView(), super.getCandidate()));
        super.getDialogView().changeVisibilityOfDialog(true); //change the visibility here in order to make it block execution but take the listener.
    }

    class ConfirmButtonListener implements ActionListener{
        private EmployeeDialogView view;
        private Candidate candidate;

        public ConfirmButtonListener(EmployeeDialogView view,Candidate candidate){
            this.view = view;
            this.candidate = candidate;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            evaluation1 =  view.getDialogButton().getSkill1();
            evaluation2 = view.getDialogButton().getSkill2();
            evaluation3 = view.getDialogButton().getSkill3();// Takes the evaluation input from user
            if(evaluation1.isEmpty() || evaluation2.isEmpty() || evaluation3.isEmpty()){
                JOptionPane.showMessageDialog(view.getFrame(),"Fields cant be empty","Alert",JOptionPane.WARNING_MESSAGE);
            }else{ // if inputs are valid for the candidate
                candidate.setCompatibleness((Integer.parseInt(evaluation1) + candidate.getCompatibleness())/2); // Assign taken input to candidate
                candidate.setSoftSkills((Integer.parseInt(evaluation2)+ candidate.getSoftSkills())/2);
                candidate.setTechnicalSkills((Integer.parseInt(evaluation3)+ candidate.getTechnicalSkills())/2);
                assistant.reviewCandidate(candidate); //Review candidate and see if he passes it
                view.getDialogButton().setVisible(false);
                view.getDialogButton().dispose();
                if(candidate.getApplicationState() == MidLevel.instance()){//If successful the state will change, the candidate will be sent to successor for next evaluationd
                    System.out.println("First Review is successful");
                    EmployeeDialogView view3 = new EmployeeDialogView(assistant.getSuccessor(),view.getFrame());
                    successor = new HumanResourceManagerController(candidate,assistant.getSuccessor(),view3);
                    successor.reviewACandidate(); //shows dialog for input, takes input makes evaluation if it passes sends to next person to evaluate,
                }
            }
        }
    }

}
