package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.*;
import ml.peya.plugins.Inventorys.*;
import org.bukkit.event.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.*;

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
        if (inItems.getItemMeta().getDisplayName().equals(Atm.language.translateString("word.in")))
        {
            int money = InventoryMath.mathInventoryItems(inventory);
            inItems = InventoryItem.getGiveItem(money);
            inventory.setItem(49, inItems);
        }
    }
}
