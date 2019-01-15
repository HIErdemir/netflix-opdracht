package Database.Repository;

import Database.Connection.SqlConnect;
import Logic.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountRep {

    private SqlConnect databaseConnector;

    public AccountRep(SqlConnect databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public Account getAccount(int AccountID) {
        Account account = null;


        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Account WHERE AccountID = ?");
            stmt.setInt(1,AccountID);
            stmt.executeUpdate();


            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                int Accountid = resultSet.getInt("AccountID");
                String Email = resultSet.getString("Email");
                String AccountName = resultSet.getString("AccountName");
                String AccountPassword = resultSet.getString("AccountPassword");String city = resultSet.getString("city");

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

  /*public ArrayList<Account> getAll(){
        ArrayList<Account> accountList = new ArrayList<Account>();

      Connection connection = null;

      try {

          connection = databaseConnector.getConnection();

          PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Account");

          stmt.executeUpdate();

          ResultSet resultSet = stmt.getResultSet();

          while (resultSet.next()) {
              int Accountid = resultSet.getInt("AccountID");
              String Email = resultSet.getString("Email");
              String AccountName = resultSet.getString("AccountName");
              String AccountPassword = resultSet.getString("AccountPassword");String city = resultSet.getString("city");

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



  }*/



    public void insert(String AccountName,String Email, String AccountPassword) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Account(Email, AccountName, AccountPassword) VALUES (?, ?, ?)");

            stmt.setString(1,Email);
            stmt.setString(2,AccountName);
            stmt.setString(3,AccountPassword);

            stmt.executeUpdate();

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
            stmt.setInt(1,AccountID);
            stmt.executeUpdate();

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
