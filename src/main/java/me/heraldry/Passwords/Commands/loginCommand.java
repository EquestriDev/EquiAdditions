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

public class loginCommand
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        storageUtils storage = new storageUtils();
        if (cmd.getName().equalsIgnoreCase("login") && sender instanceof Player) {
            Player player = (Player)sender;
            String uuid = player.getUniqueId().toString();
            if (player.hasPermission("passwords.login")) {
                if (storage.getString("passwords", uuid + ".password") == null) {
                    player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cYou are not registered!"));
                    return true;
                }
                if (!playerListeners.notVerified.contains((Object)player)) {
                    player.sendMessage(" ");
                    player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cYou are already logged in!"));
                    player.sendMessage(" ");
                    return true;
                }
                switch (args.length) {
                    case 0: {
                        player.sendMessage(" ");
                        player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cYou must include a password"));
                        player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cUsage: &4/login <password>"));
                        player.sendMessage(" ");
                        break;
                    }
                    case 1: {
                        try {
                            if (stringUtils.check(args[0], storage.getString("passwords", uuid + ".password"))) {
                                player.sendMessage(" ");
                                player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &aYou have logged in successfully"));
                                player.sendMessage(" ");
                                playerListeners.notVerified.remove((Object)player);
                                return true;
                            }
                            player.sendMessage(" ");
                            player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cThat password is incorrect!"));
                            player.sendMessage(" ");
                        }
                        catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        break;
                    }
                    default: {
                        player.sendMessage(" ");
                        player.sendMessage("&8&l[&c&lPasswords&8&l] &cToo many arguments!");
                        player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &4Usage: &c/login <password>"));
                        player.sendMessage(" ");
                    }
                }
            }
        }
        return true;
    }
}
