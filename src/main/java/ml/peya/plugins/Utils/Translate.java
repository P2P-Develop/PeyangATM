package ml.peya.plugins.Utils;

import ml.peya.plugins.*;
import org.bukkit.configuration.file.*;

public class Translate
{
    private static FileConfiguration config = Atm.config;
    public static String replaceAmount(String str, int amount)
    {
        return str.replace("$amount$", String.valueOf(amount));
    }

    public static String replaceUnit(String str)
    {
        return str.replace("$unit$", config.getString("unit"));
    }

    public static String replaceMoney(String str,  int amount)
    {
        return replaceUnit(replaceAmount(str, amount));
    }

}
