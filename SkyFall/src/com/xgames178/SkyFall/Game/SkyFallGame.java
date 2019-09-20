package com.xgames178.SkyFall.Game;

import com.xgames178.XCore.Game.Game;
import com.xgames178.XCore.Game.Kit;
import com.xgames178.XCore.GameManager;
import com.xgames178.XCore.Utils.NautHashMap;
import org.bukkit.entity.Player;
import javax.xml.stream.Location;
import java.util.ArrayList;

/**
 * Created by jpdante on 08/05/2017.
 */
public class SkyFallGame extends Game {

    ArrayList<Location> _locations = new ArrayList<>();
    NautHashMap<Player, PlayerStage> _player_stage = new NautHashMap<>();

    public SkyFallGame(GameManager gameManager) {
        super(gameManager, "SkyFallGame", new String[]{"Avoid obstacles while falling,", "Not die"}, new Kit[] {new DefaultKit(gameManager)});
    }

}
