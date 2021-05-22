package com.FinalProject.view.TeamView;

import com.FinalProject.model.Employees.Employee;
import com.FinalProject.view.TeamView.DialogButton;

import javax.swing.*;

public class EmployeeDialogView {
    private DialogButton dialogButton;
    private Employee employee;

    private JFrame frame;

    public EmployeeDialogView(Employee employee, JFrame frame) {
        this.employee = employee;
        this.frame = frame;

    }

    public void createDialogButton(){
        dialogButton = new DialogButton("Enter numbers", "Evaluate",frame);
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
