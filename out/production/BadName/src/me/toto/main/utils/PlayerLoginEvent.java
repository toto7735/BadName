package me.toto.main.utils;

import me.toto.main.BadName;
import me.toto.main.data.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerLoginEvent implements Listener {

    public BadName badName;
    public PlayerLoginEvent(BadName badName) {
        this.badName = badName;
        Bukkit.getPluginManager().registerEvents(this, badName);
    }

    Messages messages = new Messages(BadName.getInstance());

    @EventHandler
    public void onPlayerLogin(org.bukkit.event.player.PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (badName.getConfig().getStringList("BadNames").contains(player.getName())) {
            event.disallow(org.bukkit.event.player.PlayerLoginEvent.Result.KICK_BANNED, messages.kickMessage().replace("%name%", player.getName()));
        }
    }


}
