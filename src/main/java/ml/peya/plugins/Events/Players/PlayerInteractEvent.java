package ml.peya.plugins.Events.Players;

import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Moneys.MoneyUnit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

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
            if (line.equals("[ATM]"))
                Inventory.openSelectInventory(player);
        }

    }
}
