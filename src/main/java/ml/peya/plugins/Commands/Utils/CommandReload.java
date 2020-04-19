package ml.peya.plugins.Commands.Utils;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
import org.bukkit.command.*;

public class CommandReload
{
    public static void commandReload(CommandSender sender)
    {
        Atm.plugin.reloadConfig();
        Atm.language.getConfig().reloadConfig();
        sender.sendMessage(WordType.PREFIX.toString() + MessageType.SUCCESSRELOAD.toString());
    }
}
