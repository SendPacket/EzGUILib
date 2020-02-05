package me.sendpacket.easyguilib;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class gui_item_returnbutton extends gui_item {
    public gui_item_returnbutton(String id, String display_name, String lore, int slot, int window_id_to_return) // RETURN BUTTON
    {
        this.id = id;
        this.lore = lore;
        this.display_name = display_name;
        this.type = gui_item_type.button;
        this.material = Material.RED_STAINED_GLASS_PANE;
        this.slot = slot;

        for(Player p : Bukkit.getOnlinePlayers())
        {
            this.pressed.put(p, 0);
        }

        this.type = gui_item_type.return_button;
    }

    public void perform_action(Player p, int click_type)
    {
        this.pressed.put(p, click_type);
    }

    int window_id_to_return;
    public int get_window_id_to_return(){return window_id_to_return;};
}
