package me.sendpacket.easyguilib;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class gui_utils {
    public static void update_inventory(Player p, Inventory inv)
    {
        p.closeInventory();
        p.openInventory(inv);
    }

    public static void open_gui(Player p, String name)
    {
        for(gui g : gui_values.gui_list) {
            if (g.get_name().equalsIgnoreCase(name)) {
                update_inventory(p,g.get_main_window().get_inventory());
                g.get_player_list().put(p, 0);
            }
        }
    }

    public static void jump_to_window(Player p,int id)
    {
        for(gui g : gui_values.gui_list)
        {
            if(g.get_player_list().get(p) >= 0)
            {
                g.get_player_list().put(p, id);
                update_inventory(p, g.get_window_by_id(id).get_inventory());
            }
        }
    }
}
