package com.FinalProject.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddJobButton extends JDialog{
        private String dialogMessage;
        private JButton confirmButton;
        private JTextField title;
        private JTextField desc;
        private JTextField req;

        public AddJobButton(String dialogMessage,String boxName, JFrame frame){
            super(frame,boxName);
            this.dialogMessage = dialogMessage;
            addComponentsToButton();
            this.setVisible(true);
        }

        public void addComponentsToButton(){
            JLabel message = new JLabel(dialogMessage);
            message.setHorizontalAlignment(SwingConstants.CENTER);
            message.setFont(AppTheme.instance().headerTextSmall());

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(AppTheme.instance().secondaryBackground());

            JPanel center = new JPanel(new GridBagLayout());
            center.setBackground(AppTheme.instance().secondaryBackground());
            GridBagConstraints grid = new GridBagConstraints();

            JLabel jobTitle = new JLabel("Title : ");
            title = new JTextField(20);
            JLabel description = new JLabel("Description : ");
            desc = new JTextField(20);
            JLabel requirements = new JLabel("Requirements : ");

            req = new JTextField(20);
            confirmButton = new JButton("Confirm");
            confirmButton.setBackground(AppTheme.instance().buttonColor());
            confirmButton.setForeground(Color.white);

            panel.add(message, BorderLayout.NORTH);

            grid.gridx = 0;
            grid.gridy = 0;
            center.add(jobTitle,grid);

            grid.gridx = 1;
            grid.gridy = 0;
            center.add(title,grid);


            grid.gridx = 0;
            grid.gridy = 1;
            center.add(description,grid);

            grid.gridx = 1;
            grid.gridy = 1;
            center.add(desc,grid);

            grid.gridx = 0;
            grid.gridy = 2;
            center.add(requirements,grid);

            grid.gridx = 1;
            grid.gridy = 2;
            center.add(req,grid);
            panel.add(center,BorderLayout.CENTER);
            panel.add(confirmButton,BorderLayout.SOUTH);

            this.setSize(400,400);
            this.add(panel);
        }

        public JButton getConfirmButton() {
            return confirmButton;
        }

        public void addListenerToButton(ActionListener listener){
            confirmButton.addActionListener(listener);
        }

        public String getJobTitle() {
            return title.getText();
        }

        public String getDesc() {
            return desc.getText();
        }

        public String getReq() {
            return req.getText();
        }

}
