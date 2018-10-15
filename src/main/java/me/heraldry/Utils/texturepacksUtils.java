/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package main.java.me.heraldry.Utils;

import java.io.PrintStream;
import org.bukkit.entity.Player;

public class texturepacksUtils {
    public static void setResourcepack(Player player, String texture) {
        switch (texture) {
            case "BLACKSP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/BlackSP%20Pack.zip");
                break;
            }
            case "BLUESP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/BlueSP%20Pack.zip");
                break;
            }
            case "GOLDSP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/GoldSP%20Pack.zip");
                break;
            }
            case "IVORYSP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/IvorySP%20Pack.zip");
                break;
            }
            case "MANGOSP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/MangoSP%20Pack.zip");
                break;
            }
            case "NAVYSP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/NavySP%20Pack.zip");
                break;
            }
            case "PERIWINKLESP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/PeriwinkleSP%20Pack.zip");
                break;
            }
            case "PINKSP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/PinkSP%20Pack.zip");
                break;
            }
            case "PLAIDSP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/PlaidSP%20Pack.zip");
                break;
            }
            case "ROSESP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/RoseSP%20Pack.zip");
                break;
            }
            case "SUMMERSP": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/SummerSP%20Pack.zip");
                break;
            }
            case "NONE": {
                player.setResourcePack("http://www.equestriworlds.net/resourcepacks/Empty.zip");
                break;
            }
            default: {
                System.out.print(player.getName() + " Has an invalid file: " + texture);
            }
        }
    }
}
