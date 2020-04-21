package ml.peya.plugins.Commands;

import ml.peya.plugins.*;
import ml.peya.plugins.Commands.Utils.*;
import org.bukkit.command.*;

public class CommandCore implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if((args.length == 0 || "open".equals(args[0])))
            CommandOpen.commandOpen(sender);
        else if ("reload".equals(args[0]))
            CommandReload.commandReload(sender);
        else if("help".equals(args[0]))
            CommandHelp.commandHelp(sender);
        else
            sender.sendMessage(Atm.language.translateString("error.inValidArgs"));

        return true;
    }
}
