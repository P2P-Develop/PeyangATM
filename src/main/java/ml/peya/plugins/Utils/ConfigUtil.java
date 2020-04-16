package ml.peya.plugins.Utils;

import org.bukkit.configuration.file.*;
import org.bukkit.plugin.*;

import java.io.*;
import java.nio.charset.*;

public class ConfigUtil
{
    private FileConfiguration config;
    private final File configFile;
    private final String file;
    private final Plugin plugin;

    public ConfigUtil(Plugin plugin, String fileName)
    {
        this.plugin = plugin;
        this.file = fileName;
        configFile = new File(plugin.getDataFolder(), file);
    }

    public void saveDefaultConfig()
    {
        if (!configFile.exists())
            plugin.saveResource(file, false);
    }

    public void reloadConfig()
    {
        config = YamlConfiguration.loadConfiguration(configFile);

        final InputStream defConfigStream = plugin.getResource(file);
        if (defConfigStream == null)
            return;

        config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, StandardCharsets.UTF_8)));
    }

    public FileConfiguration getConfig()
    {
        if (config == null)
            reloadConfig();
        return config;
    }

    public void saveConfig()
    {
        if (config == null)
            return;
        try
        {
            getConfig().save(configFile);
        }
        catch (IOException ignored)
        {
        }
    }
}