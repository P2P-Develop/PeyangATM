package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.Inventorys.InventoryItem;
import ml.peya.plugins.Inventorys.InventoryMath;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClickEvent implements Listener
{
    @EventHandler
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent e)
    {
        Inventory inventory = e.getInventory();
        if(inventory.getSize() != 54)
            return;

        ItemStack inItems = inventory.getItem(49);
        if (inItems == null)
            return;
        if (inItems.getItemMeta().getDisplayName().equals("§a§lお預け入れ"))
        {
            int money = InventoryMath.mathInventoryItems(inventory);
            inItems = InventoryItem.getGiveItem(money);
            inventory.setItem(49, inItems);
        }
    }
}
