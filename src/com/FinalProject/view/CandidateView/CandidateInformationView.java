package com.FinalProject.view.CandidateView;

import com.FinalProject.FileIO;
import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Employees.Employee;
import com.FinalProject.model.JobAdvert.JobAdvert;
import com.FinalProject.model.States.BaseState;
import com.FinalProject.model.States.Certain;
import com.FinalProject.model.States.Starter;
import com.FinalProject.view.AppTheme;
import com.FinalProject.view.TeamView.JobAdvertView;

import javax.swing.*;
import java.awt.*;

public class CandidateInformationView {
    private Candidate currentCandidate;
    private JFrame frame;
    private Container contentPane;
    private JPanel buttonPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JPanel center;


    public CandidateInformationView(Candidate loggedCandidate) {
        this.currentCandidate = loggedCandidate;
        createPanels();
        showJobAdverts();
        showCandidateInfo();
        showApplicationDetails();
        frame.setVisible(true);
    }

    private void createPanels() {
        frame = new JFrame("Candidate Screen"); //should change later
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane = frame.getContentPane();
        frame.setSize(550, 500);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(AppTheme.instance().mainBackGroundColor());

        rightPanel = new JPanel();
        rightPanel.setBackground(AppTheme.instance().mainBackGroundColor());

        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(AppTheme.instance().backupBackground());

        center = new JPanel(new GridBagLayout());
        center.setBackground(AppTheme.instance().secondaryBackground());


        contentPane.add(buttonPanel, BorderLayout.WEST);
        contentPane.add(rightPanel, BorderLayout.EAST);
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(center, BorderLayout.CENTER);
    }

    private void showJobAdverts(){
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.PAGE_AXIS));
        JLabel teamMemberHeader = new JLabel("Available jobs");
        teamMemberHeader.setForeground(Color.ORANGE);
        teamMemberHeader.setFont(AppTheme.instance().headerText());
        teamMemberHeader.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        rightPanel.add(teamMemberHeader);
        for(JobAdvert job : FileIO.instance().getAdverts()){
            JLabel jobtitle = new JLabel(job.getTitle());
            jobtitle.setForeground(Color.white);
            jobtitle.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            jobtitle.setFont(AppTheme.instance().headerTextSmall());
            rightPanel.add(jobtitle);
        }
    }

    private void showCandidateInfo(){
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.white);
        JLabel nameSurname = new JLabel(currentCandidate.getName() + " " + currentCandidate.getSurname());
        nameSurname.setForeground(Color.white);

        topPanel.add(usernameLabel);
        topPanel.add(Box.createHorizontalStrut(10));
        topPanel.add(nameSurname);
    }

    private void showApplicationDetails(){
        JobAdvert job = null;
        for(JobAdvert advert : FileIO.instance().getAdverts()){
            for (Candidate candidate : advert.getAppliedCandidates()){
                if (candidate.getCandidateId() == currentCandidate.getCandidateId()){
                    job = advert;
                }
            }
        }
        GridBagConstraints grid = new GridBagConstraints();
        if(job != null){
            JLabel label = new JLabel("Your Application");
            label.setFont(AppTheme.instance().headerText());

            grid.gridx = 0;
            grid.gridy = 0;
            center.add(label,grid);

            grid.gridx = 0;
            grid.gridy = 1;
            center.add(Box.createRigidArea(new Dimension(0, 10)),grid);

            JobAdvertView advertView = new JobAdvertView(job,false);
            grid.gridx = 0;
            grid.gridy = 2;
            center.add(advertView,grid);

            grid.gridx = 0;
            grid.gridy = 3;
            center.add(Box.createRigidArea(new Dimension(0, 10)),grid);

            JLabel applicationStatus = new JLabel("Application Status: " + applicationStateToString(currentCandidate.getApplicationState()));
            applicationStatus.setFont(AppTheme.instance().headerTextSmall());
            grid.gridx = 0;
            grid.gridy = 4;
            center.add(applicationStatus,grid);

            int avg = currentCandidate.getCompatibleness()+currentCandidate.getSoftSkills()+ currentCandidate.getTechnicalSkills();
            avg = avg/3;
            JLabel grade = new JLabel("Point : " + avg);
            grade.setFont(AppTheme.instance().headerTextSmall());
            grid.gridx = 0;
            grid.gridy = 5;
            center.add(grade,grid);
        }



    }

    private String applicationStateToString(BaseState state){
        if(state == Certain.instance()){
            return "Accepted!";
        }else if(state == Starter.instance()){
            return "Starter";
        }else{
            return "Rejected";
        }
    }
}