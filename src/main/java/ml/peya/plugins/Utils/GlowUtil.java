package ml.peya.plugins.Utils;

import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class GlowUtil
{
    public static ItemStack setGlow(ItemStack stack)
    {
        stack.addUnsafeEnchantment(Enchantment.DURABILITY, 0);
        ItemMeta meta = stack.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stack.setItemMeta(meta);
        return stack;
    }
}
