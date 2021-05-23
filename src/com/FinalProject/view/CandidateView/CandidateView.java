package com.FinalProject.view.CandidateView;

import com.FinalProject.model.JobAdvert;
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
	private JComboBox candidateComboBox,subAdvertComboBox;
    private JButton SignUpButton;
    private JTextField userNameTextField,userSurnameTextField,cvTextField;
    private JLabel usernameLabel,surnameLabel,cvLabel,interestLabel,jobDescriptionLabel;
    private String[] candidateTypes;
    
    public CandidateView(Candidate candidate,String[] candidateTypes) {
    	this.candidateTypes = candidateTypes;
    	createPanels();
        frame.setVisible(true);
        
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void createPanels(){
        frame = new JFrame("Candidate Screen"); //should change later
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane  = frame.getContentPane();
        
        SignUpButton = new JButton("Apply and SignUp");
        
        userNameTextField = new JTextField(20); 
        userSurnameTextField = new JTextField(20); 
        cvTextField = new JTextField(20);
        
        usernameLabel = new JLabel("Your Name: ");
        surnameLabel = new JLabel("Your Surname: ");
        cvLabel = new JLabel("Cv: ");
        interestLabel = new JLabel("Your interesting in : ");
        jobDescriptionLabel = new JLabel("Avaliable job adverts : ");
        
        candidateComboBox = new JComboBox(candidateTypes);
        subAdvertComboBox = new JComboBox();

        
        
         
        buttonPanel = new JPanel();
        buttonPanel.setBackground(AppTheme.instance().mainBackGroundColor());

        rightPanel = new JPanel();
        rightPanel.setBackground(AppTheme.instance().mainBackGroundColor()); //make this for team elements

        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(AppTheme.instance().backupBackground());

        tablesPanel = new JPanel();
        tablesPanel.setBackground(AppTheme.instance().secondaryBackground());
        
        tablesPanel.add(interestLabel);
        tablesPanel.add(candidateComboBox);
        
        tablesPanel.add(jobDescriptionLabel);
        tablesPanel.add(subAdvertComboBox);
        
                
        //topPanel.add(usernameLabel);
        tablesPanel.add(usernameLabel);
        tablesPanel.add(userNameTextField);
        tablesPanel.add(surnameLabel);
        tablesPanel.add(userSurnameTextField);
        tablesPanel.add(cvLabel);
        tablesPanel.add(cvTextField);
        
        tablesPanel.add(SignUpButton);
        
        contentPane.add(buttonPanel,BorderLayout.WEST);
        contentPane.add(rightPanel,BorderLayout.EAST);
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(tablesPanel, BorderLayout.CENTER);
        
    }
    public String getCandidateTypeComboBoxInput() {
		return (String) this.candidateComboBox.getSelectedItem();
    	
    }
    public void addLoginListener(ActionListener den) {
    	SignUpButton.addActionListener(den);
	}
    public void addComboBoxListener(ActionListener listener) {
    	candidateComboBox.addActionListener(listener);
    }
	public String getUserName() {
		
		return userNameTextField.getText();
	}
	public String getUserSurname() {
		return userSurnameTextField.getText();
		
	}
	public String getUserCv() {
		return cvTextField.getText();
	}
	public void updateJobComboBox(String[] positions) {
		subAdvertComboBox.removeAllItems();
		for(String position: positions) {
			subAdvertComboBox.addItem(position);
		}
		subAdvertComboBox.setVisible(true);
		
		
	}
	public void addSubComboBoxListener(ActionListener listener) {
		subAdvertComboBox.addActionListener(listener);
	}
	public String getJobTitleComboBoxInput() {
		// TODO Auto-generated method stub
		return (String) subAdvertComboBox.getSelectedItem();
	}
}
