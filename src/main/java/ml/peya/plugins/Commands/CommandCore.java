package ml.peya.plugins.Commands;

import ml.peya.plugins.Commands.Utils.CommandHelp;
import ml.peya.plugins.Commands.Utils.CommandOpen;
import ml.peya.plugins.Commands.Utils.CommandReload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandCore implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length == 0 || args[0].equals("open"))
        {
            if (sender instanceof Player)
                new CommandOpen().onCommand(sender, command, "atm open", args);
        }
        else if (args[0].equals("reload"))
            new CommandReload().onCommand(sender, command, "atm rload", args);
        else if (args[0].equals("help"))
            new CommandHelp().onCommand(sender, command, "atm help", args);
        return true;
    }
}
