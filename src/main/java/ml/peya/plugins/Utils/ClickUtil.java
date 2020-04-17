package ml.peya.plugins.Utils;

import org.bukkit.event.block.*;

public class ClickUtil
{
    public static boolean isRightClick(Action action)
    {
        return action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK;
    }

}
