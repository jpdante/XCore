package com.xgames178.XCore;

import com.xgames178.XCore.Database.DataManager;
import com.xgames178.XCore.Database.DataProvider;
import com.xgames178.XCore.Database.Database;
import com.xgames178.XCore.Database.Mysql.MySQL;
import com.xgames178.XCore.Database.Sqlite.SQLite;
import com.xgames178.XCore.Events.onPlayerChat;
import com.xgames178.XCore.Events.onPlayerCommandPreprocess;
import com.xgames178.XCore.Events.onPlayerJoin;
import com.xgames178.XCore.Events.onPlayerQuit;
import com.xgames178.XCore.Memory.MemoryFix;
import com.xgames178.XCore.Monitor.LagMeter;
import com.xgames178.XCore.Updater.Updater;
import com.xgames178.XCore.Utils.InternalPlayerCache;
import com.xgames178.XCore.Utils.UtilCache;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.sql.SQLException;

/**
 * Created by jpdante on 06/05/2017.
 */
public class XCore extends JavaPlugin {
    private static XCore instance;
    private static Plugin plugin;
    private static UtilCache cache;
    private static Database database;
    private static DataProvider defaultDataProvider;
    private static DataManager dataManager;

    @Override
    public void onEnable() {
        plugin = this;
        instance = this;
        Bukkit.getServer().setWhitelist(true);
        saveDefaultConfig();
        reloadConfig();
        if(getConfig().getBoolean("database.needed")) {
            if(getConfig().getString("database.type").equalsIgnoreCase("mysql")) {
                String host = getConfig().getString("database.host");
                String port = getConfig().getString("database.port");
                String dbname = getConfig().getString("database.database");
                String username = getConfig().getString("database.username");
                String password = getConfig().getString("database.password");
                database = new MySQL(host, port, dbname, username, password);
            } else {
                database = new SQLite(getConfig().getString("database.sqlite_filename"));
            }
            try {
                database.openConnection();
            } catch (SQLException  ClassNotFoundException e) {
                e.printStackTrace();
                Bukkit.shutdown();
            }
            defaultDataProvider = new DataProvider(database);
            dataManager = new DataManager(defaultDataProvider);
        }
        new Updater(instance);
        new InternalPlayerCache();
        cache = new UtilCache();
        Bukkit.getServer().getPluginManager().registerEvents(new onPlayerJoin(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new onPlayerQuit(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new onPlayerChat(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new onPlayerCommandPreprocess(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new LagMeter(instance), plugin);
        if(getConfig().getBoolean("memory_fixer.needed")) {
            MemoryFix.last_failed = false;
            MemoryFix.min_memory = getConfig().getLong("memory_fixer.min_memory");
            Bukkit.getServer().getPluginManager().registerEvents(new MemoryFix(), plugin);
        }
        Bukkit.getServer().setWhitelist(false);
    }

    @Override
    public void onDisable() {
        dataManager.shutdown();
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static XCore getInstance() {
        return instance;
    }

    public static UtilCache getCache() {
        return cache;
    }

    public DataProvider getDefaultDataProvider() {
        return defaultDataProvider;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public Database getDatabaseIO() {
        return database;
    }
}
