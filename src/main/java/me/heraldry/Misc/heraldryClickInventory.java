package main.java.me.heraldry.Misc;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class heraldryClickInventory
implements Listener {
    @EventHandler
    public void onItemMove(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        Player player = (Player)event.getWhoClicked();
        if (!player.isOp()) return;
        Inventory inventory = event.getClickedInventory();
        int slot = event.getSlot();
        ItemStack current = event.getCurrentItem();
        ItemStack cursor = event.getCursor();
        InventoryAction action = event.getAction();
        if (inventory.getType() != InventoryType.BREWING) {
            return;
        }
        if (action.equals((Object)InventoryAction.MOVE_TO_OTHER_INVENTORY) || action.equals((Object)InventoryAction.PICKUP_HALF)) {
            return;
        }
        event.setCancelled(true);
        if (cursor == null || cursor.getType() == Material.AIR) {
            if (current == null || current.getType() == Material.AIR) {
                return;
            }
            player.setItemOnCursor(current);
            inventory.setItem(slot, null);
        } else if (current.isSimilar(cursor)) {
            current.setAmount(current.getAmount() + cursor.getAmount());
            player.setItemOnCursor(null);
        } else {
            player.setItemOnCursor(current);
            inventory.setItem(slot, cursor);
        }
    }
}
