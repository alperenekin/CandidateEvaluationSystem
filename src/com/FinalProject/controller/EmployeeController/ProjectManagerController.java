package com.FinalProject.controller.EmployeeController;

import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Employees.Employee;
import com.FinalProject.model.Employees.ProjectManager;
import com.FinalProject.model.States.Certain;
import com.FinalProject.view.TeamView.EmployeeDialogView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectManagerController extends EmployeeController{
    private ProjectManager manager;
    private String evaluation1;
    private String evaluation2;
    private String evaluation3; //TODO change with real criteria

    public ProjectManagerController(Candidate candidate, Employee manager, EmployeeDialogView view){
        super(candidate,view);
        this.manager = (ProjectManager) manager;
        super.getDialogView().createDialogButton(candidate);
    }

    @Override
    public void reviewACandidate(){
        super.getDialogView().getDialogButton().addListenerToButton(new ConfirmButtonListener(super.getDialogView(), super.getCandidate()));
        super.getDialogView().changeVisibilityOfDialog(true); //change the visibility here in order to make it block execution but take the listener.
    }

    class ConfirmButtonListener implements ActionListener {
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
            }else{
                candidate.setCompatibleness(Integer.parseInt(evaluation1)); // Assign taken input to candidate
                candidate.setSoftSkills(Integer.parseInt(evaluation2));
                candidate.setTechnicalSkills(Integer.parseInt(evaluation3));
                manager.reviewCandidate(candidate); //Review candidate and see if he passes it
                view.getDialogButton().setVisible(false);
                view.getDialogButton().dispose();
                if(candidate.getApplicationState() == Certain.instance()){//If succesfull the state will change, the candidate will be deleted from pending and added to approved
                    System.out.println("Last Review is successful");
                }
            }
        }
    }

}
