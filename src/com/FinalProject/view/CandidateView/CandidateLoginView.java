package com.FinalProject.view.CandidateView;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.view.AppTheme;

public class CandidateLoginView {
	private JFrame frame;
	private Container contentPane;
    private JPanel buttonPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JPanel center;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;

	public CandidateLoginView() {
		createPanels();
        frame.setVisible(true);
        createLoginFields();
	}
	private void createPanels() {
		frame = new JFrame("Candidate Login"); //should change later
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane  = frame.getContentPane();
        frame.setSize(550,500);
        
        buttonPanel = new JPanel();
        buttonPanel.setBackground(AppTheme.instance().mainBackGroundColor());

        rightPanel = new JPanel();
        rightPanel.setBackground(AppTheme.instance().mainBackGroundColor()); //make this for team elements

        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(AppTheme.instance().backupBackground());

        center = new JPanel(new GridBagLayout());
        center.setBackground(AppTheme.instance().secondaryBackground());
        
        
        contentPane.add(buttonPanel,BorderLayout.WEST);
        contentPane.add(rightPanel,BorderLayout.EAST);
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(center, BorderLayout.CENTER);
	}

	private void createLoginFields(){
        GridBagConstraints grid = new GridBagConstraints();
        username = new JTextField(20);
        JLabel usernameLabel = new JLabel("Username");
        password = new JPasswordField(20);
        JLabel passwordLabel = new JLabel("Password");
        loginButton = new JButton("Login as Candidate");
        loginButton.setBackground(AppTheme.instance().buttonColor());
        loginButton.setForeground(Color.white);

        grid.gridx = 0;
        grid.gridy = 0;
        center.add(usernameLabel,grid);

        grid.gridx = 1;
        grid.gridy = 0;
        center.add(username,grid);


        grid.gridx = 0;
        grid.gridy = 1;
        center.add(passwordLabel,grid);

        grid.gridx = 1;
        grid.gridy = 1;
        center.add(password,grid);

        grid.gridx = 0;
        grid.gridy = 2;
        center.add(Box.createRigidArea(new Dimension(0, 20)),grid);

        grid.gridx = 1;
        grid.gridy = 3;
        center.add(loginButton,grid);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return String.valueOf(password.getPassword());
    }
    public JButton getLoginButton() {
        return loginButton;
    }

    public void addListenerToButton(JButton button, ActionListener listener){
        button.addActionListener(listener);
    }

    public JFrame getFrame(){
        return frame;
    }

}
