package com.FinalProject.view.TeamView;

import com.FinalProject.view.AppTheme;

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
        message.setFont(AppTheme.instance().headerTextSmall());
        JPanel panel = new JPanel();
        panel.setBackground(AppTheme.instance().secondaryBackground());

        Box box = Box.createVerticalBox();
        JPanel evaluate1 = new JPanel();
        evaluate1.setLayout(new BoxLayout(evaluate1, BoxLayout.X_AXIS));
        JLabel rateText1 = new JLabel("Rate social skills : ");
        skill1 = new JTextField(2);
        box.add(rateText1); box.add(skill1);

        JPanel evaluate2 = new JPanel();
        evaluate2.setLayout(new BoxLayout(evaluate2, BoxLayout.X_AXIS));
        JLabel rateText2 = new JLabel("Rate social skills : ");
        skill2 = new JTextField(2);
        box.add(rateText2); box.add(skill2);

        JPanel evaluate3 = new JPanel();
        evaluate3.setLayout(new BoxLayout(evaluate3, BoxLayout.X_AXIS));
        JLabel rateText3 = new JLabel("Rate social skills : ");
        skill3 = new JTextField(2);
        box.add(rateText3); box.add(skill3);

        confirmButton = new JButton("Confirm");
        confirmButton.setBackground(AppTheme.instance().buttonColor());
        confirmButton.setForeground(Color.white);

        panel.add(message, BorderLayout.NORTH);
        panel.add(box,BorderLayout.CENTER);
        panel.add(confirmButton,BorderLayout.SOUTH);

        this.setSize(500,250);
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
