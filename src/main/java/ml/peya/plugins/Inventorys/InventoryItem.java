package ml.peya.plugins.Inventorys;

import ml.peya.plugins.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import java.util.*;

public class InventoryItem
{
    public static ItemStack getInItem ()
    {
        ItemStack inStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
        ItemMeta inMeta = inStack.getItemMeta();
        inMeta.setDisplayName(Atm.language.translateString("word.in"));
        inStack.setItemMeta(inMeta);
        return inStack;
    }

    public static ItemStack getOutItem ()
    {
        ItemStack outStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        ItemMeta outMeta = outStack.getItemMeta();
        outMeta.setDisplayName(Atm.language.translateString("word.out"));
        outStack.setItemMeta(outMeta);
        return outStack;
    }

    public static ItemStack getSelectItems ()
    {
        ItemStack selectStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
        ItemMeta selectMeta = selectStack.getItemMeta();
        selectMeta.setDisplayName(String.format("%s §r| %s", Atm.language.translateString("word.in"), Atm.language.translateString("word.out")));
        selectStack.setItemMeta(selectMeta);
        return selectStack;
    }

    public static ItemStack getBackButtonItem ()
    {
        ItemStack backStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        ItemMeta backMeta = backStack.getItemMeta();
        backMeta.setDisplayName(Atm.language.translateString("word.back"));
        backStack.setItemMeta(backMeta);
        return backStack;
    }


    public static ItemStack getGiveItem(int money)
    {
        ItemStack giveStack = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta giveMeta = giveStack.getItemMeta();
        giveMeta.setDisplayName(Atm.language.translateString("word.in"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Atm.language.translateString("word.now").replace("$amount$", String.valueOf(money)).replace("$unit$", Atm.config.getString("unit")));
        giveMeta.setLore(lore);
        giveStack.setItemMeta(giveMeta);
        return giveStack;
    }
}
