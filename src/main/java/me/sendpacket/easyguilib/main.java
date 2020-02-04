package me.sendpacket.easyguilib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getServer().getLogger().info("[EzGUILib] Loaded.");
    }
}
