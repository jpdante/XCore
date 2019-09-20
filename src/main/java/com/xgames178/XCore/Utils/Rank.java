package com.xgames178.XCore.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by jpdante on 03/05/2017.
 */
public enum Rank {
    OWNER("Dono", ChatColor.DARK_RED),
    DEVELOPER("Dev", ChatColor.GOLD),
    ADMIN("Admin", ChatColor.RED),
    MODERATOR("Mod", ChatColor.GREEN),
    HELPER("Helper", ChatColor.DARK_AQUA),
    MAPDEV("Builder", ChatColor.DARK_GREEN),
    VIP("Vip", ChatColor.GREEN),
    VIPPLUS("Vip+", ChatColor.GREEN),
    MVP("MVP", ChatColor.AQUA),
    NONE("", ChatColor.GRAY);
    private ChatColor Color;
    public String Name;
    Rank(String name, ChatColor color) {
        Color = color;
        Name = name;
    }
    public String GetTag(boolean bold, boolean uppercase) {
        if (Name.equalsIgnoreCase("ALL"))
            return "";

        String name = Name;
        if (uppercase)
            name = Name.toUpperCase();

        if (bold)			return Color + C.Bold + name;
        else				return Color + name;
    }
    public ChatColor GetColor()
    {
        return Color;
    }
}