package ml.peya.plugins;


import ml.peya.plugins.Inventory.Inventorys;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length == 0)
        {
            sender.sendMessage(ChatColor. BLUE + "[" + ChatColor.AQUA + "ATM" + ChatColor.BLUE + "] " + ChatColor.RED + "引数が足りません！" + ChatColor.AQUA + " /atm help でヘルプを見てください！");
            return true;
        }

        switch(args[0])
        {
            case "help":
                sender.sendMessage(ChatColor.DARK_AQUA + "-----=====" + ChatColor.BLUE + "[" + ChatColor.AQUA + "PeyangATM" + ChatColor.BLUE + "]" + ChatColor.DARK_AQUA + "=====-----\n" +
                                      ChatColor.AQUA + "/atm open\n" +
                                      ChatColor.GREEN + "ATMを開きます。\n" +
                                      ChatColor.AQUA + "/atm help\n" +
                                      ChatColor.GREEN + "ヘルプを表示します。\n" +
                                      ChatColor.AQUA + "/atm reload\n" +
                                      ChatColor.GREEN + "コンフィグをリロードします。");
                break;
            case "open":
                if (sender instanceof ConsoleCommandSender)
                {
                    sender.sendMessage(ChatColor. BLUE + "[" + ChatColor.AQUA + "ATM" + ChatColor.BLUE + "] " + ChatColor.RED + "プレイヤーから実行してください！");
                    return true;
                }
                if (sender.hasPermission("pa.open"))
                {
                    Inventorys.openSelectInventory((Player) sender);
                }
                else
                {
                    sender.sendMessage(ChatColor. BLUE + "[" + ChatColor.AQUA + "ATM" + ChatColor.BLUE + "] " + ChatColor.RED + "貴方には権限がありません！");
                }
                break;
            case "reload":
                Atm.plugin.reloadConfig();
                Atm.language.getConfig().reloadConfig();
                sender.sendMessage(ChatColor. BLUE + "[" + ChatColor.AQUA + "ATM" + ChatColor.BLUE + "] " + ChatColor.GREEN + "コンフィグをリロードしました。");
        }
        return true;
    }
}
