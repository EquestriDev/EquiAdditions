package main.java.me.heraldry.Misc;

import java.util.HashMap;
import main.java.me.heraldry.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class combineOres
implements Listener {
    @EventHandler
    public void onItemMove(final InventoryMoveItemEvent event) {
        if (event.getItem().getType() != Material.DIAMOND_ORE) {
            return;
        }
        new BukkitRunnable(){

            public void run() {
                for (ItemStack itemStack : event.getDestination().getContents()) {
                    if (!itemStack.getType().equals((Object)event.getItem().getType()) || !itemStack.getType().equals((Object)Material.DIAMOND_ORE) || itemStack.getAmount() < 9) continue;
                    event.getDestination().remove(itemStack);
                    event.getDestination().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK, 1)});
                }
            }
        }.runTaskAsynchronously((Plugin)Main.getInstance());
    }

}
