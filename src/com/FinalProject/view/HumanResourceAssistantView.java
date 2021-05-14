package com.FinalProject.view;

import com.FinalProject.model.Employees.HumanResourceAssistant;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class HumanResourceAssistantView {
    private JFrame frame;
    private JTable table;
    //Main panels to layout screen
    private JPanel buttonPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JPanel tablesPanel;
    Container contentPane;

    private HumanResourceAssistant assistant;
    final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; // get size of the screen




    public HumanResourceAssistantView(HumanResourceAssistant assistant) {
        this.assistant = assistant;
        createPanels();
        createButtonsAndTexts();
        frame.setVisible(true);
        createTable();
    }

    private void createPanels(){
        frame = new JFrame("Candidate Evaluation");
        contentPane  = frame.getContentPane();

        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(1, 0, 72));

        rightPanel = new JPanel();
        rightPanel.setBackground(Color.GREEN);

        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(new Color(51, 41, 72));

        tablesPanel = new JPanel();
        tablesPanel.setBackground(new Color(244, 222, 251));
    }

    private void createButtonsAndTexts(){
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.white);
        JLabel nameSurname = new JLabel(assistant.getName() + " " + assistant.getSurname());
        nameSurname.setForeground(Color.white);

        topPanel.add(usernameLabel);
        topPanel.add(Box.createHorizontalStrut(10));
        topPanel.add(nameSurname);

        JButton button1 = new JButton("<html>Search Candidate <br> From List</html>"); //change button name
        button1.setBackground(new Color(75, 0, 72)); //singleton
        button1.setForeground(Color.white);
        button1.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.PAGE_AXIS));
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(button1);
        buttonPanel.add(Box.createVerticalStrut(10));

        JButton rateCandidateButton = new JButton("<html>Rate A <br> Candidate</html>");
        rateCandidateButton.setBackground(new Color(75, 0, 72)); //singleton
        rateCandidateButton.setForeground(Color.white);
        rateCandidateButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        buttonPanel.add(rateCandidateButton);

        contentPane.add(buttonPanel,BorderLayout.WEST);
        contentPane.add(rightPanel,BorderLayout.EAST);
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(tablesPanel, BorderLayout.CENTER);
    }

    private void createTable(){
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id ");
        columnNames.add("Candidate Name");
        columnNames.add("Candidate Point");
        tableModel.setColumnIdentifiers(columnNames);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        //Candidate Table decoration
        JTable candidateTable = new JTable(tableModel);
        candidateTable.setDefaultRenderer(String.class, centerRenderer);
        candidateTable.setFont(new Font("Tahome", Font.BOLD,15));
        candidateTable.setForeground(Color.white);
        candidateTable.getTableHeader().setBackground(new Color(234, 179, 179));
        candidateTable.getTableHeader().setFont(new Font("Tahome", Font.BOLD,15));
        candidateTable.setAutoCreateRowSorter(true);
        candidateTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        candidateTable.getColumnModel().getColumn(0).setMaxWidth(50);
        candidateTable.setBackground(new Color(234, 179, 179));
        int width1 = (int) (screenWidth *(0.4));
        int height1 = 10 * candidateTable.getRowHeight();
        candidateTable.setPreferredScrollableViewportSize(new Dimension(width1, height1));
        JScrollPane scrollPane1 = new JScrollPane(candidateTable);

        JPanel lefTable = new JPanel(new BorderLayout());
        lefTable.setBackground(new Color(244, 222, 251));
        JLabel tableText = new JLabel("PENDING CANDIDATES");
        tableText.setForeground(Color.DARK_GRAY);
        tableText.setFont(new Font("Serif", Font.BOLD, 30));
        lefTable.add(tableText,BorderLayout.NORTH);
        lefTable.add(scrollPane1,BorderLayout.SOUTH);
        tablesPanel.add(lefTable);

        for (int i = 0; i< 10; i++) {
            Vector<String> vector = new Vector<String>();
            vector.add(String.valueOf(i));
            vector.add("Deneme" +i);
            vector.add("Candidate" + i);
            tableModel.insertRow(i, vector);
        }
    }


}
