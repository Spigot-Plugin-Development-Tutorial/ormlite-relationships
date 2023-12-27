package me.kodysimpson.ormliterelationships.services;

import com.j256.ormlite.dao.Dao;
import me.kodysimpson.ormliterelationships.entities.GuildPlayer;
import me.kodysimpson.ormliterelationships.entities.PlayerStats;

public class StatsService {

    private final Dao<GuildPlayer, String> playerDao;
    private final Dao<PlayerStats, Integer> playerStatsDao;

    public StatsService(Dao<GuildPlayer, String> playerDao, Dao<PlayerStats, Integer> playerStatsDao) {
        this.playerDao = playerDao;
        this.playerStatsDao = playerStatsDao;
    }



}
