package ml.peya.plugins.Configs;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Configs.Interfaces.ConfigInterface;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;

public class Config
{
    public static ConfigInterface Init()
    {
        FileConfiguration config = Atm.config;
        ConfigInterface configInterface = new ConfigInterface();
        configInterface.autoCreateAccount = config.getBoolean("autoCreateAccount");
        configInterface.debt = config.getBoolean("debt");
        ArrayList<String>  items = (ArrayList<String>) config.getStringList("item");
        ArrayList<Material> materialArrayList = new ArrayList<>();
        for (String item : items)
        {
            materialArrayList.add(Material.matchMaterial(item));
        }
        configInterface.item = materialArrayList;
        configInterface.lang = config.getString("lang");
        configInterface.serverName = config.getString("serverName");
        configInterface.unit = config.getString("unit");
        return configInterface;
    }
}
