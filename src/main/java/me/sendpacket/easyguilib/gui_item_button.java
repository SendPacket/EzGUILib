package me.sendpacket.easyguilib;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class gui_item_button extends gui_item {
    public gui_item_button(String id, String display_name, String lore, int slot, Material material) // BUTTON
    {
        this.id = id;
        this.lore = lore;
        this.display_name = display_name;
        this.type = gui_item_type.button;
        this.material = material;
        this.slot = slot;

        for(Player p : Bukkit.getOnlinePlayers())
        {
            this.pressed.put(p, 0);
        }

        this.type = gui_item_type.button;
    }

    public void perform_action(Player p, int click_type)
    {
        this.pressed.put(p, click_type);
    }
}
