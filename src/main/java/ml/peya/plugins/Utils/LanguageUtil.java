package ml.peya.plugins.Utils;

import ml.peya.plugins.*;
import org.bukkit.configuration.file.*;

import java.util.*;

public class LanguageUtil
{
    private FileConfiguration config;
    ConfigUtil configUtils;
    public LanguageUtil()
    {
        configUtils = new ConfigUtil(Atm.plugin,  "lang/" + Atm.config.getString("lang"));
        configUtils.saveDefaultConfig();
        config = configUtils.getConfig();
    }

    public String translateString(String key)
    {
        return config.getString(key);
    }
    public ArrayList<String> translateStringList(String key) { return (ArrayList<String>) config.getStringList(key); }


    public ConfigUtil getConfig()
    {
        return configUtils;
    }
}
