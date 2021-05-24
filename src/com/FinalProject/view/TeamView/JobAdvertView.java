package com.FinalProject.view.TeamView;

import com.FinalProject.model.JobAdvert.JobAdvert;
import com.FinalProject.view.AppTheme;

import javax.swing.*;
import java.awt.*;

public class JobAdvertView extends JPanel {
    private JobAdvert jobAdvert;
    private boolean canApply;
    public JobAdvertView(JobAdvert jobAdvert, boolean canApply) { //panelin kenarlarýný görülür yap
        this.jobAdvert = jobAdvert;
        this.canApply = canApply;
        createAdvertCard();

    }

    private void createAdvertCard(){
        this.setBackground(AppTheme.instance().mainBackGroundColor());
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300,240));
        JLabel title = new JLabel(jobAdvert.getTitle());
        title.setFont(AppTheme.instance().headerText());
        title.setForeground(Color.ORANGE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);
        Box box = Box.createVerticalBox();

        JPanel firstPanel = new JPanel();
        firstPanel.setBackground(AppTheme.instance().mainBackGroundColor());
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));

        JLabel description = new JLabel("Description : ");
        description.setFont(AppTheme.instance().headerTextSmall());
        description.setForeground(Color.white);

        firstPanel.add(description);

        JTextArea descText = new JTextArea(jobAdvert.getDescription());
        descText.setEditable(false);
        descText.setLineWrap(true);
        descText.setWrapStyleWord(true);
        descText.setBackground(AppTheme.instance().mainBackGroundColor());
        descText.setFont(AppTheme.instance().bodyTextFont());
        descText.setForeground(Color.white);
        firstPanel.add(descText);
        box.add(firstPanel);

        JPanel secondPanel = new JPanel();
        secondPanel.setBackground(AppTheme.instance().mainBackGroundColor());
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.X_AXIS));

        JLabel requirements = new JLabel("Requirements : ");
        requirements.setForeground(Color.white);

        requirements.setFont(AppTheme.instance().headerTextSmall());
        secondPanel.add(requirements);

        JTextArea reqText = new JTextArea(jobAdvert.getRequirements());
        reqText.setForeground(Color.white);
        reqText.setFont(AppTheme.instance().bodyTextFont());
        reqText.setEditable(false);
        reqText.setLineWrap(true);
        reqText.setWrapStyleWord(true);
        reqText.setBackground(AppTheme.instance().mainBackGroundColor());
        reqText.setAlignmentY(CENTER_ALIGNMENT);
        secondPanel.add(reqText);
        box.add(secondPanel);

        if(canApply){
            JButton button = new JButton("Apply For Job");
            button.setBackground(AppTheme.instance().buttonColor());
            button.setForeground(Color.white);
            box.add(button);
        }


        this.add(box,BorderLayout.CENTER);
    }
}
