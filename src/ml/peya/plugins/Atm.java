package ml.peya.plugins;

import org.bukkit.plugin.java.JavaPlugin;

public class Atm extends JavaPlugin
{
    public static EnumOpenNowInventoryTypes openInventory = EnumOpenNowInventoryTypes.NO_INVENTORY;
    @Override
    public void onEnable()
    {
        getCommand("atm").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new Events(), this);
        log("[PA] PeyangAtm Is Enabled!");
    }

    @Override
    public void onDisable()
    {
        log("[PA] PeyangAtm Is Disabled!");
    }

    public static void log(String msg)
    {
        System.out.println(msg);
    }
}
