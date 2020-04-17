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
        if (args.length == 0 && sender instanceof Player)
            CommandOpen.commandOpen(sender);

        else if(!(sender instanceof Player))
        {
            sender.sendMessage(Atm.language.translateString("error.pleasePlayer"));
            return true;
        }

        if ("reload".equals(args[1]))
            CommandReload.commandReload(sender);
        else
            CommandHelp.commandHelp(sender);

        return true;
    }
}
