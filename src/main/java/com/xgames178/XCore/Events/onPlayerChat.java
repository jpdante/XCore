package com.xgames178.XCore.Events;

import com.xgames178.XCore.Player.PlayerProfile;
import com.xgames178.XCore.Utils.InternalPlayerCache;
import com.xgames178.XCore.Utils.Rank;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by jpdante on 02/05/2017.
 */
public class onPlayerChat implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setMessage(event.getMessage().replace("%", ""));
        PlayerProfile profile = InternalPlayerCache.playerProfiles.get(event.getPlayer().getUniqueId());
        if(profile.profileData.rank == Rank.NONE) {
            event.setFormat(profile.profileData.rank.GetColor() + event.getPlayer().getName() + " §7›› " + profile.profileData.rank.GetColor() + event.getMessage());
        } else {
            event.setFormat(profile.profileData.rank.GetColor() + "[" + profile.profileData.rank.GetTag(false, true) + "] "
                    + event.getPlayer().getName() + " §7›› " + profile.profileData.rank.GetColor() + event.getMessage().replace("&", "§"));
        }
    }

}
