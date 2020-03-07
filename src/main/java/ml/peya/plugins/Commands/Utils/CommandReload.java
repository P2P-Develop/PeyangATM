package ml.peya.plugins.Commands.Utils;

import ml.peya.plugins.Atm;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandReload implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Atm.plugin.reloadConfig();
        Atm.language.getConfig().reloadConfig();
        sender.sendMessage(ChatColor. BLUE + "[" + ChatColor.AQUA + "ATM" + ChatColor.BLUE + "] " + ChatColor.GREEN + "コンフィグをリロードしました。");
        return true;
    }
}
