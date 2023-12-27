package me.kodysimpson.ormliterelationships.services;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ForeignCollection;
import me.kodysimpson.ormliterelationships.entities.Guild;
import me.kodysimpson.ormliterelationships.entities.GuildPlayer;

import java.util.List;

public class GuildService {

    private final Dao<Guild, Integer> guildDao;
    private final Dao<GuildPlayer, String> playerDao;

    public GuildService(Dao<Guild, Integer> guildDao, Dao<GuildPlayer, String> playerDao) {
        this.guildDao = guildDao;
        this.playerDao = playerDao;
    }

    public Guild create(Guild guild){
        try {
            guildDao.create(guild);
            return guild;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Guild findByName(String name){
        try {
            return guildDao.queryBuilder().where().eq("name", name).queryForFirst();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Guild findById(int id){
        try {
            return guildDao.queryForId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Guild> findAll(){
        try {
            return guildDao.queryForAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Guild update(Guild guild){
        try {
            guildDao.update(guild);
            return guild;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteById(int id){
        try {
            guildDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ForeignCollection<GuildPlayer> getGuildMembers(int guildId){
        try {
            return guildDao.queryForId(guildId).getMembers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
