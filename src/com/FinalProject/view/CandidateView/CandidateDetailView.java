package com.FinalProject.view.CandidateView;

import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.view.AppTheme;

import javax.swing.*;
import java.awt.*;

public class CandidateDetailView extends JDialog {

    public CandidateDetailView(Candidate candidate, JFrame frame){
        super(frame,"Candidate Detail");
        showCandidateDetails(candidate);
        this.setVisible(true);
    }

    private void showCandidateDetails(Candidate candidate){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(AppTheme.instance().secondaryBackground());
        JLabel nameSurname = new JLabel(candidate.getName() + " " + candidate.getSurname());
        nameSurname.setFont(AppTheme.instance().headerText());
        panel.add(nameSurname, BorderLayout.NORTH);
        JTextArea cvText = new JTextArea("\n Buraya kullanicinin cvsi gelecek. Bu okuldan mezun bu bölümden mezun oldum, þuralarda çalýþtým tecrübelerim bunlar þeklidne");
        cvText.setFont(AppTheme.instance().bodyTextFont());
        cvText.setEditable(false);
        cvText.setLineWrap(true);
        cvText.setWrapStyleWord(true);
        cvText.setBackground(AppTheme.instance().secondaryBackground());
        cvText.setAlignmentY(CENTER_ALIGNMENT);
        panel.add(cvText,BorderLayout.CENTER);
        this.setSize(350,200);
        this.add(panel);

    }
}
