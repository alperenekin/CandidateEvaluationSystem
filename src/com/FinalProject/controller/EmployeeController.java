package com.FinalProject.controller;

import com.FinalProject.model.Candidate;
import com.FinalProject.view.EmployeeDialogView;

public abstract class  EmployeeController {
    private EmployeeDialogView dialogView;
    private Candidate candidate;

    public EmployeeController(Candidate candidate , EmployeeDialogView view){
        this.candidate = candidate;
        this.dialogView = view;
        dialogView.createDialogButton();
    }

    public  abstract void reviewACandidate();

    public EmployeeDialogView getDialogView() {
        return dialogView;
    }

    public Candidate getCandidate() {
        return candidate;
    }

}
