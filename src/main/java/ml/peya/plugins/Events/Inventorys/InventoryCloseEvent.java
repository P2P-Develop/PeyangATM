package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
import ml.peya.plugins.Inventorys.*;
import org.bukkit.*;
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
        if(!(Atm.openInventory.get(player) == EnumOpenNowInventoryTypes.IN_INVENTORY))
        {
            Atm.openInventory.change(player, EnumOpenNowInventoryTypes.NO_INVENTORY);
            return;
        }
        for (ItemStack stack: stacks)
        {
            if (stack == null || stack.getType() == Material.AIR)
                continue;
            for (int i = 1; i <= stack.getAmount(); i++)
            {
                if (!((stack.equals(InventoryItem.getBackButtonItem()) || stack.getItemMeta().getDisplayName().equals(Atm.language.translateString("word.in")))))
                    e.getPlayer().getInventory().addItem(stack);
            }
        }


        Atm.openInventory.change(player, EnumOpenNowInventoryTypes.NO_INVENTORY);
    }
}
