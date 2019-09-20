package com.xgames178.XCore.Events;

import com.xgames178.XCore.Utils.InternalPlayerCache;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by jpdante on 02/05/2017.
 */
public class onPlayerQuit implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        InternalPlayerCache.playerProfiles.remove(event.getPlayer().getUniqueId());
    }
}
