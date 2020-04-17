package ml.peya.plugins.Commands;

import ml.peya.plugins.*;
import ml.peya.plugins.Commands.Utils.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class CommandCore implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        String labels;
        if (args.length == 0 || args[0].equals("open"))
        {
            if (sender instanceof Player)
                labels = "open";
            else
            {
                sender.sendMessage(Atm.language.translateString("error.pleasePlayer"));
                return true;
            }
        }
        else if (args[0].equals("reload"))
            labels = "reload";
        else
            labels = "help";
        new CommandHelp().onCommand(sender, command, "atm " + labels, args);
        return true;
    }
}
