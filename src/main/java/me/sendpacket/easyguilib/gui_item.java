package me.sendpacket.easyguilib;

import me.sendpacket.easyguilib.gui_item_type;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashMap;

public abstract class gui_item {

    String id, display_name, lore;
    int slot;
    Material material;
    gui_item_type type;

    HashMap<Player,Integer> pressed = new HashMap<Player, Integer>();

    public abstract void perform_action(Player p, int click_type);

    public int get_slot() { return this.slot; }

    public Material get_material() { return this.material; }

    public String get_display_name() { return this.display_name; }

    public String get_lore() { return this.lore; }

    public String get_id() { return this.id; }

    public gui_item_type get_type() { return this.type; }

    public int pressed_value(Player p) { return this.pressed.get(p);} // Once called, not pressed
    public void not_pressed(Player p){this.pressed.put(p, 0); };

}
