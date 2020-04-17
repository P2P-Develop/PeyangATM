package ml.peya.plugins.Events.Players;

import ml.peya.plugins.*;
import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Inventorys.*;
import ml.peya.plugins.Moneys.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.inventory.*;

public class PlayerInteractEvent implements Listener
{
    @EventHandler
    public void onInteractEvent(org.bukkit.event.player.PlayerInteractEvent e)
    {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                InventoryItem.isAirOrNull(mainHandItem) &&
                MoneyUnit.isMoneyItem(mainHandItem))
            Inventory.openSelectInventory(player);
        else if (block != null && block.getState() instanceof Sign && e.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            Sign sign = (Sign) block.getState();
            String line = sign.getLine(0);
            if (line.equals(Atm.config.getString("sign")))
                Inventory.openSelectInventory(player);
        }

    }
}
