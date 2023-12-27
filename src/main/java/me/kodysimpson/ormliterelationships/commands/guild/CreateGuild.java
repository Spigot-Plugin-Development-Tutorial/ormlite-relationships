package me.kodysimpson.ormliterelationships.commands.guild;

import me.kodysimpson.ormliterelationships.entities.Guild;
import me.kodysimpson.ormliterelationships.services.GuildService;
import me.kodysimpson.ormliterelationships.services.PlayerService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateGuild implements CommandExecutor {

    private final GuildService guildService;
    private final PlayerService playerService;

    public CreateGuild(GuildService guildService, PlayerService playerService) {
        this.guildService = guildService;
        this.playerService = playerService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player player){

            if (args.length == 0){
                player.sendMessage("You must provide a name for your guild!");
                return true;
            }

            String name = args[0];

            //get the GuildPlayer
            var guildPlayer = playerService.findByUuid(player.getUniqueId().toString());

            if (guildPlayer == null){
                player.sendMessage("Error, you are not in the database! Woopsies.");
                return true;
            }

            // Check to see if the player is already in a guild
            if (guildPlayer.getGuild() != null){
                player.sendMessage("You are already in a guild!");
                return true;
            }

            // Make sure there isn't already a guild with that name
            if (guildService.findByName(name) != null){
                player.sendMessage("A guild with that name already exists!");
                return true;
            }

            // Create the guild
            Guild guild = new Guild(name);
            guild = guildService.create(guild);

            // Add the player to the guild
            guildPlayer.setGuild(guild);

            // Update the player
            playerService.update(guildPlayer);

            player.sendMessage("Guild created! You are now the owner of " + guild.getName() + "!");

        }else {
            sender.sendMessage("Only players can use this command!");
        }

        return true;
    }
}
