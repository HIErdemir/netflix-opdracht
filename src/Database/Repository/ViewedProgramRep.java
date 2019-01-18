package Database.Repository;

import Database.Connection.SqlConnect;
import Logic.Profile;
import Logic.ViewedProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewedProgramRep {

    private SqlConnect databaseConnector;

    public ViewedProgramRep() {
        this.databaseConnector = new SqlConnect();
    }

    public ArrayList<ViewedProgram> getProfileViewedPrograms(int ProfileID) {
        ArrayList<ViewedProgram> ViewedList = new ArrayList<ViewedProgram>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ViewedProgram  where ProfileID = ?");
            stmt.setInt(1, ProfileID);
            stmt.executeQuery();

            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                int ViewedProgramID = resultSet.getInt("ViewedProgramID");
                int profileID = resultSet.getInt("profileID");
                int ProgramID = resultSet.getInt("ProgramID");
                int PercentageWatched = resultSet.getInt("PercentageWatched");

                ViewedList.add(new ViewedProgram(ViewedProgramID,ProgramID,profileID,PercentageWatched));
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

        return ViewedList;
    }

    public void insert(ViewedProgram program) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement max = connection.prepareStatement("SELECT MAX(ViewedProgramID) FROM ViewedProgram ");
            max.executeQuery();
            ResultSet maxID = max.getResultSet();

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID, PercentageWatched) VALUES (?, ?, ?, ?)");

            stmt.setInt(1,maxID.getInt("ViewedProgramID")+1);
            stmt.setInt(2, program.getProfileID());
            stmt.setInt(3, program.getProgramID());
            stmt.setInt(4, program.getPercentageWatched());

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

    public void delete(int ViewedProgramID) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM ViewedProgram WHERE ViewedProgramID = ?");
            stmt.setInt(1, ViewedProgramID);
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

    public void update(ViewedProgram program) {
        Connection connection = null;

        try {
            // Create connection with database
            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("UPDATE ViewedProgram SET ProfileID = ?, ProgramID = ? PercentageWatched = ? WHERE ViewedProgramID = ?)");

            stmt.setInt(1, program.getProfileID());
            stmt.setInt(2, program.getProgramID());
            stmt.setInt(3, program.getPercentageWatched());
            stmt.setInt(4, program.getViewedProgramID());

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
