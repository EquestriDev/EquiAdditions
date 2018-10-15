/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  org.bukkit.Effect
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 */
package main.java.me.heraldry.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import main.java.me.heraldry.Utils.stringUtils;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class brushingUtils {
    public static HashMap<Entity, Integer> horseBrushes = new HashMap();
    public static HashMap<Entity, Long> horseTime = new HashMap();
    public static HashMap<Entity, Long> horseTime2 = new HashMap();
    public static HashMap<Player, Location> playerLocations = new HashMap();
    public static ArrayList<Entity> bypassTime = new ArrayList();

    public static void usesRemaining(Entity horse, Player player) {
        if (horseBrushes.get((Object)horse) == null) {
            horseBrushes.put(horse, 8);
            brushingUtils.brush(horse, player);
            return;
        }
        if (horseTime.containsKey((Object)horse) && System.currentTimeMillis() >= horseTime.get((Object)horse)) {
            horseBrushes.put(horse, 9);
        }
        switch (horseBrushes.get((Object)horse)) {
            case 9: {
                horseBrushes.replace(horse, 8);
                brushingUtils.brush(horse, player);
                break;
            }
            case 8: {
                horseBrushes.replace(horse, 7);
                brushingUtils.brush(horse, player);
                break;
            }
            case 7: {
                horseBrushes.replace(horse, 6);
                brushingUtils.brush(horse, player);
                break;
            }
            case 6: {
                horseBrushes.replace(horse, 5);
                brushingUtils.brush(horse, player);
                break;
            }
            case 5: {
                horseBrushes.replace(horse, 4);
                brushingUtils.brush(horse, player);
                break;
            }
            case 4: {
                horseBrushes.replace(horse, 3);
                brushingUtils.brush(horse, player);
                break;
            }
            case 3: {
                horseBrushes.replace(horse, 2);
                brushingUtils.brush(horse, player);
                break;
            }
            case 2: {
                horseBrushes.replace(horse, 1);
                brushingUtils.brush(horse, player);
                break;
            }
            case 1: {
                horseBrushes.replace(horse, 0);
                brushingUtils.brush(horse, player);
                break;
            }
            case 0: {
                if (!horseTime.containsKey((Object)horse)) {
                    horseTime.put(horse, System.currentTimeMillis() + 43200000L);
                    brushingUtils.brush(horse, player);
                    player.sendMessage(stringUtils.colour("&8&l[&b&lGrooming&8&l] &3You have brushed &b&l" + horse.getCustomName()));
                }
                player.sendMessage(stringUtils.colour("&8&l[&b&lGrooming&8&l] &b&l" + horse.getCustomName() + " &3Doesn't need brushing anymore!"));
                break;
            }
            default: {
                player.sendMessage("INVALID");
            }
        }
    }

    public static void brush(Entity horse, Player player) {
        int uses = horseBrushes.get((Object)horse);
        World world = horse.getWorld();
        switch (uses) {
            case 0: {
                Location location = horse.getLocation().subtract(0.0, 0.0, 2.0);
                double radius = 1.0;
                for (double t = 0.0; t <= 7.0; t += 0.5) {
                    double x = 1.0 * Math.cos(t);
                    double z = 1.0 * Math.sin(t);
                    location.add(x, t * 0.05, z);
                    world.playEffect(location, Effect.HEART, 10);
                }
                break;
            }
            default: {
                Location location1 = horse.getLocation();
                for (double t = 0.0; t <= 7.0; t += 0.5) {
                    world.playEffect(location1, Effect.LARGE_SMOKE, 50);
                }
                player.sendMessage(stringUtils.colour("&8&l[&b&lGrooming&8&l] &3You have brushed &b&l" + horse.getCustomName()));
            }
        }
    }
}
