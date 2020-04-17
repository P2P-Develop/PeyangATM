package ml.peya.plugins.Commands.Utils;

import ml.peya.plugins.*;
import ml.peya.plugins.Utils.*;
import org.bukkit.*;
import org.bukkit.command.*;

public class CommandHelp
{
    public static void commandHelp(CommandSender sender)
    {
        LanguageUtil language = Atm.language;
        for (String text: language.translateStringList("help"))
        {
            if (text.equals("$prefix$"))
                sender.sendMessage(ChatColor.DARK_AQUA + "-----=====" + language.translateString("prefix") + ChatColor.DARK_AQUA + "=====-----\n");
            else
                sender.sendMessage(text + "\n");
        }

    }
}
