package Userinterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen implements ActionListener {

    private JFrame homeframe;
    private SwitchPanel sw;

    public HomeScreen() {

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        sw = new SwitchPanel();

    }

    public JFrame home() {
        homeframe = new JFrame();

        JButton b = new JButton("Test");

        homeframe.add(b);

        return homeframe;
    }
}
