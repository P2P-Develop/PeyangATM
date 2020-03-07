package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Enums.EnumOpenNowInventoryTypes;
import ml.peya.plugins.Inventorys.InventoryItem;
import ml.peya.plugins.Inventorys.InventoryMath;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
        if (inItems.getItemMeta().getDisplayName().equals("§a§lお預け入れ"))
        {
            int money = InventoryMath.mathInventoryItems(inventory);
            inItems = InventoryItem.getGiveItem(money);
            inventory.setItem(49, inItems);
        }
    }
}
