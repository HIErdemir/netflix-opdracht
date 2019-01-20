package userInterface;

import Database.Repository.AccountRep;
import Logic.Account;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OverviewAccount extends JPanel {

    private userInterface.MainFrame mf;
    private AccountRep ar;
    private Color cl;
    private AccountRep accountRep;

    public OverviewAccount() {
        mf = new userInterface.MainFrame();
        ar = new AccountRep();
        cl = new Color(255,0,0);
        this.accountRep = new AccountRep();
    }

    /** Maakt de SubPanel**/
    public JPanel jpanel() {
        this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = getAll();
        JComponent panel2 = getAccount();
        JComponent panel3 = inputAccount();
        JComponent panel4 = updateAccount();
        JComponent panel5 = deleteAccount();
        JComponent panel6 = getAccountWithOneProfile();
        tabbedPane.addTab("Get all acounts", null, panel1, "Go to all Account");
        tabbedPane.addTab("Get account", null, panel2, "Search for account");
        tabbedPane.addTab("Input account", null, panel3, "Input account");
        tabbedPane.addTab("Update account", null, panel4, "Update account");
        tabbedPane.addTab("Verwijder account", null, panel5, "Verwijder account");
        tabbedPane.addTab("Get account with one profile", null, panel6, "Get account with one profile");


        this.add(tabbedPane);



        return this;
    }

    /**Dit zorgt voor alle accounts**/
    public JPanel getAll() {
        JPanel getAll = new JPanel();
        getAll.setBackground(cl);
        ArrayList<Account> accountList = new ArrayList<Account>();
        accountList = this.accountRep.getAll();
        String[] columnNames = {"ID", "Name", "Email", "Password"};

        for(Account account : accountList){
            JTextArea textArea = new JTextArea(account.getAccountID() + "\n" + account.getAccountName() + "\n" + account.getEmail() + "\n" + account.getAccountPassword());
            getAll.add(textArea);
        }

        return getAll;
    }

    public JPanel getAccount() {
        JPanel getAccount = new JPanel();
        getAccount.setBackground(cl);
        JTextArea Question = new JTextArea("Type here there accountID:   ");
        JTextArea input = new JTextArea("");

        getAccount.add(Question, BorderLayout.NORTH);
        getAccount.add(input, BorderLayout.CENTER);

        return getAccount;
    }

    public JPanel inputAccount() {
        JPanel inputAccount = new JPanel();




        inputAccount.setBackground(cl);




        return inputAccount;

    }

    public JPanel updateAccount() {
        JPanel updateAccount = new JPanel();
        updateAccount.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier kan een gebruiker een account updaten");

        updateAccount.add(textArea);

        return updateAccount;

    }

    public JPanel deleteAccount() {
        JPanel deleteAccount = new JPanel();
        deleteAccount.setBackground(cl);
        JTextArea textArea = new JTextArea("Type hier het Account ID:");
        final JTextField inputID = new JTextField(30);

        inputID.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          int id = Integer.parseInt(inputID.getText());
                                          ar.delete(id);
                                          inputID.setText("");
                                          getAll();
                                      }
                                  });

                deleteAccount.add(textArea);
        deleteAccount.add(inputID);

        return deleteAccount;
    }

    public JPanel getAccountWithOneProfile() {
        JPanel accountWithOneProfile = new JPanel();
        accountWithOneProfile.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier kan een gebruiker een de accounts zien die maar 1 profiel hebben");

        accountWithOneProfile.add(textArea);

        return accountWithOneProfile;



    }






}
