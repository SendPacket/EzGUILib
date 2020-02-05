package me.sendpacket.easyguilib;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class gui_utils {
    public static void update_inventory(Player p, Inventory inv)
    {
        p.closeInventory();
        p.openInventory(inv);
    }

    public static gui_window get_window_by_id(gui g, int id)
    {
        for(gui_window w : g.get_windows())
        {
            if(w.get_id() == id)
            {
                return w;
            }
        }
        return null;
    }

    public static void open_gui(Player p, String name)
    {
        for(gui g : gui_values.gui_list) {
            if (g.get_name().equalsIgnoreCase(name)) {
                update_inventory(p,g.get_main_window().get_inventory());
            }
        }
    }

    public static void jump_to_window(Player p, gui g,int id) {
        gui_window w = get_window_by_id(g, id);
        if (w != null) {
            update_inventory(p, w.get_inventory());
        }
    }

    public static ItemStack create_inventory_item(Material material, String name, String...lore) {
        ItemStack item = new ItemStack(material, 1); // We initialize the variable
        ItemMeta meta = item.getItemMeta(); // We initialize the variable
        meta.setDisplayName(name); // We change the name of the item
        ArrayList<String> metaLore = new ArrayList<String>(); // We create arraylist for the lore
        for(String loreComments : lore) {
            metaLore.add(loreComments); // We add the lore to the arraylist
        }
        meta.setLore(metaLore); // We set the lore
        item.setItemMeta(meta); // We set the meta
        return item; // We return the create item
    }
}
