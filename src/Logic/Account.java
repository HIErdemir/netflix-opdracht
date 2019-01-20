package Logic;


import Database.Repository.ProfileRep;
import javax.swing.*;
import java.util.ArrayList;

public class Account{

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
        return AccountID + "\n" + Email + "\n" + AccountName + "\n" + AccountPassword + "\n";
             
    }

    public void getMyProfiles(){
        ProfileRep searchProfiles = new ProfileRep();
        Profiles = searchProfiles.getAccountProfiles(getAccountID());
    }

    public void addProfile(String name, String birdtdate){
        ProfileRep Profile = new ProfileRep();
        Profile.insert(AccountID,name, birdtdate);
        Profiles.clear();
        getMyProfiles();
    }

    public void addProfile(Profile profile){
        ProfileRep Profile = new ProfileRep();
        Profile.insert(profile);
        Profiles.clear();
        getMyProfiles();
    }

    public void deleteProfile(int profileID){
        ProfileRep Profile = new ProfileRep();
        Profile.delete(profileID);
        Profiles.clear();
        getMyProfiles();
    }

    public void updateProfile(Profile profile){
        ProfileRep Profile = new ProfileRep();
        Profile.update(profile);
        Profiles.clear();
        getMyProfiles();
    }
}
