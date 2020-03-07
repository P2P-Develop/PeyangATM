package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Enums.EnumOpenNowInventoryTypes;
import ml.peya.plugins.Inventorys.InventoryItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

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
                if (!((stack.equals(InventoryItem.getBackButtonItem()) || stack.getItemMeta().getDisplayName().equals("§a§lお預け入れ"))))
                    e.getPlayer().getInventory().addItem(stack);
            }
        }


        Atm.openInventory.change(player, EnumOpenNowInventoryTypes.NO_INVENTORY);
    }
}
