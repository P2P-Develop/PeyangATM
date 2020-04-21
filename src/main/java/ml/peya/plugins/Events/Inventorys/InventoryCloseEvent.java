package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
import ml.peya.plugins.Inventorys.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.inventory.*;

public class InventoryCloseEvent implements Listener
{
    @EventHandler
    public static void onInventoryClose(org.bukkit.event.inventory.InventoryCloseEvent e)
    {
        Player player = (Player) e.getPlayer();
        ItemStack[] stacks = e.getInventory().getStorageContents();
        if(!(Atm.openInventory.get(player).equals(OpenNowInventoryType.IN_INVENTORY)))
        {
            Atm.openInventory.change(player, OpenNowInventoryType.NO_INVENTORY);
            return;
        }

        InventoryMath.returnToPlayer(player, true, stacks);

        Atm.openInventory.change(player, OpenNowInventoryType.NO_INVENTORY);
    }
}
