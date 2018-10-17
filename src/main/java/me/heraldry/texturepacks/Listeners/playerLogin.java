package main.java.me.heraldry.texturepacks.Listeners;

import java.util.UUID;
import main.java.me.heraldry.Utils.storageUtils;
import main.java.me.heraldry.Utils.texturepacksUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerLogin
implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        storageUtils storage = new storageUtils();
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();
        try {
            if (storage.getString("Texturepack", uuid).equals("NONE")) {
                return;
            }
        }
        catch (NullPointerException e) {
            storage.setString("Texturepack", uuid, "NONE");
        }
        texturepacksUtils.setResourcepack(player, storage.getString("Texturepack", uuid));
    }
}
