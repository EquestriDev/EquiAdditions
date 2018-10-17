package main.java.me.heraldry.Passwords.Listeners;

import java.util.ArrayList;
import java.util.UUID;
import main.java.me.heraldry.Main;
import main.java.me.heraldry.Utils.storageUtils;
import main.java.me.heraldry.Utils.stringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class playerListeners
implements Listener {
    public static ArrayList<Player> notVerified = new ArrayList();

    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        final storageUtils storage = new storageUtils();
        final Player player = event.getPlayer();
        final String uuid = player.getUniqueId().toString();
        if (player.hasPermission("passwords.force")) {
            notVerified.add(player);
            new BukkitRunnable(){

                public void run() {
                    if (storage.getString("passwords", uuid + ".password") != null) {
                        player.sendMessage(" ");
                        player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cPlease login using &4/login <password>"));
                        player.sendMessage(" ");
                    } else {
                        player.sendMessage(" ");
                        player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cPlease register using &4/register <password>"));
                        player.sendMessage(" ");
                    }
                }
            }.runTaskLaterAsynchronously((Plugin)Main.getInstance(), 20L);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (notVerified.contains((Object)event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (notVerified.contains((Object)event.getPlayer())) {
            Player player = event.getPlayer();
            player.sendMessage(" ");
            player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cYou need to login! Use &4/login <password>"));
            player.sendMessage(" ");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (event.getPlayer().hasPermission("passwords.force")) {
            if (event.getMessage().contains("/login") || event.getMessage().contains("/register")) {
                return;
            }
            if (event.getMessage().contains("/afk")) {
                if (notVerified.contains((Object)event.getPlayer())) {
                    event.getPlayer().sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cYou need to login! Use &4/login <password>"));
                    event.setCancelled(true);
                } else {
                    notVerified.add(event.getPlayer());
                    event.getPlayer().sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cYou have been locked again, please re-login using &4/login <password>"));
                    return;
                }
            }
            if (notVerified.contains((Object)event.getPlayer())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (notVerified.contains((Object)event.getPlayer())) {
            Player player = event.getPlayer();
            player.sendMessage(" ");
            player.sendMessage(stringUtils.colour("&8&l[&c&lPasswords&8&l] &cYou need to login! Use &4/login <password>"));
            player.sendMessage(" ");
            event.setCancelled(true);
        }
    }

    public void onInteractEntity(PlayerInteractEntityEvent event) {
        event.setCancelled(true);
    }

}
