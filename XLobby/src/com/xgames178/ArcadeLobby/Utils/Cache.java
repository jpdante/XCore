package com.xgames178.ArcadeLobby.Utils;

import com.xgames178.ArcadeLobby.Player.PlayerProfile;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created by jpdante on 02/05/2017.
 */
public class Cache {
    public static HashMap<Player, PlayerProfile> profiles;

    public Cache() {
        profiles = new HashMap<>();
    }
}
