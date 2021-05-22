package com.FinalProject.view.CandidateView;

import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.view.AppTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CandidateView {
    private JFrame frame;
    private JTable table;
    //Main panels to layout screen
    private JPanel buttonPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JPanel tablesPanel;
    private Container contentPane;
    @SuppressWarnings("rawtypes")
	private JComboBox candidateComboBox;
    private JButton SignUpButton;
    public CandidateView(Candidate candidate) {
        createPanels();
        frame.setVisible(true);
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void createPanels(){
        frame = new JFrame("Candidate Screen"); //should change later
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane  = frame.getContentPane();
        
        SignUpButton = new JButton("Apply and SignUp");
        
        String candidateTypes[] = {"Mobile","BackEnd","QnA"};
        
        candidateComboBox = new JComboBox(candidateTypes);

        
        
        
        buttonPanel = new JPanel();
        buttonPanel.setBackground(AppTheme.instance().mainBackGroundColor());

        rightPanel = new JPanel();
        rightPanel.setBackground(AppTheme.instance().mainBackGroundColor()); //make this for team elements

        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(AppTheme.instance().backupBackground());

        tablesPanel = new JPanel();
        tablesPanel.setBackground(AppTheme.instance().secondaryBackground());
        
        tablesPanel.add(candidateComboBox);
        tablesPanel.add(SignUpButton);
        
        contentPane.add(buttonPanel,BorderLayout.WEST);
        contentPane.add(rightPanel,BorderLayout.EAST);
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(tablesPanel, BorderLayout.CENTER);
    }
    public String getComboBoxInput() {
		return (String) this.candidateComboBox.getSelectedItem();
    	
    }
    public void addLoginListener(ActionListener den) {
    	SignUpButton.addActionListener(den);
	}
}
