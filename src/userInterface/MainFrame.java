package Userinterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame implements Runnable{

    private SwitchPanel switchPanel;
    private SideMenu sideMenu;
    private Footer footer;
    private JFrame frame;



    public void run() {
        this.frame = new JFrame("Netflix Statistic");
        frame.setPreferredSize(new Dimension(1000, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container container) {
        HomeScreen hm = new HomeScreen();
        container.setLayout(new BorderLayout());

        switchPanel = new SwitchPanel();
        sideMenu = new SideMenu();
        footer = new Footer();

        container.add(sideMenu, BorderLayout.WEST);
        container.add(footer, BorderLayout.SOUTH);
        container.add(hm);




    }


}
