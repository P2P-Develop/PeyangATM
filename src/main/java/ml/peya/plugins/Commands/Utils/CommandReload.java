package ml.peya.plugins.Commands.Utils;

import ml.peya.plugins.*;
import org.bukkit.*;
import org.bukkit.command.*;

public class CommandReload
{
    public static void commandReload(CommandSender sender)
    {
        Atm.plugin.reloadConfig();
        Atm.language.getConfig().reloadConfig();
        sender.sendMessage(ChatColor. BLUE + "[" + ChatColor.AQUA + "ATM" + ChatColor.BLUE + "] " + Atm.language.translateString("message.reloadSuccess"));
    }
}
