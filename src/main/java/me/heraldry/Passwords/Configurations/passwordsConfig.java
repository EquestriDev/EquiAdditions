package main.java.me.heraldry.Passwords.Configurations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.MemoryConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;

public class passwordsConfig
extends YamlConfiguration {
    File file = new File("./plugins/EquiAdditions/passwords.yml");

    public passwordsConfig() {
        if (!this.file.exists()) {
            this.save(this.file);
        }
        try {
            this.load(this.file);
        }
        catch (FileNotFoundException fileNotFoundException) {
        }
        catch (IOException | InvalidConfigurationException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Cannot load " + this.file, ex);
        }
    }

    public void save() {
        this.save(this.file);
    }

    public void save(File file) {
        try {
            super.save(this.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
