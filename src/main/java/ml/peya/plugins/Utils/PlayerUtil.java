package ml.peya.plugins.Utils;

import ml.peya.plugins.Enums.*;
import org.bukkit.entity.*;

import java.util.*;

public class PlayerUtil
{
    private Map<Player, EnumOpenNowInventoryTypes> map = new HashMap<>();

    public void change(Player player, EnumOpenNowInventoryTypes type)
    {
        if (type == EnumOpenNowInventoryTypes.NO_INVENTORY)
        {
            map.remove(player);
            return;
        }

        map.put(player,type);
    }

    public EnumOpenNowInventoryTypes get(Player player)
    {
        if (exists(player))
            return map.get(player);
        else
            return EnumOpenNowInventoryTypes.NO_INVENTORY;
    }

    public boolean exists(Player player)
    {
        return map.containsKey(player);
    }

    public void remove(Player player)
    {
        if (exists(player))
            map.remove(player);
    }
}