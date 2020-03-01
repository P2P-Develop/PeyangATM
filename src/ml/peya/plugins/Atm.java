package ml.peya.plugins;

import jp.jyn.jecon.Jecon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Atm extends JavaPlugin
{
    public static Atm plugin;
    public static Jecon jecon;
    public static EnumOpenNowInventoryTypes openInventory = EnumOpenNowInventoryTypes.NO_INVENTORY;
    @Override
    public void onEnable()
    {
        plugin = this;
        getCommand("atm").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new Events(), this);
        log(OutMessageType.INFO, "PeyangAtm Is Enabled!");
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Jecon");
        if(plugin == null && !plugin.isEnabled())
        {
            log(OutMessageType.SEVERE, "Require Jecon Plugin");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        jecon = (Jecon) plugin;
    }

    @Override
    public void onDisable()
    {
        log(OutMessageType.INFO, "PeyangAtm Is Disabled!");
    }

    public static void log(OutMessageType type, String msg)
    {
        type.log(getPlugin().getLogger(), msg);
    }

    public static Atm getPlugin()
    {
        return plugin;
    }
}
