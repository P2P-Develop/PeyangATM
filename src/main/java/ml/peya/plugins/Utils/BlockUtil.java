package ml.peya.plugins.Utils;

import org.bukkit.block.*;

public class BlockUtil
{
    public static boolean isSign(Block block)
    {
        return block != null && block.getState() instanceof Sign;
    }
}
