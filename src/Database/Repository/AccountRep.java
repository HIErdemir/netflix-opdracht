package Database.Repository;

import Database.Connection.SqlConnect;
import Logic.Account;
import Logic.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountRep {

    private SqlConnect databaseConnector;

    public AccountRep() {
        this.databaseConnector = new SqlConnect();
    }


    public Account getAccount(int AccountID) {
        Account account = null;


        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Account WHERE AccountID = ?");
            stmt.setInt(1, AccountID);
            stmt.executeQuery();


            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                int Accountid = resultSet.getInt("AccountID");
                String Email = resultSet.getString("Email");
                String AccountName = resultSet.getString("AccountName");
                String AccountPassword = resultSet.getString("AccountPassword");

                account = new Account(Accountid, Email, AccountName, AccountPassword);

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

        return account;
    }

    public ArrayList<Account> getAll() {
        ArrayList<Account> accountList = new ArrayList<Account>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Account");

            stmt.executeQuery();

            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                int Accountid = resultSet.getInt("AccountID");
                String Email = resultSet.getString("Email");
                String AccountName = resultSet.getString("AccountName");
                String AccountPassword = resultSet.getString("AccountPassword");

                accountList.add(new Account(Accountid, Email, AccountName, AccountPassword));
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

        return accountList;
    }

    public void insert(String AccountName, String Email, String AccountPassword) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Account(Email, AccountName, AccountPassword) VALUES (?, ?,?)");

            stmt.setString(1, Email);
            stmt.setString(2, AccountName);
            stmt.setString(3, AccountPassword);

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

    public void delete(int AccountID) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM Account WHERE AccountID = ?");
            stmt.setInt(1, AccountID);
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

    public void update(int accountID, String AccountName, String Email, String AccountPassword) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("UPDATE Account SET Email = ?, AccountName = ?, AccountPassword)= ? WHERE AccountID = ? ");

            stmt.setString(1, Email);
            stmt.setString(2, AccountName);
            stmt.setString(3, AccountPassword);
            stmt.setInt(3, accountID);

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



