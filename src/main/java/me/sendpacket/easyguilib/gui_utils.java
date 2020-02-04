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
