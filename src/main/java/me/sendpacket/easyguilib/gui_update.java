package me.sendpacket.easyguilib;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class gui_update implements Listener {

    @EventHandler
    public static void on_inventory_click(InventoryClickEvent e)
    {
        if (e.getWhoClicked() instanceof Player)
        {
            Player player = (Player) e.getWhoClicked();
            Inventory inventory = e.getInventory();
            int slot = e.getSlot();

            for(gui ui : gui_values.gui_list)
            {
                for(gui_window window : ui.get_windows())
                {
                    if (e.getView().getTitle().equalsIgnoreCase(window.get_title())) // Is in valid window
                    {
                        for(gui_item item : window.get_items())
                        {
                            if(slot == item.get_slot())
                            {
                                item.perform_action(player);
                            }
                        }
                        gui_utils.update_inventory(player, window.get_inventory()); // Update inventory
                        e.setCancelled(true); // Cancel event so that items can't be taken out
                    }
                }
            }
        }
    }

    @EventHandler
    public static void on_inventory_close(InventoryCloseEvent e)
    {
        if (e.getPlayer() instanceof  Player)
        {
            Player player = (Player) e.getPlayer();
            for(gui ui : gui_values.gui_list)
            {
                ui.close(player);
            }
        }
    }
}
