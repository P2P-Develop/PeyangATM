package ml.peya.plugins;

import jp.jyn.jecon.Jecon;
import ml.peya.plugins.Commands.CommandCore;
import ml.peya.plugins.Configs.Config;
import ml.peya.plugins.Configs.Interfaces.ConfigInterface;
import ml.peya.plugins.Enums.EnumOutMessageType;
import ml.peya.plugins.Events.EventCore;
import ml.peya.plugins.Interfaces.LanguageInterface;
import ml.peya.plugins.Interfaces.PlayerInterface;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class Atm extends JavaPlugin
{
    public static LanguageInterface language;
    public static FileConfiguration config;
    public static ConfigInterface configInterface;
    public static Atm plugin;
    public static Jecon jecon;
    public static PlayerInterface openInventory = new PlayerInterface();
    @Override
    public void onEnable()
    {
        reloadConfig();
        saveDefaultConfig();
        config = getConfig();
        plugin = this;
        language = new LanguageInterface();
        configInterface = Config.Init();
        getCommand("atm").setExecutor(new CommandCore());
        EventCore.registerEvents(plugin);
        log(EnumOutMessageType.INFO, "PeyangAtm Is Enabled!");
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Jecon");
        if(plugin == null || !plugin.isEnabled())
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
