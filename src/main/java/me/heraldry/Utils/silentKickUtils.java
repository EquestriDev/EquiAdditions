/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package main.java.me.heraldry.Utils;

import java.io.PrintStream;
import java.util.ArrayList;
import main.java.me.heraldry.Misc.Commands.silentKick;
import main.java.me.heraldry.Utils.stringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class silentKickUtils {
    public static void list(Boolean isPlayer, CommandSender sender) {
        if (isPlayer.booleanValue()) {
            Player player = (Player)sender;
            player.sendMessage(stringUtils.colour("&7&m&l\u2055-------------------------------&7&l\u2055"));
            player.sendMessage(" ");
            int number = 0;
            for (String string : silentKick.messages) {
                player.sendMessage(stringUtils.colour(" &3&l" + String.valueOf(number) + "&7: &b" + string));
                ++number;
            }
            player.sendMessage(" ");
            player.sendMessage(stringUtils.colour("&7&m&l\u2055-------------------------------&7&l\u2055"));
            return;
        }
        System.out.print("\u2055-------------------------------\u2055");
        System.out.print(" ");
        int number = 0;
        for (String string : silentKick.messages) {
            System.out.print(" " + String.valueOf(number) + ": " + string);
            ++number;
        }
        System.out.print(" ");
        System.out.print("\u2055-------------------------------\u2055");
    }

    public static void mainList(Boolean isPlayer, CommandSender sender) {
        if (isPlayer.booleanValue()) {
            Player player = (Player)sender;
            player.sendMessage(stringUtils.colour("&7&m&l\u2055-------------------------------&7&l\u2055"));
            player.sendMessage(" ");
            player.sendMessage(stringUtils.colour(" &3/SilentKick &7- &bThis"));
            player.sendMessage(stringUtils.colour(" &3/SilentKick List &7- &bLists all kick messages"));
            player.sendMessage(stringUtils.colour(" &3/SilentKick <Player> &7- &bRandomizes kick message"));
            player.sendMessage(stringUtils.colour(" &3/SilentKick <Player> <Number> &7- &bKick player for message on &3/SilentKick List"));
            player.sendMessage(" ");
            player.sendMessage(stringUtils.colour("&7&m&l\u2055-------------------------------&7&l\u2055"));
            return;
        }
        System.out.print("\u2055-------------------------------\u2055");
        System.out.print(" ");
        System.out.print(" /SilentKick - This");
        System.out.print(" /SilentKick List - Lists all kick messages");
        System.out.print(" /SilentKick <Player> - Randomizes kick message");
        System.out.print(" /SilentKick <Player> <Number> - Kick player for message on /SilentKick List");
        System.out.print(" ");
        System.out.print("\u2055-------------------------------\u2055");
    }

    public static void kick(Boolean isPlayer, CommandSender sender, Player player) {
        String message = silentKick.messages.get(silentKick.randInt(0, silentKick.messages.size()));
        if (isPlayer.booleanValue()) {
            player.kickPlayer(message);
            sender.sendMessage(stringUtils.colour("&3KICK MESSAGE: &b" + message));
            return;
        }
        player.kickPlayer(message);
        System.out.print("KICK MESSAGE: " + message);
    }

    public static void kick(Boolean isPlayer, CommandSender sender, Player player, int number) {
        String message = silentKick.messages.get(number);
        if (isPlayer.booleanValue()) {
            player.kickPlayer(message);
            sender.sendMessage(stringUtils.colour("&3KICK MESSAGE: &b" + message));
            return;
        }
        player.kickPlayer(message);
        System.out.print("KICK MESSAGE: " + message);
    }

    public static void noPlayer(Boolean isPlayer, CommandSender sender, String noPlayerName) {
        if (isPlayer.booleanValue()) {
            Player player = (Player)sender;
            player.sendMessage(stringUtils.colour("&4&l" + noPlayerName + " &cis not a player that's online!"));
            return;
        }
        System.out.print("&4&l" + noPlayerName + " &cis not a player that's online!");
    }
}
