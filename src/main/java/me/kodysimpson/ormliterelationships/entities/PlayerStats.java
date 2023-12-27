package me.kodysimpson.ormliterelationships.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "player_stats")
public class PlayerStats {

    @DatabaseField(generatedId = true)
    private int id;

    //it is unique so that there is a one to one relationship
    @DatabaseField(foreign = true, unique = true)
    private GuildPlayer player;

    @DatabaseField(canBeNull = false)
    private long blocksBroken;

    public PlayerStats() {
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

    public long getBlocksBroken() {
        return blocksBroken;
    }

    public void setBlocksBroken(long blocksBroken) {
        this.blocksBroken = blocksBroken;
    }
}
