package com.FinalProject.controller.EmployeeController;

import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.view.TeamView.EmployeeDialogView;

public abstract class  EmployeeController {
    private EmployeeDialogView dialogView;
    private Candidate candidate;

    public EmployeeController(Candidate candidate , EmployeeDialogView view){
        this.candidate = candidate;
        this.dialogView = view;
        dialogView.createDialogButton(candidate);
    }

    public  abstract void reviewACandidate();

    public EmployeeDialogView getDialogView() {
        return dialogView;
    }

    public Candidate getCandidate() {
        return candidate;
    }

}
