package me.sendpacket.easyguilib;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class gui_item_selection extends gui_item {
    public gui_item_selection(String id, String display_name, String lore, int slot, Material material, String[] selection_items) // SELECTION
    {
        this.id = id;
        this.lore = lore;
        this.display_name = display_name;
        this.type = gui_item_type.selection;
        this.material = material;
        this.slot = slot;

        this.items_to_select = selection_items;

        this.type = gui_item_type.selection;
    }

    public void perform_action(Player p, int click_type)
    {

    }

    String[] items_to_select;
    public String[] get_selection_items() { return items_to_select; }
}
