package me.sendpacket.easyguilib;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class gui {
    public gui(String name, String title_prefix)
    {
        this.name = name;
        this.title_prefix = title_prefix;
        reset();
    }

    public void set_main_window(gui_window w)
    {
        this.main_window = w;
        add_window(this.main_window);
    }

    public String get_title_prefix()
    {
        return this.title_prefix;
    }

    public String get_name()
    {
        return this.name;
    }

    public void reset()
    {
        this.window_list.clear();
        player_section_list.clear();
        for(Player p : Bukkit.getOnlinePlayers())
        {
            this.get_player_list().put(p, -1);
        }
    }

    public void close(Player p)
    {
        //this.get_player_list().put(p, -1); // Reset to main menu
        for(gui_window window : get_windows())
        {
            for(gui_item item : window.gui_item_list)
            {
                item.close(p); // Reset sliders and selections
            }
        }
    }

    public ArrayList<gui_window> get_windows()
    {
        return window_list;
    }

    public HashMap<Player, Integer> get_player_list()
    {
        return player_section_list;
    }

    public void add_window(gui_window window)
    {
        window_list.add(window);
    }

    public gui_window get_main_window()
    {
        return this.main_window;
    }

    public gui_window get_window_by_id(int id)
    {
        for(gui_window w : get_windows())
        {
            if(w.get_id() == id)
            {
                return w;
            }
        }
        return null;
    }

    gui_window main_window;
    String name, title_prefix;
    ArrayList<gui_window> window_list = new ArrayList<gui_window>();
    HashMap<Player, Integer> player_section_list = new HashMap<Player, Integer>();
}
