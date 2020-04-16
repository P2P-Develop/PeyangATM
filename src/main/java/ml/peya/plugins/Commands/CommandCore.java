package ml.peya.plugins.Commands;

import ml.peya.plugins.Commands.Utils.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

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
            new CommandReload().onCommand(sender, command, "atm reload", args);
        else
            new CommandHelp().onCommand(sender, command, "atm help", args);
        return true;
    }
}
