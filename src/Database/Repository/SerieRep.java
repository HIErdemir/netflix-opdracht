package Database.Repository;

import Database.Connection.SqlConnect;
import Logic.Account;
import Logic.Episode;
import Logic.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SerieRep {

    private SqlConnect databaseConnector;

    public SerieRep() {
        this.databaseConnector = new SqlConnect();
    }

    public ArrayList<Serie> getAll(){
        ArrayList<Serie> SerieList = new ArrayList<Serie>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TvShow");

            stmt.executeQuery();

            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {

                int serieID = resultSet.getInt("TvShowID");
                String title = resultSet.getString("Title");
                String genre = resultSet.getString("Genre");
                String language = resultSet.getString("ShowLanguage");
                int age = resultSet.getInt("ContentRating");

                SerieList.add(new Serie(serieID, title ,genre, language, age));
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

        return SerieList;
    }

    public ArrayList<Episode> getAvgEpisodePerSerie(int SerieID){
        ArrayList<Episode> EpisodeList = new ArrayList<Episode>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT P.ProgramID,E.TvShowID, E.SeasonNr, E.EpisodeNr, P.ProgramTitle, P.Duration, avg(VP.PercentageWatched) AS AvgWatched\n" +
                    "FROM Episode E JOIN Program P ON E.ProgramID = P.ProgramID\n" +
                    "\tJOIN ViewedProgram VP ON P.ProgramID = VP.ProgramID \n" +
                    "WHERE E.TvShowID =?" +
                    "GROUP BY  E.SeasonNr, E.EpisodeNr, P.ProgramTitle, P.Duration");

            stmt.setInt(1,SerieID);
            stmt.executeQuery();

            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {

                int ProgramID = resultSet.getInt("P.ProgramID");
                int TvShowID = resultSet.getInt("E.TvShowID");
                int SeasonNr = resultSet.getInt("E.SeasonNr");
                int EpisodeNr = resultSet.getInt("E.EpisodeNr");
                int Duration = resultSet.getInt("P.Duration");
                int AvgWatched = resultSet.getInt("AvgWatched");

                String ProgramTitle = resultSet.getString("P.ProgramTitle");

                EpisodeList.add(new Episode(ProgramID,ProgramTitle,Duration,EpisodeNr,SeasonNr,TvShowID,AvgWatched));
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

        return EpisodeList;
    }

    public ArrayList<Episode> getAvgEpisodePerSeriePerAccount(int SerieID, int accountID){
        ArrayList<Episode> EpisodeList = new ArrayList<Episode>();

        Connection connection = null;

        try {

            connection = databaseConnector.getConnection();

            PreparedStatement stmt = connection.prepareStatement("SELECT P.ProgramID,E.TvShowID, E.SeasonNr, E.EpisodeNr, P.ProgramTitle, P.Duration, avg(VP.PercentageWatched) AS AvgWatched\n" +
                    "FROM Episode E JOIN Program P ON E.ProgramID = P.ProgramID\n" +
                    "     JOIN ViewedProgram VP ON P.ProgramID = VP.ProgramID \n" +
                    "     JOIN NProfile NP ON  VP.ProfileID = NP.ProfileID\n" +
                    "\t JOIN Account A ON  NP.AccountID = A.AccountID\n" +
                    "WHERE E.TvShowID = ? AND A.AccountID = ?\n" +
                    "GROUP BY  P.ProgramID,E.TvShowID, E.SeasonNr, E.EpisodeNr, P.ProgramTitle, P.Duration");

            stmt.setInt(1,SerieID);
            stmt.setInt(2,accountID);
            stmt.executeQuery();

            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {

                int ProgramID = resultSet.getInt("P.ProgramID");
                int TvShowID = resultSet.getInt("E.TvShowID");
                int SeasonNr = resultSet.getInt("E.SeasonNr");
                int EpisodeNr = resultSet.getInt("E.EpisodeNr");
                int Duration = resultSet.getInt("P.Duration");
                int AvgWatched = resultSet.getInt("AvgWatched");

                String ProgramTitle = resultSet.getString("P.ProgramTitle");

                EpisodeList.add(new Episode(ProgramID,ProgramTitle,Duration,EpisodeNr,SeasonNr,TvShowID,AvgWatched));
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

        return EpisodeList;
    }

}
