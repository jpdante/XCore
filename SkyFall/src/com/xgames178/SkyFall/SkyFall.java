package com.xgames178.SkyFall;

import com.xgames178.SkyFall.Game.SkyFallGame;
import com.xgames178.XCore.Game.Game;
import com.xgames178.XCore.Game.GameServerConfig;
import com.xgames178.XCore.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by jpdante on 08/05/2017.
 */
public class SkyFall extends JavaPlugin {

    private GameManager gameManager;

    @Override
    public void onEnable() {
        gameManager = new GameManager(this, getGameServerConfig());
        Game game = new SkyFallGame(gameManager);
        gameManager.SetGame(game);
        this.getServer().getPluginManager().registerEvents(game, this);
    }

    public GameServerConfig getGameServerConfig() {
        GameServerConfig gameServerConfig = new GameServerConfig();
        gameServerConfig.MaxPlayers = 16;
        gameServerConfig.MinPlayers = 4;
        gameServerConfig.HostName = "SkyFallGame";
        return gameServerConfig;
    }

    @Override
    public void onDisable() {

    }
}
