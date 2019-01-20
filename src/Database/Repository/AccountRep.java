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
            accountList.clear();
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
    public void insert(Account account) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Account(Email, AccountName, AccountPassword) VALUES (?, ?,?)");

            stmt.setString(1, account.getEmail());
            stmt.setString(2, account.getAccountName());
            stmt.setString(3, account.getAccountPassword());

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

    public int delete(int AccountID) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM Account WHERE AccountID = ?");
            stmt.setInt(1, AccountID);
            stmt.executeQuery();
            return 1;


        } catch (Exception e) {
            e.printStackTrace();
            return 0;
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

    public void update(Account account) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("UPDATE Account SET Email = ?, AccountName = ?, AccountPassword)= ? WHERE AccountID = ? ");

            stmt.setString(1, account.getEmail());
            stmt.setString(2, account.getAccountName());
            stmt.setString(3, account.getAccountPassword());
            stmt.setInt(4, account.getAccountID());

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

    public ArrayList<Account> getAccountsOneProfile() {
        ArrayList<Account> accountList = new ArrayList<Account>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT A.AccountID, A.AccountName, A.AccountPassword, A.Email\n" +
                    "FROM Account A JOIN NProfile P ON A.AccountID = P.AccountID\n" +
                    "GROUP BY A.AccountID, A.AccountName, A.AccountPassword, A.Email\n" +
                    "HAVING COUNT(A.AccountID) =  1");

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




}



