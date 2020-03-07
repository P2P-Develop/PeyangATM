package ml.peya.plugins.Interfaces;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Configs.Utils.ConfigUtil;
import org.bukkit.configuration.file.FileConfiguration;

public class LanguageInterface
{
    private FileConfiguration config;
    ConfigUtil configUtils;
    public LanguageInterface()
    {
        configUtils = new ConfigUtil(Atm.plugin, "lang/" + Atm.config.getString("resources/lang"));
        configUtils.saveDefaultConfig();
        config = configUtils.getConfig();
    }

    public String translateString(String key)
    {
        return config.getString(key);
    }

    public ConfigUtil getConfig()
    {
        return configUtils;
    }
}
