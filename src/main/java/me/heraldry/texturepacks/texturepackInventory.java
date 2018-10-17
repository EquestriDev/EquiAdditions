package main.java.me.heraldry.texturepacks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import main.java.me.heraldry.Utils.storageUtils;
import main.java.me.heraldry.Utils.stringUtils;
import main.java.me.heraldry.texturepacks.Configurations.playerDataConfig;
import main.java.me.heraldry.texturepacks.Inventories.InventoryCreation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class texturepackInventory
implements CommandExecutor {
    private InventoryCreation inventoryCreation = new InventoryCreation();

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("pack")) {
            storageUtils storage = new storageUtils();
            Player player = (Player)commandSender;
            Inventory inventory = Bukkit.createInventory((InventoryHolder)player, (int)18, (String)this.inventoryCreation.inventory.getName());
            inventory.setContents(this.inventoryCreation.inventory.getContents());
            String selected = storage.texturepackData.getString(player.getUniqueId().toString());
            for (ItemStack item : inventory.getContents()) {
                if (item == null || item.getItemMeta() == null) continue;
                ItemMeta data = item.getItemMeta();
                if (!data.getDisplayName().contains("None")) {
                    if (player.hasPermission("texturepacks." + ChatColor.stripColor((String)item.getItemMeta().getDisplayName()))) {
                        data.setLore(Collections.singletonList(stringUtils.colour("&a&lClick to enable this Texturepack!")));
                    } else {
                        data.setLore(Arrays.asList(stringUtils.colour("&c&lPurchase this on our store!"), stringUtils.colour("&4store.equestriworlds.net")));
                    }
                } else {
                    data.setLore(Collections.singletonList(stringUtils.colour("&c&lClick to disable your current Texturepack!")));
                }
                if (ChatColor.stripColor((String)item.getItemMeta().getDisplayName().toUpperCase()).equals(selected)) {
                    data.addEnchant(Enchantment.DURABILITY, 1, true);
                    data.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                } else {
                    for (ItemStack itemStack : inventory.getContents()) {
                        if (itemStack == null || !itemStack.getItemMeta().hasEnchants()) continue;
                        for (Enchantment enchantment : itemStack.getItemMeta().getEnchants().keySet()) {
                            itemStack.getItemMeta().removeEnchant(enchantment);
                        }
                    }
                }
                item.setItemMeta(data);
            }
            player.openInventory(inventory);
            player.updateInventory();
            return true;
        }
        return true;
    }
}
