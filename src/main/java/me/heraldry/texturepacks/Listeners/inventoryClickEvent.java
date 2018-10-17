package main.java.me.heraldry.texturepacks.Listeners;

import java.util.List;
import java.util.UUID;
import main.java.me.heraldry.Utils.storageUtils;
import main.java.me.heraldry.Utils.stringUtils;
import main.java.me.heraldry.Utils.texturepacksUtils;
import main.java.me.heraldry.texturepacks.Inventories.InventoryCreation;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class inventoryClickEvent
implements Listener {
    private storageUtils storage = new storageUtils();
    private InventoryCreation inventoryCreation = new InventoryCreation();

    @EventHandler
    public void click(InventoryClickEvent event) {
        if (event.getInventory().getName().equals(this.inventoryCreation.inventory.getName())) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }
            if (!(event.getWhoClicked() instanceof Player)) {
                return;
            }
            Player player = (Player)event.getWhoClicked();
            Inventory inventory = event.getInventory();
            ItemStack item = inventory.getItem(event.getSlot());
            ItemMeta data = item.getItemMeta();
            if (((String)item.getItemMeta().getLore().get(0)).contains("Purchase")) {
                player.sendMessage(stringUtils.colour("&8&l[&b&lTexturepacks&8&l] &cYou are unable to select " + inventory.getItem(event.getSlot()).getItemMeta().getDisplayName()));
                return;
            }
            for (ItemStack itemStack : inventory.getContents()) {
                if (itemStack == null || !itemStack.getItemMeta().hasEnchants()) continue;
                itemStack.removeEnchantment(Enchantment.DURABILITY);
            }
            data.addEnchant(Enchantment.DURABILITY, 1, true);
            data.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
            item.setItemMeta(data);
            inventory.setItem(event.getSlot(), item);
            this.storage.setString("Texturepack", player.getUniqueId().toString(), ChatColor.stripColor((String)inventory.getItem(event.getSlot()).getItemMeta().getDisplayName().toUpperCase()));
            player.sendMessage(stringUtils.colour("&8&l[&b&lTexturepacks&8&l] &3You have selected " + inventory.getItem(event.getSlot()).getItemMeta().getDisplayName()));
            texturepacksUtils.setResourcepack(player, ChatColor.stripColor((String)inventory.getItem(event.getSlot()).getItemMeta().getDisplayName().toUpperCase()));
        }
    }
}
