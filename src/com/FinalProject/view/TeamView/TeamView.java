package com.FinalProject.view.TeamView;

import com.FinalProject.model.Candidate.Candidate;
import com.FinalProject.model.Employees.Employee;
import com.FinalProject.Utill.FileIO;
import com.FinalProject.model.Team;
import com.FinalProject.model.JobAdvert.JobAdvert;
import com.FinalProject.view.AppTheme;
import com.FinalProject.view.CandidateView.CandidateTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class TeamView {
    private JFrame frame;
    private JTable table;
    //Main panels to layout screen
    private JPanel buttonPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JPanel tablesPanel;

    private Container contentPane;
    private JButton searchButton;
    private JButton rateCandidateButton;
    private JButton  postAd;

    //Tables
    private CandidateTable pendingCandidates;
    private CandidateTable approvedCandidates;

    private Team team;
    final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; // get size of the screen

    public TeamView(Team team) {
        this.team = team;
        createPanels();
        createButtonsAndTexts();
        frame.setVisible(true);
        initTables();
        createCandidateTable(pendingCandidates,"PENDING CANDIDATES");
        createCandidateTable(approvedCandidates,"APPROVED CANDIDATES");
        showTeamMembers();
        showJobAdverts();
    }

    private void createPanels(){
        frame = new JFrame("Candidate Evaluation");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

    private void showTeamMembers(){
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.PAGE_AXIS));
        JLabel teamMemberHeader = new JLabel("Team Members");
        teamMemberHeader.setForeground(Color.ORANGE);
        teamMemberHeader.setFont(AppTheme.instance().headerText());
        teamMemberHeader.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        rightPanel.add(teamMemberHeader);
        for(Employee employee : team.getEmployees()){
            JLabel nameSurname = new JLabel(employee.getName() + " " + employee.getSurname());
            nameSurname.setForeground(Color.white);
            nameSurname.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            nameSurname.setFont(AppTheme.instance().headerTextSmall());
            rightPanel.add(nameSurname);
        }
    }

    private void createButtonsAndTexts(){
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.white);
        JLabel nameSurname = new JLabel(team.getTeamName() + " team");
        nameSurname.setForeground(Color.white);

        topPanel.add(usernameLabel);
        topPanel.add(Box.createHorizontalStrut(10));
        topPanel.add(nameSurname);

        searchButton = new JButton("<html>Search Candidate <br> From List</html>"); //Make it show candidate details?
        searchButton.setBackground(AppTheme.instance().buttonColor()); //singleton
        searchButton.setForeground(Color.white);
        searchButton.setFont(AppTheme.instance().bodyTextFont());
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.PAGE_AXIS));
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(searchButton);

        buttonPanel.add(Box.createVerticalStrut(10));
        rateCandidateButton = new JButton("<html>Rate A <br> Candidate</html>");
        rateCandidateButton.setBackground(AppTheme.instance().buttonColor()); //singleton
        rateCandidateButton.setForeground(Color.white);
        rateCandidateButton.setFont(AppTheme.instance().bodyTextFont());
        buttonPanel.add(rateCandidateButton);

        buttonPanel.add(Box.createVerticalStrut(10));
        postAd = new JButton("<html> Post new Job <br> Advertisement </html>");
        postAd.setBackground(AppTheme.instance().buttonColor()); //singleton
        postAd.setForeground(Color.white);
        postAd.setFont(AppTheme.instance().bodyTextFont());
        buttonPanel.add(postAd);

    }

    private void showJobAdverts(){
        for(JobAdvert ad : FileIO.instance().getAdverts()){
            if(ad.getTeam() == team){
                JobAdvertView view = new JobAdvertView(ad,false);
                tablesPanel.add(view);
            }
        }
    }

    private void createCandidateTable(CandidateTable table,String headerText){
        JScrollPane scrollPane1 = new JScrollPane(table);
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(AppTheme.instance().secondaryBackground());
        JLabel tableText = new JLabel(headerText);
        tableText.setForeground(Color.DARK_GRAY);
        tableText.setFont(AppTheme.instance().headerText());
        leftPanel.add(tableText,BorderLayout.NORTH);
        leftPanel.add(scrollPane1,BorderLayout.SOUTH);
        tablesPanel.add(leftPanel);
    }

    private void initTables(){
        Vector<String> columns = new Vector<>();
        columns.add("Id");
        columns.add("Candidate Name");
        columns.add("Candidate Rate");

        pendingCandidates = new CandidateTable(columns);
        approvedCandidates = new CandidateTable(columns);
    }

    public void addCandidateListToTable(CandidateTable table,ArrayList<Candidate> candidates){
        for(Candidate candidate : candidates){
            table.addRowToTable(candidate);
        }
    }

    public void addCandidateToTable(CandidateTable table, Candidate candidate){
            table.addRowToTable(candidate);
    }

    public boolean removeRowFromTable(CandidateTable table,int row){
        return table.removeRowFromTable(row);
    }

    public JButton getRateCandidateButton() {
        return rateCandidateButton;
    }

    public void addListenerToButton(JButton button, ActionListener listener){
        button.addActionListener(listener);
    }


    public CandidateTable getPendingCandidates() {
        return pendingCandidates;
    }

    public CandidateTable getApprovedCandidates() {
        return approvedCandidates;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getPostAd() {
        return postAd;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JPanel getTablesPanel() {
        return tablesPanel;
    }
}
