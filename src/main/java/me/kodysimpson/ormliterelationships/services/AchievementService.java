package me.kodysimpson.ormliterelationships.services;

import com.j256.ormlite.dao.Dao;
import me.kodysimpson.ormliterelationships.entities.Achievement;
import me.kodysimpson.ormliterelationships.entities.GuildPlayer;
import me.kodysimpson.ormliterelationships.entities.PlayerAchievement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AchievementService {

    private final Dao<GuildPlayer, String> playerDao;
    private final Dao<Achievement, Integer> achievementDao;
    private final Dao<PlayerAchievement, Integer> playerAchievementDao;

    public AchievementService(Dao<GuildPlayer, String> playerDao, Dao<Achievement, Integer> achievementDao, Dao<PlayerAchievement, Integer> playerAchievementDao) {
        this.playerDao = playerDao;
        this.achievementDao = achievementDao;
        this.playerAchievementDao = playerAchievementDao;
    }

    public Achievement create(Achievement achievement){
        try {
            achievementDao.create(achievement);
            return achievement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Add an achievement to a player
    public boolean addAchievementToPlayer(GuildPlayer player, Achievement achievement){

        try{

            PlayerAchievement playerAchievement = new PlayerAchievement();
            playerAchievement.setPlayer(player);
            playerAchievement.setAchievement(achievement);
            playerAchievement.setDateAchieved(new Date());

            playerAchievementDao.create(playerAchievement);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    //Get the achievements that a player has
    public List<Achievement> getAchievementsForPlayer(GuildPlayer player){

        try{

            List<PlayerAchievement> playerAchievements = playerAchievementDao.queryBuilder().where().eq("player_id", player).query();

            if (playerAchievements == null){
                return null;
            }

            //Go through each player achievement and get the achievement object
            List<Achievement> achievements = new ArrayList<>();
            for (PlayerAchievement playerAchievement : playerAchievements){
                achievements.add(playerAchievement.getAchievement());
            }

            if (achievements.isEmpty()){
                return null;
            }

            return achievements;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    //Get the players that have a certain achievement
    public List<GuildPlayer> getPlayersWithAchievement(Achievement achievement){

        try{

            List<PlayerAchievement> playerAchievements = playerAchievementDao.queryBuilder().where().eq("achievement_id", achievement).query();

            if (playerAchievements == null){
                return null;
            }

            //Go through each player achievement and get the player object
            List<GuildPlayer> players = new ArrayList<>();
            for (PlayerAchievement playerAchievement : playerAchievements){
                players.add(playerAchievement.getPlayer());
            }

            if (players.isEmpty()){
                return null;
            }

            return players;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
