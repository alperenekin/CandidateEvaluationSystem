package com.FinalProject.view.LoginView;

import com.FinalProject.view.AppTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton loginButton;
    private JButton switchCandidateLoginButton;
    private JButton startWithoutLogin;


    public LoginView(){
        showLoginFields();
        this.setVisible(true);
    }

    private void showLoginFields(){
        JPanel center = new JPanel(new GridBagLayout());
        center.setBackground(AppTheme.instance().mainBackGroundColor());
        GridBagConstraints grid = new GridBagConstraints();
        username = new JTextField(20);
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.white);
        password = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.white);
        loginButton = new JButton("Login as Team");
        loginButton.setBackground(AppTheme.instance().buttonColor());
        loginButton.setForeground(Color.white);
        switchCandidateLoginButton = new JButton("Candidate Login");
        switchCandidateLoginButton.setBackground(AppTheme.instance().buttonColor());
        switchCandidateLoginButton.setForeground(Color.white);
        startWithoutLogin = new JButton("Candidate Without Login");
        startWithoutLogin.setBackground(AppTheme.instance().buttonColor());
        startWithoutLogin.setForeground(Color.white);

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

        grid.gridx = 0;
        grid.gridy = 3;
        center.add(loginButton,grid);

        grid.gridx = 1;
        grid.gridy = 3;
        center.add(switchCandidateLoginButton,grid);

        grid.gridx = 2;
        grid.gridy = 3;
        center.add(startWithoutLogin,grid);
        this.add(center,BorderLayout.CENTER);
        this.setSize(550,500);
    }


    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getSwitchCandidateLoginButton() {
        return switchCandidateLoginButton;
    }

    public JButton getStartWithoutLogin() {
        return startWithoutLogin;
    }

    public String getUsername(){
        return username.getText();
    }

    public String getPassword(){
        return password.getText();
    }

    public void disposeFrame(){
        this.dispose();
    }
    public void addListenerToButton(JButton button, ActionListener listener){
        button.addActionListener(listener);
    }

    public JFrame getFrame(){
        return this;
    }

}
