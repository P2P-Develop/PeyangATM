package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.*;
import ml.peya.plugins.Events.Inventorys.Pickup.*;
import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Inventorys.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.*;

public class InventoryItemClickEvent implements Listener
{
    @EventHandler
    public static void onInventoryClick(InventoryClickEvent e)
    {
        ItemStack stack = e.getCurrentItem();
        if (stack == null)
            return;
        Player player = (Player) e.getWhoClicked();
        switch (Atm.openInventory.get(player))
        {
            case SELECT_INVENTORY:
                e.setCancelled(true);
                OpenNowSelectInventory.process(player, stack);
                break;
            case IN_INVENTORY:
                if(stack.equals(InventoryItem.getItem(InventoryItemType.BACK_ITEM)))
                {
                    e.setCancelled(true);
                    Inventory.openSelectInventory(player);
                    return;
                }

                OpenNowInInventory.process(player, stack, e);
                break;
            case OUT_INVENTORY:
                e.setCancelled(true);
                OpenNowOutInventory.process(player, stack, e.getClickedInventory());
                break;
        }
    }
}
