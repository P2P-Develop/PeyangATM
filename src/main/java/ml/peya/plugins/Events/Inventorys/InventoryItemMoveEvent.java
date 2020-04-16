package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
import ml.peya.plugins.Inventorys.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.*;

public class InventoryItemMoveEvent implements Listener
{
    @EventHandler
    public static void onMoveItemEvent(InventoryMoveItemEvent e)
    {
        if (e.getInitiator().getViewers().size() == 0 || e.getInitiator().getViewers() == null || !(e.getInitiator().getViewers().get(0) instanceof Player))
            return;
        Player player = (Player) e.getInitiator().getViewers().get(0);
        Inventory inventory = e.getDestination();
        if(Atm.openInventory.get(player) != EnumOpenNowInventoryTypes.IN_INVENTORY)
            return;
        ItemStack inItems = inventory.getItem(49);
        if (inItems == null || inItems.getType() == Material.AIR)
            return;
        if (inItems.getItemMeta().getDisplayName().equals(Atm.language.translateString("word.in")))
        {
            int money = InventoryMath.mathInventoryItems(inventory);
            inItems = InventoryItem.getGiveItem(money);
            inventory.setItem(49, inItems);
        }
    }
}
