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
    }

    public ArrayList<gui_window> get_windows()
    {
        return window_list;
    }

    public void add_window(gui_window window)
    {
        window_list.add(window);
    }

    public gui_window get_main_window()
    {
        return this.main_window;
    }

    gui_window main_window;
    String name, title_prefix;
    ArrayList<gui_window> window_list = new ArrayList<gui_window>();
}
