package main.java.me.heraldry;

import main.java.me.heraldry.Misc.combineOres;
import main.java.me.heraldry.Misc.heraldryClickInventory;
import main.java.me.heraldry.Misc.worldGuardClick;
import main.java.me.heraldry.Passwords.Commands.loginCommand;
import main.java.me.heraldry.Passwords.Commands.registerCommand;
import main.java.me.heraldry.Passwords.Commands.resetPlayerCommand;
import main.java.me.heraldry.Passwords.Listeners.playerListeners;
import main.java.me.heraldry.brushingItems.BrushingItemCommand;
import main.java.me.heraldry.texturepacks.Listeners.inventoryClickEvent;
import main.java.me.heraldry.texturepacks.Listeners.playerLogin;
import main.java.me.heraldry.texturepacks.texturepackInventory;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Server;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
extends JavaPlugin {
    public Economy eco;
    private static Main Instance;

    public void onEnable() {
        this.eventRegister(this.getServer().getPluginManager());
        this.commandRegister();
        if (!this.setupEconomy()) {
            this.onDisable();
        }
    }

    public void onDisable() {
    }

    public Main() {
        Instance = this;
    }

    public static Main getInstance() {
        return Instance;
    }

    private boolean setupEconomy() {
        if (this.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider rsp = this.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        this.eco = (Economy)rsp.getProvider();
        return this.eco != null;
    }

    private void eventRegister(PluginManager pm) {
        pm.registerEvents((Listener)new playerLogin(), (Plugin)this);
        pm.registerEvents((Listener)new inventoryClickEvent(), (Plugin)this);
        pm.registerEvents((Listener)new playerListeners(), (Plugin)this);
        pm.registerEvents((Listener)new combineOres(), (Plugin)this);
        pm.registerEvents((Listener)new heraldryClickInventory(), (Plugin)this);
        pm.registerEvents((Listener)new worldGuardClick(), (Plugin)this);
    }

    private void commandRegister() {
        this.getCommand("brushitem").setExecutor((CommandExecutor)new BrushingItemCommand());
        this.getCommand("pack").setExecutor((CommandExecutor)new texturepackInventory());
        this.getCommand("register").setExecutor((CommandExecutor)new registerCommand());
        this.getCommand("login").setExecutor((CommandExecutor)new loginCommand());
        this.getCommand("passwordreset").setExecutor((CommandExecutor)new resetPlayerCommand());
    }
}
