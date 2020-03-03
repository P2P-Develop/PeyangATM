package ml.peya.plugins;

import jp.jyn.jecon.Jecon;
import ml.peya.plugins.Enum.EnumOutMessageType;
import ml.peya.plugins.Interface.PlayerInterfaces;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Atm extends JavaPlugin
{
    public static FileConfiguration config;
    public static Atm plugin;
    public static Jecon jecon;
    public static PlayerInterfaces openInventory = new PlayerInterfaces();
    @Override
    public void onEnable()
    {
        saveDefaultConfig();
        config = getConfig();
        plugin = this;
        getCommand("atm").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new Events(), this);
        log(EnumOutMessageType.INFO, "PeyangAtm Is Enabled!");
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Jecon");
        if(plugin == null && !plugin.isEnabled())
        {
            log(EnumOutMessageType.SEVERE, "Require Jecon Plugin");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        jecon = (Jecon) plugin;
    }

    @Override
    public void onDisable()
    {
        log(EnumOutMessageType.INFO, "PeyangAtm Is Disabled!");
    }

    public static void log(EnumOutMessageType type, String msg)
    {
        type.log(getPlugin().getLogger(), msg);
    }

    public static Atm getPlugin()
    {
        return plugin;
    }
}
