package com.FinalProject.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DialogButton extends JDialog {
    private String dialogMessage;
    private JButton confirmButton;
    private JTextField skill1;
    private JTextField skill2;
    private JTextField skill3;


    public DialogButton(String dialogMessage,String boxName, JFrame frame){
        super(frame,boxName,true);
        this.dialogMessage = dialogMessage;
        fillDialogButton();
    }

    public void fillDialogButton(){
        JLabel message = new JLabel(dialogMessage);
        JPanel panel = new JPanel();
        JPanel center = new JPanel(new FlowLayout());
        skill1 = new JTextField(2);
        skill2 = new JTextField(2);
        skill3 = new JTextField(2);
        confirmButton = new JButton("Confirm");

        panel.add(message, BorderLayout.NORTH);
        center.add(skill1);
        center.add(skill2);
        center.add(skill3);
        panel.add(center,BorderLayout.CENTER);
        panel.add(confirmButton,BorderLayout.SOUTH);

        this.setSize(200,200);
        this.add(panel);
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public void addListenerToButton(ActionListener listener){
        confirmButton.addActionListener(listener);
    }

    public String getSkill1() {
        return skill1.getText();
    }

    public String getSkill2() {
        return skill2.getText();
    }

    public String getSkill3() {
        return skill3.getText();
    }
}
