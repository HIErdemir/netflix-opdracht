package userInterface;

import Database.Repository.AccountRep;
import Logic.Account;
import sun.tools.jar.Main;


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
    private JComponent panel2;
    private JTabbedPane tabs;

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

        tabs = new JTabbedPane();
        JComponent panel1 = getAll();
        this.panel2 = getAccount();
        JComponent panel3 = inputAccount();
        JComponent panel4 = updateAccount();
        JComponent panel5 = deleteAccount();
        JComponent panel6 = getAccountWithOneProfile();
        tabs.addTab("Get all acounts", null, panel1, "Go to all Account");
        tabs.addTab("Get account", null, panel2, "Search for account");
        tabs.addTab("Input account", null, panel3, "Input account");
        tabs.addTab("Update account", null, panel4, "Update account");
        tabs.addTab("Verwijder account", null, panel5, "Verwijder account");
        tabs.addTab("Get account with one profile", null, panel6, "Get account with one profile");


        this.add(tabs);



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
            JTextArea textArea = new JTextArea(account.getAccountID() + "\n" + account.getAccountName() + "\n" +
                    account.getEmail() + "\n" + account.getAccountPassword());
            getAll.add(textArea);
        }

        return getAll;
    }

    public JPanel getAccount() {
        final JPanel getAccount = new JPanel();
        getAccount.setBackground(cl);
        JTextArea Question = new JTextArea("Type here there accountID:   ");
        final JTextField inputID = new JTextField(30);

        inputID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(inputID.getText());
                JTextArea account = new JTextArea(ar.getAccount(id).toString());
                getAccount.add(account);
                inputID.setText("");
                SwingUtilities.updateComponentTreeUI(tabs);
            }
        });



        getAccount.add(Question, BorderLayout.NORTH);
        getAccount.add(inputID, BorderLayout.CENTER);

        return getAccount;
    }

    public JPanel inputAccount() {
        final JPanel inputAccount = new JPanel();
        inputAccount.setBackground(cl);

        JTextArea Email = new JTextArea("Email: ");
        final JTextField inputEmail = new JTextField(10);
        JTextArea Name = new JTextArea("AccountName: ");
        final JTextField inputAccountName = new JTextField(10);
        JTextArea Password = new JTextArea("Password: ");
        final JTextField inputPassword = new JTextField(10);
        inputAccount.add(Email);
        inputAccount.add(inputEmail);
        inputAccount.add(Name);
        inputAccount.add(inputAccountName);
        inputAccount.add(Password);
        inputAccount.add(inputPassword);



            inputPassword.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   String Email = inputEmail.getText();
                    String Name = inputAccountName.getText();
                    String password = inputPassword.getText();

                    if(!Email.isEmpty() && !Name.isEmpty() && !password.isEmpty()) {
                        ar.insert(Email, Name, password);
                        inputEmail.setText("");
                        inputAccountName.setText("");
                        inputPassword.setText("");
                        JTextArea ta = new JTextArea("Restart program, so the account is add in" +
                                "the overviews");

                        inputAccount.add(ta);
                        SwingUtilities.updateComponentTreeUI(tabs);
                }
            }
        });

        return inputAccount;

    }

    public JPanel updateAccount() {
        final JPanel updateAccount = new JPanel();
        updateAccount.setBackground(cl);
        JTextArea textArea = new JTextArea("Hier kan een gebruiker een account updaten");

        JTextArea ID = new JTextArea("ID: ");
        final JTextField inputID = new JTextField(10);
        JTextArea Email = new JTextArea("Email: ");
        final JTextField inputEmail = new JTextField(10);
        JTextArea Name = new JTextArea("AccountName: ");
        final JTextField inputAccountName = new JTextField(10);
        JTextArea Password = new JTextArea("Password: ");
        final JTextField inputPassword = new JTextField(10);
        updateAccount.add(ID);
        updateAccount.add(inputID);
        updateAccount.add(Email);
        updateAccount.add(inputEmail);
        updateAccount.add(Name);
        updateAccount.add(inputAccountName);
        updateAccount.add(Password);
        updateAccount.add(inputPassword);

        inputPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int accountid = Integer.parseInt(inputID.getText());
                String Email = inputEmail.getText();
                String Name = inputAccountName.getText();
                String password = inputPassword.getText();

                if(accountid > 0 & !Email.isEmpty() && !Name.isEmpty() && !password.isEmpty()) {
                    ar.update(accountid, Email, Name, password);
                    inputID.setText("");
                    inputEmail.setText("");
                    inputAccountName.setText("");
                    inputPassword.setText("");
                    JTextArea ta = new JTextArea("Restart program, so the update is in" +
                            "the overviews");

                    updateAccount.add(ta);
                    SwingUtilities.updateComponentTreeUI(tabs);
                }
            }
        });

        return updateAccount;

    }

    public JPanel deleteAccount() {
        final JPanel deleteAccount = new JPanel();
        deleteAccount.setBackground(cl);
        JTextArea textArea = new JTextArea("Type hier het Account ID:");
        final JTextField inputID = new JTextField(30);

        inputID.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          int id = Integer.parseInt(inputID.getText());
                                          ar.delete(id);
                                          inputID.setText("");
                                          JTextArea ta = new JTextArea("Restart program, so the account is delete in" +
                                                  "the overviews");
                                          deleteAccount.add(ta);
                                          SwingUtilities.updateComponentTreeUI(tabs);
                                                                                }
                                  });

        deleteAccount.add(textArea);
        deleteAccount.add(inputID);

        return deleteAccount;
    }

    public JPanel getAccountWithOneProfile() {
        JPanel accountWithOneProfile = new JPanel();
        accountWithOneProfile.setBackground(cl);

        ArrayList<Account> accountOPList = new ArrayList<Account>();
        accountOPList = this.accountRep.getAccountsOneProfile();
        String[] columnNames = {"ID", "Name", "Email", "Password"};

        for(Account account : accountOPList){
            JTextArea textArea = new JTextArea(account.getAccountID() + "\n" + account.getAccountName() + "\n" +
                    account.getEmail() + "\n" + account.getAccountPassword());
            accountWithOneProfile.add(textArea);
        }

        return accountWithOneProfile;



    }






}
