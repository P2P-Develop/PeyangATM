package ml.peya.plugins.Events;

import ml.peya.plugins.Events.Inventorys.InventoryClickEvent;
import ml.peya.plugins.Events.Inventorys.InventoryCloseEvent;
import ml.peya.plugins.Events.Inventorys.InventoryItemMoveEvent;
import ml.peya.plugins.Events.Inventorys.InventoryItemPickupEvent;
import ml.peya.plugins.Events.Players.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class EventCore
{
    public static void registerEvents(Plugin plugin)
    {
        PluginManager manager = plugin.getServer().getPluginManager();
        manager.registerEvents(new InventoryClickEvent(), plugin);
        manager.registerEvents(new InventoryCloseEvent(), plugin);
        manager.registerEvents(new InventoryItemMoveEvent(), plugin);
        manager.registerEvents(new InventoryItemPickupEvent(), plugin);
        manager.registerEvents(new PlayerInteractEvent(), plugin);
    }
}
