package Userinterface;

import Database.Repository.AccountRep;


import javax.swing.*;
import java.awt.*;

public class OverviewAccount extends JPanel {

    private MainFrame mf;
    private AccountRep ar;


    public OverviewAccount() {
        mf = new MainFrame();
        ar = new AccountRep();

    }


    public JPanel jpanel() {
        this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout());

        this.add(buttons());



        return this;
    }

    public Box buttons() {
        Box buttonBar = Box.createVerticalBox();


        JButton getAll = new JButton("Get all accounts");
        JButton getAccount = new JButton("Get account");
        JButton inputAccount = new JButton("Input new account");
        JButton updateAccount = new JButton("Update account");
        JButton deleteAccount = new JButton("Delete account");
        getAll.setMaximumSize(new Dimension(150, 100));
        getAll.setMinimumSize(new Dimension(150, 100));
        getAccount.setMaximumSize(new Dimension(150, 100));
        getAccount.setMinimumSize(new Dimension(150, 100));
        inputAccount.setMaximumSize(new Dimension(150, 100));
        inputAccount.setMinimumSize(new Dimension(150, 100));
        updateAccount.setMaximumSize(new Dimension(150, 100));
        updateAccount.setMinimumSize(new Dimension(150, 100));
        deleteAccount.setMaximumSize(new Dimension(150, 100));
        deleteAccount.setMinimumSize(new Dimension(150, 100));

        buttonBar.add(getAll);
        buttonBar.add(getAccount);
        buttonBar.add(inputAccount);
        buttonBar.add(updateAccount);
        buttonBar.add(deleteAccount);

        return buttonBar;

    }






}
