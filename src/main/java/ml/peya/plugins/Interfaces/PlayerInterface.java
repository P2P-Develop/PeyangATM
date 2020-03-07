package ml.peya.plugins.Interfaces;


import ml.peya.plugins.Enums.EnumOpenNowInventoryTypes;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerInterface
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