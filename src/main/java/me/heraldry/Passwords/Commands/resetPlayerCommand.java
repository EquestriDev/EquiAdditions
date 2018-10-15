/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package main.java.me.heraldry.Passwords.Commands;

import java.util.UUID;
import main.java.me.heraldry.Utils.storageUtils;
import main.java.me.heraldry.Utils.stringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class resetPlayerCommand
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        storageUtils storage = new storageUtils();
        if (cmd.getName().equalsIgnoreCase("passwordreset")) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                player.sendMessage(" ");
                player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cThat command can only be done from Console"));
                player.sendMessage(" ");
                return true;
            }
            switch (args.length) {
                case 0: {
                    sender.sendMessage(" ");
                    sender.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cUsage: &4/passwordreset <player>"));
                    sender.sendMessage(" ");
                    break;
                }
                case 1: {
                    Player player = Bukkit.getPlayer((String)args[0]);
                    if (player == null) {
                        sender.sendMessage(" ");
                        sender.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &4&l" + args[0] + " &cisn't online!"));
                        sender.sendMessage(" ");
                        return true;
                    }
                    storage.setString("passwords", player.getUniqueId().toString() + ".password", null);
                    sender.sendMessage(" ");
                    sender.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &4&l" + args[0] + "&c's password has been reset!"));
                    sender.sendMessage(" ");
                    break;
                }
                case 2: {
                    sender.sendMessage(" ");
                    sender.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cToo many arguments! Usage: &4/passwordreset <player>"));
                    sender.sendMessage(" ");
                }
            }
        }
        return true;
    }
}
