package ml.peya.plugins.Commands.Utils;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Utils.LanguageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandOpen implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        LanguageUtil language = Atm.language;
        String prefix = language.translateString("word.prefix");
        if (sender instanceof ConsoleCommandSender)
            sender.sendMessage(prefix + language.translateString("error.pleasePlayer"));
        else if (sender.hasPermission("pa.open"))
            Inventory.openSelectInventory((Player) sender);
        else
            sender.sendMessage(prefix + language.translateString("error.noPermission"));
        return true;
    }
}
