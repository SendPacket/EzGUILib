package me.sendpacket.easyguilib;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class gui_item_toggle extends gui_item {
    public gui_item_toggle(String id, String display_name, String lore, int slot, Material material, boolean default_state) // TOGGLE
    {
        this.id = id;
        this.lore = lore;
        this.display_name = display_name;
        this.type = gui_item_type.toggle;
        this.material = material;
        this.slot = slot;

        this.toggled = default_state;

        this.type = gui_item_type.toggle;
    }

    public void perform_action(Player p, int click_type)
    {
        this.toggled = !this.toggled;
    }

    boolean toggled;
    public boolean is_toggled() { return toggled; }
}
