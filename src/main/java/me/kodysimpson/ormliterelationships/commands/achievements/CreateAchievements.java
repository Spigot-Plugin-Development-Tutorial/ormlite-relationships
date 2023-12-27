package me.kodysimpson.ormliterelationships.commands.achievements;

import me.kodysimpson.ormliterelationships.entities.Achievement;
import me.kodysimpson.ormliterelationships.services.AchievementService;
import me.kodysimpson.ormliterelationships.services.PlayerService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateAchievements implements CommandExecutor {

    private final PlayerService playerService;
    private final AchievementService achievementService;

    public CreateAchievements(PlayerService playerService, AchievementService achievementService) {
        this.playerService = playerService;
        this.achievementService = achievementService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        //Create some achievements for the player as a test
        if (sender instanceof Player player){
            var guildPlayer = playerService.findByUuid(player.getUniqueId().toString());

            if (guildPlayer == null){
                player.sendMessage("Error, you are not in the database! Woopsies.");
                return true;
            }

            //Create some random test achievements
            Achievement achievement1 = new Achievement("First Achievement", "This is the first achievement!");
            Achievement achievement2 = new Achievement("Second Achievement", "This is the second achievement!");
            Achievement achievement3 = new Achievement("Third Achievement", "This is the third achievement!");
            achievementService.create(achievement1);
            achievementService.create(achievement2);
            achievementService.create(achievement3);

            //Add the achievements to the player
            achievementService.addAchievementToPlayer(guildPlayer, achievement1);
            achievementService.addAchievementToPlayer(guildPlayer, achievement2);
            achievementService.addAchievementToPlayer(guildPlayer, achievement3);

        }

        return true;
    }
}
