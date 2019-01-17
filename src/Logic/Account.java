package Logic;

import java.util.ArrayList;

public class Account {

 private int AccountID;
 private String Email;
 private String AccountName;
 private String AccountPassword;

 private ArrayList Profiles;

    public Account(int accountID, String email, String accountName, String accountPassword) {
        this.AccountID = accountID;
        this.Email = email;
        this.AccountName = accountName;
        this.AccountPassword = accountPassword;
        Profiles = new ArrayList();
    }

    public int getAccountID() {
        return AccountID;
    }

    public String getEmail() {
        return Email;
    }

    public String getAccountName() {
        return AccountName;
    }

    public String getAccountPassword() {
        return AccountPassword;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountID=" + AccountID +
                ", Email='" + Email + '\'' +
                ", AccountName='" + AccountName + '\'' +
                ", AccountPassword='" + AccountPassword + '\'' +
                ", Profiles=" + Profiles +
                '}';
    }
}
