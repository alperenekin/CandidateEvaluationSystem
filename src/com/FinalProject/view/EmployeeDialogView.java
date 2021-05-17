package com.FinalProject.view;

import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.model.Employees.IEmployee;

import javax.swing.*;

public class EmployeeDialogView {
    private DialogButton dialogButton;
    private IEmployee employee;

    private JFrame frame;

    public EmployeeDialogView(IEmployee employee, JFrame frame) {
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
