package ml.peya.plugins.Commands.Utils;

import ml.peya.plugins.*;
import org.bukkit.*;
import org.bukkit.command.*;

public class CommandReload implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Atm.plugin.reloadConfig();
        Atm.language.getConfig().reloadConfig();
        sender.sendMessage(ChatColor. BLUE + "[" + ChatColor.AQUA + "ATM" + ChatColor.BLUE + "] " + Atm.language.translateString("message.reloadSuccess"));
        return true;
    }
}
