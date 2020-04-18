package ml.peya.plugins.Events;

import ml.peya.plugins.Events.Inventorys.*;
import ml.peya.plugins.Events.Players.*;
import org.bukkit.plugin.*;

public class EventCore
{
    public static void registerEvents(Plugin plugin)
    {
        PluginManager manager = plugin.getServer().getPluginManager();
        manager.registerEvents(new InventoryClickEvent(), plugin);
        manager.registerEvents(new InventoryCloseEvent(), plugin);
        manager.registerEvents(new InventoryItemClickEvent(), plugin);
        manager.registerEvents(new PlayerInteractEvent(), plugin);
        manager.registerEvents(new PlayerQuitEvent(), plugin);
    }
}
