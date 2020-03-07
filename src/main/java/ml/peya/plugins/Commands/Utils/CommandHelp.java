package ml.peya.plugins.Commands.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHelp implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        sender.sendMessage(ChatColor.DARK_AQUA + "-----=====" + ChatColor.BLUE + "[" + ChatColor.AQUA + "PeyangATM" + ChatColor.BLUE + "]" + ChatColor.DARK_AQUA + "=====-----\n" +
                              ChatColor.AQUA + "/atm open\n" +
                              ChatColor.GREEN + "ATMを開きます。\n" +
                              ChatColor.AQUA + "/atm help\n" +
                              ChatColor.GREEN + "ヘルプを表示します。\n" +
                              ChatColor.AQUA + "/atm reload\n" +
                              ChatColor.GREEN + "コンフィグをリロードします。");
        return true;
    }
}
