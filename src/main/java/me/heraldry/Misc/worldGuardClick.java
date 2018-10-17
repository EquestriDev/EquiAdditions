package main.java.me.heraldry.Misc;

import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

/**
 * Protects region "kellourco" from hopper access for some reason.
 */
public class worldGuardClick
implements Listener {
    @EventHandler
    public void onItemMove(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        Player player = (Player)event.getWhoClicked();
        WorldGuardPlugin plugin = this.getWorldGuard();
        if (plugin == null) {
            return;
        }
        if (event.getInventory().getType() != InventoryType.HOPPER && event.getInventory().getType() != InventoryType.SHULKER_BOX) {
            return;
        }
        ProtectedRegion region = this.getWorldGuard().getRegionManager(player.getWorld()).getRegion("kellourco");
        if (region == null) {
            return;
        }
        if (!region.isMember(plugin.wrapPlayer(player))) {
            event.setCancelled(true);
        }
    }

    private WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            return null;
        }
        return (WorldGuardPlugin)plugin;
    }
}
