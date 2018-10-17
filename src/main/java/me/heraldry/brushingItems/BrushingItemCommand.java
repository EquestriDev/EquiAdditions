package main.java.me.heraldry.brushingItems;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import main.java.me.heraldry.Main;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class BrushingItemCommand
implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("brushitem")) {
            if (commandSender instanceof Player) {
                commandSender.sendMessage((Object)ChatColor.AQUA + "You can only run this command from Console.");
                return true;
            }
            if (args == null) {
                return true;
            }
            switch (args.length) {
                case 0: {
                    commandSender.sendMessage((Object)ChatColor.RED + "Correct usage: /brushitem <Player> <Number>");
                    return true;
                }
                case 1: {
                    commandSender.sendMessage((Object)ChatColor.RED + "Correct usage: /brushitem <Player> <Number>");
                    return true;
                }
                case 2: {
                    Player player = Bukkit.getPlayer((String)args[0]);
                    if (player == null) {
                        commandSender.sendMessage((Object)ChatColor.RED + args[0] + " isn't online");
                        return true;
                    }
                    int number = Integer.parseInt(args[1]);
                    if (number > 22) {
                        commandSender.sendMessage((Object)ChatColor.AQUA + String.valueOf(number) + " isn't a correct number");
                        return true;
                    }
                    ItemStack item = this.getItem(Integer.parseInt(args[1]));
                    if (Main.getInstance().eco.getBalance((OfflinePlayer)player) < (double)this.getPrice(number)) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&3Shop \u00bb &fYou need &b$" + this.getPrice(number) + " &fto buy &b1 &fx " + item.getItemMeta().getDisplayName())));
                        return true;
                    }
                    Main.getInstance().eco.withdrawPlayer((OfflinePlayer)player, (double)this.getPrice(number));
                    commandSender.sendMessage((Object)ChatColor.AQUA + args[0] + " has received the item");
                    player.getInventory().addItem(new ItemStack[]{item});
                    player.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)("&3Shop \u00bb &fYou bought &b1 &fx " + item.getItemMeta().getDisplayName() + " &ffor &b$" + this.getPrice(number))));
                    return true;
                }
            }
            commandSender.sendMessage((Object)ChatColor.RED + "Correct usage: /brushitem <Player> <Number>");
            return true;
        }
        return true;
    }

    private ItemStack getItem(int number) {
        int uses;
        ItemStack item = new ItemStack(Material.STONE, 1);
        ItemMeta itemMeta = item.getItemMeta();
        LeatherArmorMeta leatherArmorMeta = null;
        switch (number) {
            case 1: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Clippers");
                item.setType(Material.SHEARS);
                uses = 45;
                break;
            }
            case 2: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Hard Brush");
                item.setType(Material.BLAZE_ROD);
                uses = 45;
                break;
            }
            case 3: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Hoof Pick");
                item.setType(Material.QUARTZ);
                uses = 45;
                break;
            }
            case 4: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Horse Shampoo");
                item.setType(Material.INK_SACK);
                item.setDurability((short)10);
                uses = 15;
                break;
            }
            case 5: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Sweat Scraper");
                item.setType(Material.BLAZE_POWDER);
                uses = 45;
                break;
            }
            case 6: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Curry Comb");
                item.setType(Material.FLINT);
                uses = 45;
                break;
            }
            case 7: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Shedding Blade");
                item.setType(Material.NETHER_BRICK_ITEM);
                uses = 45;
                break;
            }
            case 8: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Mane and Tail comb");
                item.setType(Material.INK_SACK);
                item.setDurability((short)13);
                uses = 45;
                break;
            }
            case 9: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Hoof Oil");
                item.setType(Material.INK_SACK);
                uses = 15;
                break;
            }
            case 10: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Show sheen");
                item.setType(Material.GOLD_NUGGET);
                uses = 15;
                break;
            }
            case 11: {
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Face Brush");
                item.setType(Material.INK_SACK);
                item.setDurability((short)7);
                uses = 45;
                break;
            }
            case 12: {
                item.setType(Material.LEATHER_CHESTPLATE);
                leatherArmorMeta = (LeatherArmorMeta)item.getItemMeta();
                leatherArmorMeta.setDisplayName((Object)ChatColor.AQUA + "White Polo");
                leatherArmorMeta.setColor(Color.fromRGB((int)255, (int)255, (int)255));
                uses = 0;
                break;
            }
            case 13: {
                item.setType(Material.LEATHER_CHESTPLATE);
                leatherArmorMeta = (LeatherArmorMeta)item.getItemMeta();
                leatherArmorMeta.setDisplayName((Object)ChatColor.AQUA + "Navy Polo");
                leatherArmorMeta.setColor(Color.fromRGB((int)20, (int)34, (int)112));
                uses = 0;
                break;
            }
            case 14: {
                item.setType(Material.LEATHER_CHESTPLATE);
                leatherArmorMeta = (LeatherArmorMeta)item.getItemMeta();
                leatherArmorMeta.setDisplayName((Object)ChatColor.AQUA + "Red Polo");
                leatherArmorMeta.setColor(Color.fromRGB((int)171, (int)0, (int)0));
                uses = 0;
                break;
            }
            case 15: {
                item.setType(Material.LEATHER_LEGGINGS);
                leatherArmorMeta = (LeatherArmorMeta)item.getItemMeta();
                leatherArmorMeta.setDisplayName((Object)ChatColor.AQUA + "Beige Breeches");
                leatherArmorMeta.setColor(Color.fromRGB((int)236, (int)209, (int)164));
                uses = 0;
                break;
            }
            case 16: {
                item.setType(Material.LEATHER_LEGGINGS);
                leatherArmorMeta = (LeatherArmorMeta)item.getItemMeta();
                leatherArmorMeta.setDisplayName((Object)ChatColor.AQUA + "White Breeches");
                leatherArmorMeta.setColor(Color.fromRGB((int)255, (int)255, (int)255));
                uses = 0;
                break;
            }
            case 17: {
                item.setType(Material.LEATHER_LEGGINGS);
                leatherArmorMeta = (LeatherArmorMeta)item.getItemMeta();
                leatherArmorMeta.setDisplayName((Object)ChatColor.AQUA + "Navy Breeches");
                leatherArmorMeta.setColor(Color.fromRGB((int)20, (int)34, (int)112));
                uses = 0;
                break;
            }
            case 18: {
                item.setType(Material.LEATHER_BOOTS);
                leatherArmorMeta = (LeatherArmorMeta)item.getItemMeta();
                leatherArmorMeta.setDisplayName((Object)ChatColor.AQUA + "Black Boots");
                leatherArmorMeta.setColor(Color.fromRGB((int)14, (int)14, (int)14));
                uses = 0;
                break;
            }
            case 19: {
                item.setType(Material.LEATHER_BOOTS);
                leatherArmorMeta = (LeatherArmorMeta)item.getItemMeta();
                leatherArmorMeta.setDisplayName((Object)ChatColor.AQUA + "Brown Boots");
                leatherArmorMeta.setColor(Color.fromRGB((int)65, (int)35, (int)4));
                uses = 0;
                break;
            }
            case 20: {
                item.setType(Material.LEATHER_HELMET);
                leatherArmorMeta = (LeatherArmorMeta)item.getItemMeta();
                leatherArmorMeta.setDisplayName((Object)ChatColor.AQUA + "Black Helmet");
                leatherArmorMeta.setColor(Color.fromRGB((int)14, (int)14, (int)14));
                uses = 0;
                break;
            }
            case 21: {
                item.setType(Material.LEATHER_HELMET);
                leatherArmorMeta = (LeatherArmorMeta)item.getItemMeta();
                leatherArmorMeta.setDisplayName((Object)ChatColor.AQUA + "Gray Helmet");
                leatherArmorMeta.setColor(Color.fromRGB((int)66, (int)67, (int)68));
                uses = 0;
                break;
            }
            case 22: {
                item.setType(Material.BUCKET);
                itemMeta.setDisplayName((Object)ChatColor.AQUA + "Bucket");
                uses = 0;
                break;
            }
            default: {
                uses = 45;
            }
        }
        if (leatherArmorMeta == null) {
            if (uses != 0) {
                itemMeta.setLore(Collections.singletonList((Object)ChatColor.DARK_AQUA + "Uses: " + (Object)ChatColor.AQUA + uses));
            }
            item.setItemMeta(itemMeta);
        } else {
            item.setItemMeta((ItemMeta)leatherArmorMeta);
        }
        net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy((ItemStack)item);
        NBTTagCompound tags = nmsItem.getTag();
        if (tags == null) {
            tags = new NBTTagCompound();
        }
        tags.setString("token", String.valueOf(UUID.randomUUID()));
        nmsItem.setTag(tags);
        return CraftItemStack.asBukkitCopy((net.minecraft.server.v1_12_R1.ItemStack)nmsItem);
    }

    private int getPrice(int number) {
        switch (number) {
            case 1: {
                return 140;
            }
            case 2: {
                return 30;
            }
            case 3: {
                return 15;
            }
            case 4: {
                return 45;
            }
            case 5: {
                return 30;
            }
            case 6: {
                return 20;
            }
            case 7: {
                return 30;
            }
            case 8: {
                return 20;
            }
            case 9: {
                return 65;
            }
            case 10: {
                return 30;
            }
            case 11: {
                return 15;
            }
            case 12: {
                return 150;
            }
            case 13: {
                return 150;
            }
            case 14: {
                return 150;
            }
            case 15: {
                return 160;
            }
            case 16: {
                return 160;
            }
            case 17: {
                return 160;
            }
            case 18: {
                return 200;
            }
            case 19: {
                return 200;
            }
            case 20: {
                return 130;
            }
            case 21: {
                return 130;
            }
            case 22: {
                return 10;
            }
        }
        return 0;
    }
}
