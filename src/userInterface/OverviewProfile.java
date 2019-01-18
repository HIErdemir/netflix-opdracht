package Userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OverviewProfile extends JPanel {

    public OverviewProfile(){}

    public JPanel jpanel() {
        this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout());

        this.add(buttons(), BorderLayout.SOUTH);


        return this;
    }

    public Box buttons() {
        Box buttonBar = Box.createVerticalBox();

        JButton getAll = new JButton("Get all profile's");
        JButton getProfile = new JButton("Get profile");
        JButton inputProfile = new JButton("Input new profile");
        JButton updateProfile = new JButton("Update profile");
        JButton deleteProfile = new JButton("Delete profile");
        getAll.setMaximumSize(new Dimension(150, 100));
        getAll.setMinimumSize(new Dimension(150, 100));
        getProfile.setMaximumSize(new Dimension(150, 100));
        getProfile.setMinimumSize(new Dimension(150, 100));
        inputProfile.setMaximumSize(new Dimension(150, 100));
        inputProfile.setMinimumSize(new Dimension(150, 100));
        updateProfile.setMaximumSize(new Dimension(150, 100));
        updateProfile.setMinimumSize(new Dimension(150, 100));
        deleteProfile.setMaximumSize(new Dimension(150, 100));
        deleteProfile.setMinimumSize(new Dimension(150, 100));

        buttonBar.add(getAll);
        buttonBar.add(getProfile);
        buttonBar.add(inputProfile);
        buttonBar.add(updateProfile);
        buttonBar.add(deleteProfile);

        return buttonBar;

    }

}
