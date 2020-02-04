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
        this.inventory = Bukkit.createInventory(null, size, this.parent.get_title_prefix() + " " + this.name);
        gui_item_list = new ArrayList<gui_item>();
    }

    public Inventory get_inventory()
    {
        return this.inventory;
    }

    public ArrayList<gui_item> get_items()
    {
        return this.gui_item_list;
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

    Inventory inventory;
    ArrayList<gui_item> gui_item_list;
    String name;
    gui parent;
    int size, id;
}
