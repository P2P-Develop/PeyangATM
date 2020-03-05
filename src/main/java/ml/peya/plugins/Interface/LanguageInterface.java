package ml.peya.plugins.Interface;

import ml.peya.plugins.Atm;
import ml.peya.plugins.ConfigUtils;
import org.bukkit.configuration.file.FileConfiguration;

public class LanguageInterface
{
    private FileConfiguration config;
    ConfigUtils configUtils;
    public LanguageInterface()
    {
        configUtils = new ConfigUtils(Atm.plugin, "lang/" + Atm.config.getString("resources/lang"));
        configUtils.saveDefaultConfig();
        config = configUtils.getConfig();
    }

    public String translateString(String key)
    {
        return config.getString(key);
    }

    public ConfigUtils getConfig()
    {
        return configUtils;
    }
}
