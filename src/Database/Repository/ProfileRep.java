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

    public ProfileRep(SqlConnect databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

   /* public ArrayList<Profile> getAll(){
        ArrayList<Profile> profileList = new ArrayList<Account>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Profile");

            stmt.executeUpdate();

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
    }*/


}
