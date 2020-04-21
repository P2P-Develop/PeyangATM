package ml.peya.plugins.Commands.Utils;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
import ml.peya.plugins.Utils.*;
import org.bukkit.*;
import org.bukkit.command.*;

public class CommandHelp
{
    public static void commandHelp(CommandSender sender)
    {
        LanguageUtil language = Atm.language;
        sender.sendMessage(ChatColor.DARK_AQUA + "-----=====" + WordType.PREFIX.toString() + ChatColor.DARK_AQUA + "=====-----\n");
        for (String text: language.translateStringList("helpmessage"))
        {
            if (text.startsWith("_"))
            {
                if (sender.hasPermission("atm.admin"))
                    text =  text.substring(1);
                else
                    continue;
            }
            sender.sendMessage(text + "\n");
        }

    }
}
