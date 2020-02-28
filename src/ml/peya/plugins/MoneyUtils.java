package ml.peya.plugins;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MoneyUtils
{

    public boolean isMoneyItems(ItemStack stack)
    {
        ItemMeta meta = stack.getItemMeta();
        if (!meta.hasLore()) return false;
        ArrayList<String> lore = (ArrayList<String>) meta.getLore();
        if (lore.size() == 0) return false;
        String LoreOne = lore.get(0);
        return LoreOne.equals("§c§lペや鯖§9で使える貨幣。");
    }
}
