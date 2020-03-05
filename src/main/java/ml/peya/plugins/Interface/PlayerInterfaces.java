package ml.peya.plugins.Interface;


import ml.peya.plugins.Enum.EnumOpenNowInventoryTypes;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerInterfaces
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