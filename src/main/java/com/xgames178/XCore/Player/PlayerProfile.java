package com.xgames178.XCore.Player;

import com.xgames178.XCore.Database.Callback;
import com.xgames178.XCore.Database.Tasks.LoadProfileTask;
import com.xgames178.XCore.XCore;
import org.bukkit.entity.Player;

/**
 * Created by jpdante on 02/05/2017.
 */
public class PlayerProfile {
    public ProfileData profileData = null;
    public Player player;

    public PlayerProfile(Player playerclass) {
        player = playerclass;
        XCore.getInstance().getDataManager().addTask(new LoadProfileTask(player.getUniqueId(), new Callback<ProfileData>() {
            @Override
            public void onComplete(ProfileData pD) {
                profileData = pD;
            }
        }));
    }
}
