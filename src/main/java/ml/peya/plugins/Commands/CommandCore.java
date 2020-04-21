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
        if((args.length == 0 || "open".equals(args[0])))
        {
            if (sender instanceof  Player)
                CommandOpen.commandOpen(sender);
            else
                sender.sendMessage(Atm.language.translateString("error.pleasePlayer"));
        }
        else if ("reload".equals(args[0]))
            CommandReload.commandReload(sender);
        else if("help".equals(args[0]))
            CommandHelp.commandHelp(sender);
        else
            sender.sendMessage(Atm.language.translateString("error.inValidArgs"));

        return true;
    }
}
