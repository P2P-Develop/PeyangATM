package ml.peya.plugins.Commands.Utils;

import ml.peya.plugins.*;
import ml.peya.plugins.Inventorys.*;
import ml.peya.plugins.Utils.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class CommandOpen
{
    public static void commandOpen(CommandSender sender)
    {
        if (!(sender instanceof  Player))
            sender.sendMessage(Atm.language.translateString("error.pleasePlayer"));
        LanguageUtil language = Atm.language;
        String prefix = language.translateString("word.prefix");
        if (sender instanceof ConsoleCommandSender)
            sender.sendMessage(prefix + language.translateString("error.pleasePlayer"));
        else if (sender.hasPermission("pa.open"))
            Inventory.openSelectInventory((Player) sender);
        else
            sender.sendMessage(prefix + language.translateString("error.noPermission"));
    }
}
