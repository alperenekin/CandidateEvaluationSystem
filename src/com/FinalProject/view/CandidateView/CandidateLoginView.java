package com.FinalProject.view.CandidateView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.view.AppTheme;

public class CandidateLoginView {
	private Candidate currentCandidate;
	private JFrame frame;
	private Container contentPane;
    private JPanel buttonPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JPanel center;
	
	
	public CandidateLoginView(Candidate loggedCandidate) {
		this.currentCandidate = loggedCandidate;
		createPanels();
        frame.setVisible(true);
	}
	public CandidateLoginView() {
		createPanels();
        frame.setVisible(true);
	}
	private void createPanels() {
		frame = new JFrame("Candidate Screen"); //should change later
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane  = frame.getContentPane();
        frame.setSize(550,500);
        
        buttonPanel = new JPanel();
        buttonPanel.setBackground(AppTheme.instance().mainBackGroundColor());

        rightPanel = new JPanel();
        rightPanel.setBackground(AppTheme.instance().mainBackGroundColor()); //make this for team elements

        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(AppTheme.instance().backupBackground());

        center = new JPanel();
        center.setBackground(AppTheme.instance().secondaryBackground());
        
        
        contentPane.add(buttonPanel,BorderLayout.WEST);
        contentPane.add(rightPanel,BorderLayout.EAST);
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(center, BorderLayout.CENTER);
        
	}

}
