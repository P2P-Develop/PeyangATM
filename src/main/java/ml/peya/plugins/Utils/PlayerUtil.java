package ml.peya.plugins.Utils;

import ml.peya.plugins.Enums.*;
import org.bukkit.entity.*;

import java.util.*;

public class PlayerUtil
{
    private Map<String, EnumOpenNowInventoryTypes> map = new HashMap<>();

    public void change(Player player, EnumOpenNowInventoryTypes type)
    {
        if (type == EnumOpenNowInventoryTypes.NO_INVENTORY)
        {
            map.remove(player.getUniqueId().toString());
            return;
        }

        map.put(player.getUniqueId().toString(),type);
    }

    public EnumOpenNowInventoryTypes get(Player player)
    {
        if (exists(player))
            return map.get(player.getUniqueId().toString());
        else
            return EnumOpenNowInventoryTypes.NO_INVENTORY;
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