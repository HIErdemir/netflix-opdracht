package Userinterface;

import Database.Repository.AccountRep;
import Logic.Account;
import Userinterface.AccountButtons;
import Userinterface.MainFrame;

import javax.swing.*;
import java.awt.*;

public class OverviewAccount extends JPanel {

    private MainFrame mf;
    private AccountRep ar;
    private AccountButtons ab;

    public OverviewAccount() {
        mf = new MainFrame();
        ar = new AccountRep();
        ab = new AccountButtons();
    }


    public JPanel jpanel() {
        this.setBackground(new Color(255, 0, 0));
        this.setLayout(new GridLayout());


        this.add(ab, BorderLayout.SOUTH);

        return this;
    }



    public void getAll() {
        String n = "";
        try {
            for (Account ac : ar.getAll()) {
                n = n + "\n" + ac.toString();
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("There are no accounts");
        }

        JTextArea jta = new JTextArea(n);
        jta.setBackground(new Color(255, 0, 0));
        this.add(jta);



    }


}
