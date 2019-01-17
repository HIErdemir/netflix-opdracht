package Userinterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame implements Runnable{

    private AccountButtons sideMenu;
    private Footer footer;
    private OverviewAccount account;
    private OverviewMovie movie;
    private JFrame frame;
    private int panel;
    private JPanel jpanel;



    public void run() {
        this.frame = new JFrame("Netflix Statistic");
        frame.setPreferredSize(new Dimension(1000, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container container) {
        JTabbedPane tabbedPane = new JTabbedPane();
        HomeScreen hs = new HomeScreen();
        account = new OverviewAccount();

        JComponent panel1 = hs.jpanel();
        JComponent panel2 = account.jpanel();

        tabbedPane.addTab("Home", null, panel1, "Go to home");
        tabbedPane.addTab("Account", null, panel2,"Go to page account");



        container.setLayout(new BorderLayout());


        footer = new Footer();

        container.add(footer, BorderLayout.SOUTH);
        container.add(tabbedPane, BorderLayout.WEST);


    }




}
