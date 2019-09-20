package com.xgames178.ArcadeLobby.Events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by jpdante on 02/05/2017.
 */
public class onPlayerMove implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Block block = event.getPlayer().getLocation().subtract(0, 1, 0).getBlock();
        if (block.getType() == Material.SOIL) {
            event.setCancelled(true);
            event.getPlayer().teleport(event.getFrom().add(0.5,0.5,0.5));
        }
    }
}
