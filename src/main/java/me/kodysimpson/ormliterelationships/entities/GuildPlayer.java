package me.kodysimpson.ormliterelationships.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.bukkit.entity.Player;

@DatabaseTable(tableName = "players")
public class GuildPlayer {

    @DatabaseField(id = true)
    private String uuid;

    @DatabaseField(canBeNull = false)
    private String name;

    //Foreign keys that reference other tables
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "guild_id")
    private Guild guild;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private PlayerStats playerStats;

    public GuildPlayer() {
    }

    public GuildPlayer(Player player) {
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }
}
