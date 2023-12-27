package me.kodysimpson.ormliterelationships.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "player_achievements")
public class PlayerAchievement {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "player_id")
    private GuildPlayer player;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "achievement_id")
    private Achievement achievement;

    @DatabaseField(canBeNull = false)
    private Date dateAchieved;

    public PlayerAchievement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GuildPlayer getPlayer() {
        return player;
    }

    public void setPlayer(GuildPlayer player) {
        this.player = player;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public Date getDateAchieved() {
        return dateAchieved;
    }

    public void setDateAchieved(Date dateAchieved) {
        this.dateAchieved = dateAchieved;
    }

}
