package main.java.me.heraldry.texturepacks.Inventories;

import main.java.me.heraldry.Utils.stringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Create chest GUI for texturepackInventory
 */
public class InventoryCreation {
    public Inventory inventory;

    public InventoryCreation() {
        Inventory inventory = Bukkit.createInventory(null, (int)18, (String)stringUtils.colour(" &b&lDonator Texturepacks"));
        ItemStack BlackSP = new ItemStack(Material.SADDLE, 1);
        ItemMeta BlackSPData = BlackSP.getItemMeta();
        BlackSPData.setDisplayName(stringUtils.colour("&8&lBlackSP"));
        BlackSP.setItemMeta(BlackSPData);
        ItemStack BlueSP = new ItemStack(Material.SADDLE, 1);
        ItemMeta BlueSPData = BlueSP.getItemMeta();
        BlueSPData.setDisplayName(stringUtils.colour("&b&lBlueSP"));
        BlueSP.setItemMeta(BlueSPData);
        ItemStack GoldSP = new ItemStack(Material.SADDLE, 1);
        ItemMeta GoldSPData = GoldSP.getItemMeta();
        GoldSPData.setDisplayName(stringUtils.colour("&6&lGoldSP"));
        GoldSP.setItemMeta(GoldSPData);
        ItemStack IvorySP = new ItemStack(Material.SADDLE, 1);
        ItemMeta IvorySPData = IvorySP.getItemMeta();
        IvorySPData.setDisplayName(stringUtils.colour("&f&lIvorySP"));
        IvorySP.setItemMeta(IvorySPData);
        ItemStack MangoSP = new ItemStack(Material.SADDLE, 1);
        ItemMeta MangoSPData = IvorySP.getItemMeta();
        MangoSPData.setDisplayName(stringUtils.colour("&6&lMangoSP"));
        MangoSP.setItemMeta(MangoSPData);
        ItemStack NavySP = new ItemStack(Material.SADDLE, 1);
        ItemMeta NavySPData = NavySP.getItemMeta();
        NavySPData.setDisplayName(stringUtils.colour("&9&lNavySP"));
        NavySP.setItemMeta(NavySPData);
        ItemStack PeriwinkleSP = new ItemStack(Material.SADDLE, 1);
        ItemMeta PeriwinkleSPData = PeriwinkleSP.getItemMeta();
        PeriwinkleSPData.setDisplayName(stringUtils.colour("&5&lPeriwinkleSP"));
        PeriwinkleSP.setItemMeta(PeriwinkleSPData);
        ItemStack PinkSP = new ItemStack(Material.SADDLE, 1);
        ItemMeta PinkSPData = PinkSP.getItemMeta();
        PinkSPData.setDisplayName(stringUtils.colour("&d&lPinkSP"));
        PinkSP.setItemMeta(PinkSPData);
        ItemStack PlaidSP = new ItemStack(Material.SADDLE, 1);
        ItemMeta PlaidSPData = PlaidSP.getItemMeta();
        PlaidSPData.setDisplayName(stringUtils.colour("&e&lPlaidSP"));
        PlaidSP.setItemMeta(PlaidSPData);
        ItemStack RoseSP = new ItemStack(Material.SADDLE, 1);
        ItemMeta RoseSPData = RoseSP.getItemMeta();
        RoseSPData.setDisplayName(stringUtils.colour("&4&lRoseSP"));
        RoseSP.setItemMeta(RoseSPData);
        ItemStack SummerSP = new ItemStack(Material.SADDLE, 1);
        ItemMeta SummerSPData = SummerSP.getItemMeta();
        SummerSPData.setDisplayName(stringUtils.colour("&6&lSummerSP"));
        SummerSP.setItemMeta(SummerSPData);
        ItemStack None = new ItemStack(Material.BARRIER, 1);
        ItemMeta NoneData = None.getItemMeta();
        NoneData.setDisplayName(stringUtils.colour("&8&lNone"));
        None.setItemMeta(NoneData);
        inventory.setItem(0, BlackSP);
        inventory.setItem(1, BlueSP);
        inventory.setItem(2, GoldSP);
        inventory.setItem(3, IvorySP);
        inventory.setItem(4, MangoSP);
        inventory.setItem(5, NavySP);
        inventory.setItem(6, PeriwinkleSP);
        inventory.setItem(7, PinkSP);
        inventory.setItem(8, PlaidSP);
        inventory.setItem(9, RoseSP);
        inventory.setItem(17, SummerSP);
        inventory.setItem(13, None);
        this.inventory = inventory;
    }
}
