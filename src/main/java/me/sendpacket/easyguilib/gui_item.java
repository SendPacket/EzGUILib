package me.sendpacket.easyguilib;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class gui_item {
    public gui_item(String id, int slot, HashMap<Integer,gui_switch_state> switch_list, int default_switch_state) // SWITCH_BUTTON
    {
        this.id = id;
        this.type = gui_item_type.switch_button;
        this.slot = slot;

        this.current_switch_state = default_switch_state;
        this.material = get_switch_list().get(this.current_switch_state).material;
        this.display_name = get_switch_list().get(this.current_switch_state).display_name;
        this.lore = get_switch_list().get(this.current_switch_state).lore;
        this.switch_list = switch_list;
    }
    public gui_item(String id, String display_name, String lore, int slot, Material material) // BUTTON
    {
        this.id = id;
        this.lore = lore;
        this.display_name = display_name;
        this.type = gui_item_type.button;
        this.material = material;
        this.slot = slot;

        this.pressed = false;
    }
    public gui_item(String id, String display_name, String lore, int slot, Material material, int min, int max) // SLIDER
    {
        this.id = id;
        this.lore = lore;
        this.display_name = display_name;
        this.type = gui_item_type.slider;
        this.material = material;
        this.slot = slot;

        this.min = min;
        this.max = max;
    }
    public gui_item(String id, String display_name, String lore, int slot, Material material, boolean default_state) // TOGGLE
    {
        this.id = id;
        this.lore = lore;
        this.display_name = display_name;
        this.type = gui_item_type.toggle;
        this.material = material;
        this.slot = slot;

        this.toggled = default_state;
    }
    public gui_item(String id, String display_name, String lore, int slot, Material material, String[] selection_items) // SELECTION
    {
        this.id = id;
        this.lore = lore;
        this.display_name = display_name;
        this.type = gui_item_type.selection;
        this.material = material;
        this.slot = slot;

        this.items_to_select = selection_items;
    }

    public void perform_action(Player p)
    {
        switch(this.get_type())
        {
            case switch_button:
                if(this.current_switch_state < get_switch_list().size())
                {
                    this.current_switch_state += 1;
                }else{
                    this.current_switch_state = 0;
                }
                this.material = get_switch_list().get(this.current_switch_state).material;
                this.display_name = get_switch_list().get(this.current_switch_state).display_name;
                this.lore = get_switch_list().get(this.current_switch_state).lore;
                break;
            case button: // Button input should be handled elsewhere
                this.pressed = true;
                break;
            case slider: // TODO
                break;
            case selection: // TODO
                break;
            case toggle:
                this.toggled = !this.toggled;
                break;
        }
    }

    public int get_slot()
    {
        return this.slot;
    }

    public Material get_material()
    {
        return this.material;
    }

    public String get_lore()
    {
        return this.lore;
    }

    public String get_id()
    {
        return id;
    }

    public gui_item_type get_type()
    {
        return type;
    }

    public void close(Player p)
    {
        get_state_list().put(p, 0);
    }

    public HashMap<Player, Integer> get_state_list()
    {
        return player_state_list;
    }

    ///////////////////////// Switch_Button
    HashMap<Integer,gui_switch_state> switch_list;
    int current_switch_state;
    public int get_current_switch_state() { return current_switch_state; }
    public HashMap<Integer, gui_switch_state> get_switch_list() { return switch_list; }
    ///////////////////////// Button
    boolean pressed;
    public boolean is_pressed() { boolean old_pressed = pressed; pressed = false; return old_pressed;} // Once called, not pressed
    ///////////////////////// Slider
    int min, max;
    public int get_min() { return this.min; }
    public int get_max() { return this.max; }
    ///////////////////////// Selection
    String[] items_to_select;
    public String[] get_selection_items() { return items_to_select; }
    ///////////////////////// Toggle
    boolean toggled;
    public boolean is_toggled() { return toggled; }
    /////////////////////////


    String id, display_name, lore;
    int slot;
    Material material;
    gui_item_type type;
    HashMap<Player, Integer> player_state_list = new HashMap<Player, Integer>();
}
