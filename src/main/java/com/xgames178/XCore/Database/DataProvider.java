package com.xgames178.XCore.Database;

import com.xgames178.XCore.Player.ProfileData;
import com.xgames178.XCore.Utils.Rank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 * Created by jpdante on 02/05/2017.
 */
public class DataProvider {
    private Database database;
    private Statement statement;

    public DataProvider(Database database) {
        this.database = database;
        try {
            this.statement = database.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProfileData getProfileData(UUID uuid) {
        ResultSet res = null;
        try {
            res = this.statement.executeQuery("SELECT * FROM `arcade_players` WHERE `uuid`= '" + uuid.toString() + "';");
            ProfileData profileData = new ProfileData();
            if(res.next()) {
                profileData.uuid = uuid;
                profileData.rank = Rank.valueOf(res.getString("rank"));
            } else {
                this.statement.executeUpdate("INSERT INTO `arcade_players` (`uuid`, `rank`) VALUES ('" + uuid.toString() + "', 'NONE');");
                profileData.uuid = uuid;
                profileData.rank = Rank.NONE;
            }
            return profileData;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
