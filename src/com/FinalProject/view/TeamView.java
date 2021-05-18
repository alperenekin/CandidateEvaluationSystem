package com.FinalProject.view;

import com.FinalProject.model.Candidate;
import com.FinalProject.model.Employees.HumanResourceAssistant;
import com.FinalProject.model.Employees.IEmployee;
import com.FinalProject.model.Employees.Team;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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
    private JButton rateCandidateButton;

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
        createPendingCandidateTable();
        createApprovedCandidateTable();
        showTeamMembers();
    }

    private void createPanels(){
        frame = new JFrame("Candidate Evaluation");
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
        for(IEmployee employee : team.getEmployees()){
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

        JButton searchButton = new JButton("<html>Search Candidate <br> From List</html>"); //Make it show candidate details?
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
        JButton  postAd = new JButton("<html> Post new Job <br> Advertisement </html>");
        postAd.setBackground(AppTheme.instance().buttonColor()); //singleton
        postAd.setForeground(Color.white);
        postAd.setFont(AppTheme.instance().bodyTextFont());
        buttonPanel.add(postAd);


    }

    private void createPendingCandidateTable(){
        Vector<String> columns = new Vector<>();
        columns.add("Id");
        columns.add("Candidate Name");
        columns.add("Candidate Rate");

        pendingCandidates = new CandidateTable(columns);
        JScrollPane scrollPane1 = new JScrollPane(pendingCandidates);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(AppTheme.instance().secondaryBackground());
        JLabel tableText = new JLabel("PENDING CANDIDATES");
        tableText.setForeground(Color.DARK_GRAY);
        tableText.setFont(AppTheme.instance().headerText());
        leftPanel.add(tableText,BorderLayout.NORTH);
        leftPanel.add(scrollPane1,BorderLayout.SOUTH);
        tablesPanel.add(leftPanel);
    }

    private void createApprovedCandidateTable(){ //NEEDS REFACTOR Tables are almost same
        Vector<String> columns = new Vector<>();
        columns.add("Id");
        columns.add("Candidate Name");
        columns.add("Candidate Rate");

        approvedCandidates = new CandidateTable(columns);
        JScrollPane scrollPane1 = new JScrollPane(approvedCandidates);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(AppTheme.instance().secondaryBackground());
        JLabel tableText = new JLabel("APPROVED CANDIDATES");
        tableText.setForeground(Color.DARK_GRAY);
        tableText.setFont(AppTheme.instance().headerText());
        rightPanel.add(tableText,BorderLayout.NORTH);
        rightPanel.add(scrollPane1,BorderLayout.SOUTH);
        tablesPanel.add(rightPanel);
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

}
