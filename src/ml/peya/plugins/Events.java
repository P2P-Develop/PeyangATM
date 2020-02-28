package ml.peya.plugins;

import net.minecraft.server.v1_12_R1.Items;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener
{


    @EventHandler
    public static void onIvnventoryPickup(InventoryClickEvent e)
    {
        ItemStack stack = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();
        switch (Atm.openInventory)
        {
            case SELECT_INVENTORY:
                e.setCancelled(true);
                if (stack.equals(InventoryItems.getInItem()))
                {
                    Inventorys.openInInventory(player);
                }
                else if (stack.equals(InventoryItems.getOutItem()))
                {
                    Inventorys.openOutInventory(player);
                }
                break;
        }
    }
}
