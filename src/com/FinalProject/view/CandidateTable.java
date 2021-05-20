package com.FinalProject.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.FinalProject.model.Candidate.Candidate;

import java.awt.*;
import java.util.Vector;

public class CandidateTable extends JTable {
    private final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; // get size of the screen
    private Vector<String> columnNames;
    private DefaultTableModel tableModel;

    public CandidateTable(Vector<String> columnNames){
        this.columnNames = columnNames;
        createTable();
    }

    public void createTable(){
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        tableModel.setColumnIdentifiers(columnNames);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        //Candidate Table decoration
        this.setModel(tableModel);
        this.setDefaultRenderer(String.class, centerRenderer);
        this.setFont(AppTheme.instance().bodyTextFont());
        this.setForeground(Color.white);
        this.getTableHeader().setBackground(AppTheme.instance().tableBackgroundColor());
        this.getTableHeader().setFont(AppTheme.instance().bodyTextFont());
        this.setAutoCreateRowSorter(true);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.getColumnModel().getColumn(0).setMaxWidth(50);
        this.setBackground(AppTheme.instance().tableBackgroundColor());
        int width1 = (int) (screenWidth *(0.5));
        int height1 = 10 * this.getRowHeight();
        this.setPreferredScrollableViewportSize(new Dimension(width1, height1));
    }

    public void addRowToTable(Candidate candidate) {
        int count = tableModel.getRowCount();
        Vector<String> vector = new Vector<String>();
        vector.add(String.valueOf(count));
        vector.add(candidate.getName() + " " + candidate.getSurname());
        vector.add("" + candidate.getSoftSkills());
        if (tableModel != null) {
            tableModel.insertRow(count, vector);
            getAutoResizeMode();
        }
    }

    public boolean removeRowFromTable(int rowNo) {
        if (tableModel != null) {
            tableModel.removeRow(rowNo);
            getAutoResizeMode();
            return true;
        }
        return false;
    }
}
