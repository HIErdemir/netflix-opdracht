package Database.Repository;

import Database.Connection.SqlConnect;
import Logic.Account;
import Logic.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfileRep {

    private SqlConnect databaseConnector;

    public ProfileRep() {
        this.databaseConnector = new SqlConnect();
    }

    public ArrayList<Profile> getAll(){
        ArrayList<Profile> profileList = new ArrayList<Profile>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM NProfile P ");

            stmt.executeQuery();

            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                String NameUser = resultSet.getString("NameUser");
                String Birthdate = resultSet.getString("Birthdate");
                int profileID = resultSet.getInt("ProfileID");
                int accountID = resultSet.getInt("AccountID");

                profileList.add(new Profile(profileID, NameUser, Birthdate, accountID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return profileList;
    }

    public ArrayList<Profile> getAccountProfiles(int accountID) {
        ArrayList<Profile> profileList = new ArrayList<Profile>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT P.NameUser, P.Birthdate, P.ProfileID\n " +
                    "FROM NProfile P  where P.AccountID = ?");
            stmt.setInt(1, accountID);
            stmt.executeQuery();

            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                String NameUser = resultSet.getString("NameUser");
                String Birthdate = resultSet.getString("Birthdate");
                int profileID = resultSet.getInt("AccountID");

                profileList.add(new Profile(profileID,NameUser, Birthdate,accountID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return profileList;
    }

    public void insert(Profile profile) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO NProfile(NameUser,Birthdate,AccountID) VALUES (?, ?, ?)");


            stmt.setString(1, profile.getName());
            stmt.setString(2, profile.getAge());
            stmt.setInt(3, profile.getAccountID());

            stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void insert(int accountId,String name, String birthdate) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO NProfile(NameUser,Birthdate,AccountID) VALUES (?, ?, ?)");


            stmt.setString(1, name);
            stmt.setString(2, birthdate);
            stmt.setInt(3, accountId);

            stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void delete(int ProfileID) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM NProfile WHERE ProfileID = ?");
            stmt.setInt(1, ProfileID);
            stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(Profile profile) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("UPDATE NProfile SET NameUser = ?, Birthdate = ? WHERE ProfileID = ?)");

            stmt.setString(1, profile.getName());
            stmt.setString(2, profile.getAge());
            stmt.setInt(3, profile.getProfileID());

            stmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
