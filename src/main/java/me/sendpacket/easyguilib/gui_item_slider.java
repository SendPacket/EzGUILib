package me.sendpacket.easyguilib;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class gui_item_slider extends gui_item {
    public gui_item_slider(String id, String display_name, String lore, int slot, Material material, int min, int max) // SLIDER
    {
        this.id = id;
        this.lore = lore;
        this.display_name = display_name;
        this.type = gui_item_type.slider;
        this.material = material;
        this.slot = slot;

        this.min = min;
        this.max = max;

        this.type = gui_item_type.slider;
    }

    public void perform_action(Player p, int click_type)
    {

    }

    int min, max;
    public int get_min() { return this.min; }
    public int get_max() { return this.max; }
}
