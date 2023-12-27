package me.kodysimpson.ormliterelationships.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;
import me.kodysimpson.ormliterelationships.entities.*;

import java.sql.SQLException;

public class Database {

    private final Dao<Guild, Integer> guildDao;
    private final Dao<GuildPlayer, String> playerDao;
    private final Dao<Achievement, Integer> achievementDao;
    private final Dao<PlayerAchievement, Integer> playerAchievementDao;
    private final Dao<PlayerStats, Integer> playerStatsDao;

    public Database(String path) throws SQLException {
        var connectionSource = new JdbcConnectionSource("jdbc:sqlite:" + path);
        TableUtils.createTableIfNotExists(connectionSource, Guild.class);
        TableUtils.createTableIfNotExists(connectionSource, GuildPlayer.class);
        TableUtils.createTableIfNotExists(connectionSource, Achievement.class);
        TableUtils.createTableIfNotExists(connectionSource, PlayerAchievement.class);
        TableUtils.createTableIfNotExists(connectionSource, PlayerStats.class);

        //Create the DAOs
        guildDao = DaoManager.createDao(connectionSource, Guild.class);
        playerDao = DaoManager.createDao(connectionSource, GuildPlayer.class);
        achievementDao = DaoManager.createDao(connectionSource, Achievement.class);
        playerAchievementDao = DaoManager.createDao(connectionSource, PlayerAchievement.class);
        playerStatsDao = DaoManager.createDao(connectionSource, PlayerStats.class);
    }

    public Dao<Guild, Integer> getGuildDao() {
        return guildDao;
    }

    public Dao<GuildPlayer, String> getPlayerDao() {
        return playerDao;
    }

    public Dao<Achievement, Integer> getAchievementDao() {
        return achievementDao;
    }

    public Dao<PlayerAchievement, Integer> getPlayerAchievementDao() {
        return playerAchievementDao;
    }

    public Dao<PlayerStats, Integer> getPlayerStatsDao() {
        return playerStatsDao;
    }
}
