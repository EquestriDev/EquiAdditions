/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Donkey
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Horse
 */
package main.java.me.heraldry.Utils;

import org.bukkit.entity.Donkey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;

public class crosstiesUtils {
    public static void leave(Entity entity) {
        switch (entity.getType()) {
            case HORSE: {
                Horse horse = (Horse)entity;
                horse.setCollidable(true);
                horse.setAI(true);
                horse.setLeashHolder(null);
                break;
            }
            case DONKEY: {
                Donkey donkey = (Donkey)entity;
                donkey.setCollidable(true);
                donkey.setAI(true);
                donkey.setLeashHolder(null);
            }
        }
    }

}