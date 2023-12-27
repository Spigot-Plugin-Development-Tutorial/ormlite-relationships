package me.kodysimpson.ormliterelationships.services;

import com.j256.ormlite.dao.Dao;
import me.kodysimpson.ormliterelationships.entities.GuildPlayer;

public class PlayerService {

    private final Dao<GuildPlayer, String> playerDao;

    public PlayerService(Dao<GuildPlayer, String> playerDao) {
        this.playerDao = playerDao;
    }

    public GuildPlayer create(GuildPlayer player){
        try {
            playerDao.create(player);
            return player;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public GuildPlayer findByUuid(String uuid){
        try {
            return playerDao.queryForId(uuid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public GuildPlayer update(GuildPlayer player){
        try {
            playerDao.update(player);
            return player;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean existsByUuid(String uuid){
        try {
            return playerDao.idExists(uuid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
