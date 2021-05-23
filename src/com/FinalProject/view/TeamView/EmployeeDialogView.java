package com.FinalProject.view.TeamView;

import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Employees.Employee;

import javax.swing.*;

public class EmployeeDialogView {
    private DialogButton dialogButton;
    private Employee employee;

    private JFrame frame;

    public EmployeeDialogView(Employee employee, JFrame frame) {
        this.employee = employee;
        this.frame = frame;

    }

    public void createDialogButton(Candidate candidate){
        dialogButton = new DialogButton(employee.getName() + " " + employee.getSurname() + " " + "please evaluate the candidate : " + candidate.getName() + " " + candidate.getSurname(), "Evaluate", frame);
    }

    public DialogButton getDialogButton(){
        return dialogButton;
    }

    public void changeVisibilityOfDialog(boolean visibility){
        dialogButton.setVisible(visibility);
    }

    public JFrame getFrame() {
        return frame;
    }


}
