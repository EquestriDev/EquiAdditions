package main.java.me.heraldry.Utils;

import java.util.HashMap;
import main.java.me.heraldry.Utils.brushingUtils;
import main.java.me.heraldry.Utils.stringUtils;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class hoofPickUtils {
    public static HashMap<Entity, Integer> horseHoofPick = new HashMap();

    public static void hoofpickUses(Entity horse, Player player) {
        if (horseHoofPick.get((Object)horse) == null) {
            horseHoofPick.put(horse, 3);
            hoofPickUtils.brush(horse, player);
            return;
        }
        if (brushingUtils.horseTime2.containsKey((Object)horse) && System.currentTimeMillis() >= brushingUtils.horseTime2.get((Object)horse)) {
            horseHoofPick.put(horse, 4);
        }
        switch (horseHoofPick.get((Object)horse)) {
            case 4: {
                horseHoofPick.replace(horse, 3);
                hoofPickUtils.brush(horse, player);
                break;
            }
            case 3: {
                horseHoofPick.replace(horse, 2);
                hoofPickUtils.brush(horse, player);
                break;
            }
            case 2: {
                horseHoofPick.replace(horse, 1);
                hoofPickUtils.brush(horse, player);
                break;
            }
            case 1: {
                horseHoofPick.replace(horse, 0);
                hoofPickUtils.brush(horse, player);
                break;
            }
            case 0: {
                if (!brushingUtils.horseTime2.containsKey((Object)horse)) {
                    brushingUtils.horseTime2.put(horse, System.currentTimeMillis() + 43200000L);
                    hoofPickUtils.brush(horse, player);
                    player.sendMessage(stringUtils.colour("&8&l[&b&lGrooming&8&l] &3You have picked &b&l" + horse.getCustomName() + "&3's hoof"));
                }
                player.sendMessage(stringUtils.colour("&8&l[&b&lGrooming&8&l] &b&l" + horse.getCustomName() + " &3Doesn't need their hooves picked anymore!"));
                break;
            }
            default: {
                player.sendMessage("INVALID");
            }
        }
    }

    public static void brush(Entity horse, Player player) {
        int uses = horseHoofPick.get((Object)horse);
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
                player.sendMessage(stringUtils.colour("&8&l[&b&lGrooming&8&l] &b&l" + horse.getCustomName() + " &3Doesn't need their hooves picked anymore!"));
                break;
            }
            default: {
                Location location1 = horse.getLocation();
                for (double t = 0.0; t <= 7.0; t += 0.5) {
                    world.playEffect(location1, Effect.LARGE_SMOKE, 50);
                }
                player.sendMessage(stringUtils.colour("&8&l[&b&lGrooming&8&l] &3You have picked &b&l" + horse.getCustomName() + "&3's hoof"));
            }
        }
    }
}
