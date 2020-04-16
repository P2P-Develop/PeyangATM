package ml.peya.plugins.Events.Players;

import ml.peya.plugins.*;
import ml.peya.plugins.Inventorys.*;
import ml.peya.plugins.Moneys.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

public class PlayerInteractEvent implements Listener
{
    @EventHandler
    public void onInteractEvent(org.bukkit.event.player.PlayerInteractEvent e)
    {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType() != Material.AIR && MoneyUnit.isMoneyItem(player.getInventory().getItemInMainHand()))
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
