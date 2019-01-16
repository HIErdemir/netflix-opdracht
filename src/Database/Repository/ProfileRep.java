package Database.Repository;

import Database.Connection.SqlConnect;

public class ProfileRep {

    private SqlConnect databaseConnector;

    public ProfileRep(SqlConnect databaseConnector) {
        this.databaseConnector = databaseConnector;
    }


}
