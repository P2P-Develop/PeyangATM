package ml.peya.plugins.Utils;

import ml.peya.plugins.Enums.*;
import org.bukkit.entity.*;

import java.util.*;

public class PlayerUtil
{
    private Map<String, OpenNowInventoryType> map = new HashMap<>();

    public void change(Player player, OpenNowInventoryType type)
    {
        if (type == OpenNowInventoryType.NO_INVENTORY)
        {
            map.remove(player.getUniqueId().toString());
            return;
        }

        map.put(player.getUniqueId().toString(),type);
    }

    public OpenNowInventoryType get(Player player)
    {
        if (exists(player))
            return map.get(player.getUniqueId().toString());
        else
            return OpenNowInventoryType.NO_INVENTORY;
    }

    public boolean exists(Player player)
    {
        return map.containsKey(player.getUniqueId().toString());
    }

    public void remove(Player player)
    {
        if (exists(player))
            map.remove(player.getUniqueId().toString());
    }
}