package me.sendpacket.easyguilib;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class gui_window {
    public gui_window(String name, int id, int size, gui parent)
    {
        this.name = name;
        this.size = size;
        this.parent = parent;
        this.title = this.parent.get_title_prefix() + " " + this.name;
        this.inventory = Bukkit.createInventory(null, size, this.title);
        this.id = id;
        gui_item_list = new ArrayList<gui_item>();
    }

    public Inventory get_inventory()
    {
        generate_inventory();
        return this.inventory;
    }

    public ArrayList<gui_item> get_items()
    {
        return this.gui_item_list;
    }

    public String get_title()
    {
        return this.title;
    }

    public String get_name()
    {
        return this.name;
    }

    public int get_size()
    {
        return this.size;
    }

    public int get_id()
    {
        return this.id;
    }

    public void clear()
    {
        this.gui_item_list.clear();
    }

    public void generate_inventory() {
        this.inventory = Bukkit.createInventory(null, size, this.parent.get_title_prefix() + " " + this.name);

        for (gui_item item : gui_item_list) {
            this.inventory.setItem(item.slot, gui_utils.create_inventory_item(item.material, item.get_display_name(), item.get_lore()));
        }
    }

    Inventory inventory;
    ArrayList<gui_item> gui_item_list;
    String name, title;
    gui parent;
    int size, id;
}
