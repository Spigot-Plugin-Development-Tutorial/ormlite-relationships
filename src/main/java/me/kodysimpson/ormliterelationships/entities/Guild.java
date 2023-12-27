package me.kodysimpson.ormliterelationships.entities;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "guilds")
public class Guild {

    @DatabaseField(generatedId = true)
    private int id; //This is the primary key

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField(canBeNull = true)
    private String tag;

    @DatabaseField(canBeNull = true)
    private String description;

    //Foreign keys that reference other tables

    //ONE to MANY relationship that links back to the Player table
    @ForeignCollectionField(foreignFieldName = "guild")
    private ForeignCollection<GuildPlayer> members;

    public Guild() { }

    public Guild(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ForeignCollection<GuildPlayer> getMembers() {
        return members;
    }
}
