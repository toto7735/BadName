package me.toto.main.data;

import me.toto.main.BadName;
import org.bukkit.ChatColor;

public class Messages {

    BadName badName;
    public Messages(BadName badName) {
        this.badName = badName;
    }

    public String noPermissionMessage() {
        return ChatColor.translateAlternateColorCodes('&', badName.getConfig().getString("No-Permission-Message"));
    }

    public String helpMessage() {
        return ChatColor.translateAlternateColorCodes('&', badName.getConfig().getString("Help-Message"));
    }

    public String listMessage() {
        return ChatColor.translateAlternateColorCodes('&', badName.getConfig().getString("List-Message"));
    }


    public String addedMessage() {
        return ChatColor.translateAlternateColorCodes('&', badName.getConfig().getString("Added-Message"));
    }

    public String removedMessage() {
        return ChatColor.translateAlternateColorCodes('&', badName.getConfig().getString("Removed-Message"));
    }

    public String nameNotExistsMessage() {
        return ChatColor.translateAlternateColorCodes('&', badName.getConfig().getString("Name-Not-Exists"));
    }

    public String nameAlreadyExistsMessage() {
        return ChatColor.translateAlternateColorCodes('&', badName.getConfig().getString("Name-Already-Exists"));
    }

    public String kickMessage() {
        return ChatColor.translateAlternateColorCodes('&', badName.getConfig().getString("Kick-Message"));
    }

    public String reloadedMessage() {
        return ChatColor.translateAlternateColorCodes('&', badName.getConfig().getString("Reloaded-Message"));
    }



}
