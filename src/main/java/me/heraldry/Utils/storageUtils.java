package main.java.me.heraldry.Utils;

import main.java.me.heraldry.Passwords.Configurations.passwordsConfig;
import main.java.me.heraldry.texturepacks.Configurations.playerDataConfig;

public class storageUtils {
    public playerDataConfig texturepackData = new playerDataConfig();
    private passwordsConfig passwords = new passwordsConfig();

    public void setString(String file, String path, String string) {
        switch (file) {
            case "Texturepack": {
                this.texturepackData.set(path, (Object)string);
                this.texturepackData.save();
                break;
            }
            case "passwords": {
                this.passwords.set(path, (Object)string);
                this.passwords.save();
            }
        }
    }

    public String getString(String file, String path) {
        switch (file) {
            case "Texturepack": {
                return this.texturepackData.getString(path);
            }
            case "passwords": {
                return this.passwords.getString(path);
            }
        }
        return null;
    }

    public boolean getBoolean(String file, String path) {
        switch (file) {
            case "Texturepack": {
                return this.texturepackData.getBoolean(path);
            }
        }
        return false;
    }

    public void setBoolean(String file, String path, boolean value) {
        switch (file) {
            case "Texturepack": {
                this.texturepackData.set(path, (Object)value);
                this.texturepackData.save();
                break;
            }
        }
    }
}
