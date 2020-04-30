package ml.peya.plugins.Utils;

import ml.peya.plugins.*;
import org.bukkit.configuration.file.*;

import java.math.*;

public class Translate
{
    private static FileConfiguration config = Atm.config;
    public static String replaceAmount(String str, long amount)
    {

        return str.replace("$amount$", BigDecimal.valueOf(amount).toPlainString());
    }

    public static String replaceUnit(String str)
    {
        return str.replace("$unit$", config.getString("unit"));
    }

    public static String replaceMoney(String str,  long amount)
    {
        return replaceUnit(replaceAmount(str, amount));
    }

}
