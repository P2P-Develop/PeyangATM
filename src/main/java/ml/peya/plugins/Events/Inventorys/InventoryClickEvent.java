package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
import ml.peya.plugins.Inventorys.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.inventory.*;

public class InventoryClickEvent implements Listener
{
    @EventHandler
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent e)
    {
        Player player = (Player) e.getWhoClicked();
        if (Atm.openInventory.get(player) == EnumOpenNowInventoryTypes.IN_INVENTORY)
        {
            InventoryView playerInventory = player.getOpenInventory();
            org.bukkit.inventory.Inventory inventory = playerInventory.getTopInventory();
            final ItemStack[] inItems = {inventory.getItem(49)};
            if (InventoryItem.isAirOrNull(inItems[0]))
                return;
            if (inItems[0].getItemMeta().getDisplayName().equals(Atm.language.translateString("word.in")))
            {
                Atm.getPlugin().getServer().getScheduler().scheduleSyncDelayedTask(Atm.getPlugin(), () -> {
                    int money = InventoryMath.mathInventoryItems(inventory);
                    inItems[0] = InventoryItem.getGiveItem(money);
                    inventory.setItem(49, inItems[0]);
                }, 5L);
            }
        }
    }
}
