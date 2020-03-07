package ml.peya.plugins.Commands.Utils;

import ml.peya.plugins.Inventorys.Inventory;
import org.bukkit.ChatColor;
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
        if (sender instanceof ConsoleCommandSender)
            sender.sendMessage(ChatColor. BLUE + "[" + ChatColor.AQUA + "ATM" + ChatColor.BLUE + "] " + ChatColor.RED + "プレイヤーから実行してください！");
        else if (sender.hasPermission("pa.open"))
            Inventory.openSelectInventory((Player) sender);
        else
            sender.sendMessage(ChatColor. BLUE + "[" + ChatColor.AQUA + "ATM" + ChatColor.BLUE + "] " + ChatColor.RED + "貴方には権限がありません！");
        return true;
    }
}
