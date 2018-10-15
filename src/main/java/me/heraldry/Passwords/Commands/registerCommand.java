/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package main.java.me.heraldry.Passwords.Commands;

import java.util.ArrayList;
import java.util.UUID;
import main.java.me.heraldry.Passwords.Listeners.playerListeners;
import main.java.me.heraldry.Utils.storageUtils;
import main.java.me.heraldry.Utils.stringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class registerCommand
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        storageUtils storage = new storageUtils();
        if (cmd.getName().equalsIgnoreCase("register") && sender instanceof Player) {
            Player player = (Player)sender;
            String uuid = player.getUniqueId().toString();
            if (player.hasPermission("passwords.register")) {
                if (storage.getString("passwords", uuid + ".password") != null) {
                    player.sendMessage(" ");
                    player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cYou are already registered!"));
                    player.sendMessage(" ");
                    return true;
                }
                switch (args.length) {
                    case 0: {
                        player.sendMessage(" ");
                        player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cYou must include a password"));
                        player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cUsage: &4/register <password>"));
                        player.sendMessage(" ");
                        break;
                    }
                    case 1: {
                        player.sendMessage(" ");
                        player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cYour password has been set to &4" + args[0]));
                        player.sendMessage(" ");
                        try {
                            storage.setString("passwords", uuid + ".password", stringUtils.getSaltedHash(args[0]));
                        }
                        catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        playerListeners pl = new playerListeners();
                        playerListeners.notVerified.remove((Object)player);
                        break;
                    }
                    default: {
                        player.sendMessage(" ");
                        player.sendMessage("&8&l[&c&lPasswords&8&l] &cToo many arguments!");
                        player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &4Usage: &c/register <password>"));
                        player.sendMessage(" ");
                    }
                }
            }
        }
        return true;
    }
}
