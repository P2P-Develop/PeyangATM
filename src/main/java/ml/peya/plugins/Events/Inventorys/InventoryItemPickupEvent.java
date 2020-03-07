package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Events.Inventorys.Pickup.OpenNowOutInventory;
import ml.peya.plugins.Events.Inventorys.Pickup.OpenNowSelectInventory;
import ml.peya.plugins.Interfaces.BalanceOutputInterface;
import ml.peya.plugins.Enums.EnumItemValue;
import ml.peya.plugins.Inventorys.InventoryItem;
import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Moneys.MoneyCoreSystem;
import ml.peya.plugins.Moneys.MoneyUnit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryItemPickupEvent implements Listener
{
    @EventHandler
    public static void onInventoryPickup(InventoryClickEvent e)
    {
        ItemStack stack = e.getCurrentItem();
        if (stack == null)
            return;
        Player player = (Player) e.getWhoClicked();
        switch (Atm.openInventory.get(player))
        {
            case SELECT_INVENTORY:
                OpenNowSelectInventory.process(player, stack);
                break;
            case IN_INVENTORY:
                if(stack.equals(InventoryItem.getBackButtonItem()))
                {
                    e.setCancelled(true);
                    Inventory.openSelectInventory(player);
                    return;
                }
                OpenNowOutInventory.process(player, stack);
                break;
            case OUT_INVENTORY:
                e.setCancelled(true);

                break;
        }
    }


}
