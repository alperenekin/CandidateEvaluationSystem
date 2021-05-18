package com.FinalProject.view;

import com.FinalProject.model.Candidate;
import com.FinalProject.model.Employees.Team;

import javax.swing.*;
import java.awt.*;

public class CandidateView {
    private JFrame frame;
    private JTable table;
    //Main panels to layout screen
    private JPanel buttonPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JPanel tablesPanel;
    private Container contentPane;
    public CandidateView(Candidate candidate) {
        createPanels();
        frame.setVisible(true);
    }
    private void createPanels(){
        frame = new JFrame("Candidate Screen"); //should change later
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane  = frame.getContentPane();

        buttonPanel = new JPanel();
        buttonPanel.setBackground(AppTheme.instance().mainBackGroundColor());

        rightPanel = new JPanel();
        rightPanel.setBackground(AppTheme.instance().mainBackGroundColor()); //make this for team elements

        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(AppTheme.instance().backupBackground());

        tablesPanel = new JPanel();
        tablesPanel.setBackground(AppTheme.instance().secondaryBackground());
        contentPane.add(buttonPanel,BorderLayout.WEST);
        contentPane.add(rightPanel,BorderLayout.EAST);
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(tablesPanel, BorderLayout.CENTER);
    }
}
