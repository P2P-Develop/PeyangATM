package ml.peya.plugins.Events.Players;

import ml.peya.plugins.*;
import org.bukkit.event.*;

public class PlayerQuitEvent implements Listener
{
    @EventHandler
    public void onQuit(org.bukkit.event.player.PlayerQuitEvent e)
    {
        Atm.openInventory.remove(e.getPlayer());
    }
}
