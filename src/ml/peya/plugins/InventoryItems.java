package ml.peya.plugins;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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

    public static ItemStack getBackButtonItem ()
    {
        ItemStack backStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        ItemMeta backMeta = backStack.getItemMeta();
        backMeta.setDisplayName("§c§l戻る");
        backStack.setItemMeta(backMeta);
        return backStack;
    }

    public static ItemStack getBackButtonItem (String text)
    {
        ItemStack backStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        ItemMeta backMeta = backStack.getItemMeta();
        backMeta.setDisplayName("§c§l" + text);
        backStack.setItemMeta(backMeta);
        return backStack;
    }

    public static ItemStack getGiveItem(int money)
    {
        ItemStack giveStack = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta giveMeta = giveStack.getItemMeta();
        giveMeta.setDisplayName("§a§lお預け入れ");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§c§l現在: " + money + "§a§lPeyallion");
        giveMeta.setLore(lore);
        giveStack.setItemMeta(giveMeta);
        return giveStack;
    }
}
