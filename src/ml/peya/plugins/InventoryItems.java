package ml.peya.plugins;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryItems
{
    public static ItemStack getInItem ()
    {
        ItemStack inStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
        ItemMeta inMeta = inStack.getItemMeta();
        inMeta.setDisplayName("§c§lお預入れ");
        inStack.setItemMeta(inMeta);
        return inStack;
    }

    public static ItemStack getOutItem ()
    {
        ItemStack outStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        ItemMeta outMeta = outStack.getItemMeta();
        outMeta.setDisplayName("§9§lお引き出し");
        outStack.setItemMeta(outMeta);
        return outStack;
    }

    public static ItemStack getSelectItems ()
    {
        ItemStack selectStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
        ItemMeta selectMeta = selectStack.getItemMeta();
        selectMeta.setDisplayName("§c§lお預入れ §r| §9§lお引き出し");
        selectStack.setItemMeta(selectMeta);
        return selectStack;
    }
}
