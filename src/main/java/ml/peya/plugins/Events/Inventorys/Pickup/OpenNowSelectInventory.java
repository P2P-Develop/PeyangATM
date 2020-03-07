package ml.peya.plugins.Events.Inventorys.Pickup;

import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Inventorys.InventoryItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class OpenNowSelectInventory
{
    public static void process(Player player, ItemStack stack)
    {
        if (stack.equals(InventoryItem.getInItem()))
            Inventory.openInInventory(player);
        else if (stack.equals(InventoryItem.getOutItem()))
            Inventory.openOutInventory(player);
    }
}
