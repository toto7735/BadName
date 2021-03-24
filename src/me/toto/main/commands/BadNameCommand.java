package me.toto.main.commands;

import me.toto.main.BadName;
import me.toto.main.data.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class BadNameCommand implements CommandExecutor {

    BadName badName;
    public BadNameCommand(BadName badName) {
        this.badName = badName;
        badName.getCommand("badname").setExecutor(this);
    }

    Messages messages = new Messages(BadName.getInstance());
    
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            if (!player.hasPermission("badname.help")) {
                player.sendMessage(messages.noPermissionMessage());
                return false;
            }
            player.sendMessage(messages.helpMessage());
            return false;
        } else if (args[0].equalsIgnoreCase("help")) {
            if (!player.hasPermission("badname.help")) {
                player.sendMessage(messages.noPermissionMessage());
                return false;
            }
            player.sendMessage(messages.helpMessage());
            return false;
        } else if (args[0].equalsIgnoreCase("add")) {
            if (!player.hasPermission("badname.add")) {
                player.sendMessage(messages.noPermissionMessage());
                return false;
            }
            if (args.length != 2) {
                player.sendMessage(messages.helpMessage());
                return false;
            }
            if (badName.getConfig().getStringList("BadNames").contains(args[1])) {
                player.sendMessage(messages.nameAlreadyExistsMessage().replace("%name%", args[1]));
                return false;
            }
            badName.addBadName(args[1]);
            player.sendMessage(messages.addedMessage().replace("%name%", args[1]));
        } else if (args[0].equalsIgnoreCase("remove")) {
            if (!player.hasPermission("badname.remove")) {
                player.sendMessage(messages.noPermissionMessage());
                return false;
            }
            if (args.length != 2) {
                player.sendMessage(messages.helpMessage().replace("%name%", args[1]));
                return false;
            }
            if (!badName.getConfig().getStringList("BadNames").contains(args[1])) {
                player.sendMessage(messages.nameNotExistsMessage().replace("%name%", args[1]));
                return false;
            }
            badName.removeBadName(args[1]);
            player.sendMessage(messages.removedMessage().replace("%name%", args[1]));
        } else if (args[0].equalsIgnoreCase("list")) {
            if (!player.hasPermission("badname.list")) {
                player.sendMessage(messages.noPermissionMessage());
                return false;
            }
            List<String> list = badName.getConfig().getStringList("BadNames");
            player.sendMessage(messages.listMessage().replace("%list%", list.toString()));
        } else if (args[0].equalsIgnoreCase("reload")) {
            if (!player.hasPermission("badname.reload")) {
                player.sendMessage(messages.noPermissionMessage());
                return false;
            }
            badName.reloadConfig();
            player.sendMessage(messages.reloadedMessage());
        }
        return false;
    }
}
