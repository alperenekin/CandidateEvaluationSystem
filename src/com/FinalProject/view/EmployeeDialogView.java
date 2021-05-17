package com.FinalProject.view;

import com.FinalProject.model.Employees.HumanResourceAssistant;

import javax.swing.*;

public class EmployeeDialogView {
    private DialogButton dialogButton;
    private HumanResourceAssistant assistant;

    private JFrame frame;

    public EmployeeDialogView(HumanResourceAssistant assistant, JFrame frame) {
        this.assistant = assistant;
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
