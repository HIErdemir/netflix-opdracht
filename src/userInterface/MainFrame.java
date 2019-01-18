package Userinterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame implements Runnable{

    private Footer footer;
    private OverviewAccount account;
    private OverviewProfile profile;
    private OverviewMovie movie;
    private OverviewSerie serie;
    private HomeScreen home;
    private JFrame frame;


    /** Maakt de Frame**/
    public void run() {
        this.frame = new JFrame("Netflix Statistic");
        frame.setPreferredSize(new Dimension(1000, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    /** Maakt de CreateComponents*/
    private void createComponents(Container container) {
        JTabbedPane tabbedPane = new JTabbedPane();
        this.home = new HomeScreen();
        this.account = new OverviewAccount();
        this.profile = new OverviewProfile();
        this.movie = new OverviewMovie();
        this.serie = new OverviewSerie();


        JComponent panel1 = home.jpanel();
        JComponent panel2 = account.jpanel();
        JComponent panel3 = profile.jpanel();
        JComponent panel4 = movie.jpanel();
        JComponent panel5 = serie.jpanel();



        tabbedPane.addTab("Home", null, panel1, "Go to home");
        tabbedPane.addTab("Account", null, panel2,"Go to page account");
        tabbedPane.addTab("Profile", null, panel3,"Go to page profile");
        tabbedPane.addTab("Movie", null, panel4,"Go to page movie");
        tabbedPane.addTab("Serie", null, panel5,"Go to page serie");




        container.setLayout(new BorderLayout());


        footer = new Footer();

        container.add(footer, BorderLayout.SOUTH);
        container.add(tabbedPane, BorderLayout.WEST);


    }




}
