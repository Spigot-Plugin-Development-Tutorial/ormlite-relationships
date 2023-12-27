package me.kodysimpson.ormliterelationships.listeners;

import me.kodysimpson.ormliterelationships.entities.GuildPlayer;
import me.kodysimpson.ormliterelationships.services.PlayerService;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private final PlayerService playerService;

    public JoinListener(PlayerService playerService) {
        this.playerService = playerService;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if (playerService.findByUuid(player.getUniqueId().toString()) == null){
            var guildPlayer = new GuildPlayer(player);
            playerService.create(guildPlayer);
        }

    }

}
