package ml.peya.plugins;

import ml.peya.plugins.Commands.*;
import ml.peya.plugins.Enums.*;
import ml.peya.plugins.Events.*;
import ml.peya.plugins.Utils.*;
import net.milkbowl.vault.economy.*;
import org.bukkit.*;
import org.bukkit.configuration.file.*;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.*;

import java.util.*;

public class Atm extends JavaPlugin
{
    public static LanguageUtil language;
    public static FileConfiguration config;
    public static Atm plugin;
    public static Economy economy;
    public static PlayerUtil openInventory = new PlayerUtil();
    public static ArrayList<Material> itemList;
    @Override
    public void onEnable()
    {
        saveDefaultConfig();
        config = getConfig();
        plugin = this;
        language = new LanguageUtil();
        itemList = new ArrayList<>();
        for (String itemString: config.getStringList("item"))
        {
            if (itemString != null)
                itemList.add(Material.getMaterial(itemString));
            else
            {
                log(EnumOutMessageType.SEVERE, "Invalid material type. replaced BARRIER_BLOCK");
                itemList.add(Material.BARRIER);
            }
        }
        System.out.println(itemList);
        getCommand("atm").setExecutor(new CommandCore());
        EventCore.registerEvents(plugin);
        log(EnumOutMessageType.INFO, "PeyangAtm Is Enabled!");
        if(!setupEconomy())
        {
            log(EnumOutMessageType.SEVERE, "Require Vault Plugin");
            Bukkit.getPluginManager().disablePlugin(this);
        }
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

    private boolean setupEconomy()
    {
        if (getServer().getPluginManager().getPlugin("Vault") == null)
            return false;
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null)
            return false;
        economy = rsp.getProvider();
        return economy != null;
    }
}
