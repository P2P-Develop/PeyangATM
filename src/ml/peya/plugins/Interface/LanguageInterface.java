package ml.peya.plugins.Interface;

import ml.peya.plugins.Atm;
import ml.peya.plugins.ConfigUtils;
import org.bukkit.configuration.file.FileConfiguration;

public class LanguageInterface
{
    private FileConfiguration config;
    public LanguageInterface()
    {
        ConfigUtils configUtils = new ConfigUtils(Atm.plugin, "lang/" + Atm.config.getString("lang"));
        configUtils.saveDefaultConfig();
        config = configUtils.getConfig();
    }

    public String translateString(String key)
    {
        return config.getString(key);
    }
}
