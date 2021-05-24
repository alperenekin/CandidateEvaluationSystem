package com.FinalProject.view.CandidateView;

import com.FinalProject.model.JobAdvert.JobAdvert;
import com.FinalProject.model.JobAdvert.Position;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.view.AppTheme;
import com.FinalProject.view.TeamView.JobAdvertView;

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
    private JobAdvertView panel;
    JPanel center;
    
    public CandidateView(Candidate candidate,String[] positions) {
    	this.candidateTypes = positions;
    	createPanels();
        frame.setVisible(true);
        
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void createPanels(){
        frame = new JFrame("Candidate Screen"); //should change later
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane  = frame.getContentPane();
        frame.setSize(550,500);
        
        SignUpButton = new JButton("Apply and SignUp");
        
        userNameTextField = new JTextField(20); 
        userSurnameTextField = new JTextField(20); 
        cvTextField = new JTextField(20);
        
        usernameLabel = new JLabel("Your Name: ");
        surnameLabel = new JLabel("Your Surname: ");
        cvLabel = new JLabel("Cv: ");
        interestLabel = new JLabel("You are interesting in : ");
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
        
        center = new JPanel(new GridBagLayout());
        center.setBackground(AppTheme.instance().secondaryBackground());
        GridBagConstraints grid = new GridBagConstraints();
        
        grid.gridx = 0;
        grid.gridy = 0;
        center.add(interestLabel,grid);

        grid.gridx = 1;
        grid.gridy = 0;
        center.add(candidateComboBox,grid);
        
        grid.gridx = 0;
        grid.gridy = 1;
        center.add(jobDescriptionLabel,grid);

        grid.gridx = 1;
        grid.gridy = 1;
        center.add(subAdvertComboBox,grid);
        
        grid.gridx = 0;
        grid.gridy = 2;
        center.add(usernameLabel,grid);
        
        grid.gridx = 1;
        grid.gridy = 2;
        center.add(userNameTextField,grid);
        
        grid.gridx = 0;
        grid.gridy = 3;
        center.add(surnameLabel,grid);
        
        grid.gridx = 1;
        grid.gridy = 3;
        center.add(userSurnameTextField,grid);
        
        grid.gridx = 0;
        grid.gridy = 4;
        center.add(cvLabel,grid);
        
        grid.gridx = 1;
        grid.gridy = 4;
        center.add(cvTextField,grid);
        
        grid.gridx = 1;
        grid.gridy = 5;
        center.add(SignUpButton,grid);
        
        /*
        
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
        */
        contentPane.add(buttonPanel,BorderLayout.WEST);
        contentPane.add(rightPanel,BorderLayout.EAST);
        contentPane.add(topPanel, BorderLayout.NORTH);
        //contentPane.add(tablesPanel, BorderLayout.CENTER);
        contentPane.add(center, BorderLayout.CENTER);
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
		return (String) subAdvertComboBox.getSelectedItem();
	}
	public JobAdvertView addJobAdvertPanel(JobAdvert job) {
		panel = new JobAdvertView(job,true);
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 1;
        grid.gridy = 6;
		center.add(panel,grid);
		return panel;
	}
	public void removeJobAdvertPanel(JobAdvertView oldJob) {
		if(oldJob!= null) {
			center.remove(oldJob);
			center.revalidate();
			center.repaint();
		}
		
		
	}
	public void showCredentials(String userName, String passwd) {
		// TODO Auto-generated method stub
		JDialog d;
		d = new JDialog();
		JLabel success = new JLabel("Your Application is succesfull");
		JLabel name =new JLabel("Username : "+ userName);
		JLabel passwdd =new JLabel("Password : "+ passwd);

		
		success.setBounds(0, 0, 200, 20);
        d.add(success);

        name.setBounds(0, 50,200, 20);
        d.add(name);
        
        passwdd.setBounds(0, 100,200, 20);
        d.add(passwdd);		
		
		
		d.setSize(300,300); 
		d.setVisible(true);  
	}
}
