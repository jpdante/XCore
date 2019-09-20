package com.xgames178.SkyFall.Game;

import com.xgames178.XCore.Game.Kit;
import com.xgames178.XCore.Game.KitAvailability;
import com.xgames178.XCore.GameManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by jpdante on 08/05/2017.
 */
public class DefaultKit extends Kit {

    public DefaultKit(GameManager gameManager) {
        super(gameManager, "SkyFallGame Kit", KitAvailability.Free, new String[] {"Default SkyFallGame Kit"}, 0, new ItemStack(Material.LEATHER_BOOTS));
    }

    @Override
    public void GiveItems(Player player) {
    }
}
