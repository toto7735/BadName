package me.toto.main;

import me.toto.main.commands.BadNameCommand;
import me.toto.main.utils.PlayerLoginEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;
import sun.security.krb5.Config;

import java.util.ArrayList;
import java.util.List;

public class BadName extends JavaPlugin {

    public static BadName instance;
    public static BadName getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        this.saveResource("config.yml", false);
        Bukkit.getLogger().info("§c§l-----------------------");
        Bukkit.getLogger().info("§c§lBadName §e0.1 §6by toto7735");
        Bukkit.getLogger().info("§eBeen §aEnabled!");
        Bukkit.getLogger().info("§c§l-----------------------");
        new BadNameCommand(this);
        new PlayerLoginEvent(this);
    }

    public void onDisable() {
        Bukkit.getLogger().info("§c§l-----------------------");
        Bukkit.getLogger().info("§c§lBadName §e0.1 §6by toto7735");
        Bukkit.getLogger().info("§eBeen §cDisabled!");
        Bukkit.getLogger().info("§c§l-----------------------");
    }

    public void addBadName(String playerName) {
        List<String> list = new ArrayList<>(this.getConfig().getStringList("BadNames"));
        list.add(playerName);
        this.getConfig().set("BadNames", list);
        saveConfig();
    }

    public void removeBadName(String playerName) {
        List<String> list = new ArrayList<>(this.getConfig().getStringList("BadNames"));
        list.remove(playerName);
        this.getConfig().set("BadNames", list);
        saveConfig();
    }
}
