package me.sendpacket.easyguilib;

import org.bukkit.Material;

public class gui_switch_state {
    public gui_switch_state(String display_name, String lore, Material material)
    {
        this.display_name = display_name;
        this.material = material;
        this.lore = lore;
    }

    public String get_lore()
    {
        return this.lore;
    }

    public String get_display_name()
    {
        return this.display_name;
    }

    public Material get_material()
    {
        return this.material;
    }

    String display_name, lore;
    Material material;
}
