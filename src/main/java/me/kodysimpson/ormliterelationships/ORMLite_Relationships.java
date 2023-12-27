package me.kodysimpson.ormliterelationships;

import me.kodysimpson.ormliterelationships.commands.achievements.CreateAchievements;
import me.kodysimpson.ormliterelationships.commands.guild.CreateGuild;
import me.kodysimpson.ormliterelationships.database.Database;
import me.kodysimpson.ormliterelationships.listeners.JoinListener;
import me.kodysimpson.ormliterelationships.services.AchievementService;
import me.kodysimpson.ormliterelationships.services.GuildService;
import me.kodysimpson.ormliterelationships.services.PlayerService;
import org.bukkit.plugin.java.JavaPlugin;

public final class ORMLite_Relationships extends JavaPlugin {

    private Database database;
    private GuildService guildService;
    private PlayerService playerService;
    private AchievementService achievementService;

    @Override
    public void onEnable() {
        // Plugin startup logic

        try{
            // Ensure the plugin's data folder exists
            if (!getDataFolder().exists()){
                getDataFolder().mkdirs();
            }

            // Create the database
            database = new Database(getDataFolder().getAbsolutePath() + "/database.db");

            //Create the services
            guildService = new GuildService(database.getGuildDao(), database.getPlayerDao());
            playerService = new PlayerService(database.getPlayerDao());
            achievementService = new AchievementService(database.getPlayerDao(), database.getAchievementDao(), database.getPlayerAchievementDao());
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create database! Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
        }

        //Register the commands
        getCommand("createguild").setExecutor(new CreateGuild(guildService, playerService));
        getCommand("createachievements").setExecutor(new CreateAchievements(playerService, achievementService));

        //Register the listeners
        getServer().getPluginManager().registerEvents(new JoinListener(playerService), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
