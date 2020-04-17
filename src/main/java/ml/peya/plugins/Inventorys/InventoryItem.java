package ml.peya.plugins.Inventorys;

import ml.peya.plugins.*;
import ml.peya.plugins.Moneys.*;
import ml.peya.plugins.Utils.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import java.math.*;
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

    public static ItemStack getSelectItems (Player player)
    {
        ItemStack selectStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
        ItemMeta selectMeta = selectStack.getItemMeta();
        LanguageUtil language = Atm.language;
        selectMeta.setDisplayName(String.format("%s §r| %s", language.translateString("word.in"), language.translateString("word.out")));
        ArrayList<String> lore = new ArrayList<>();
        String moneyStr = BigDecimal.valueOf(MoneyCoreSystem.getMoney(player)).toPlainString();
        lore.add(language.translateString("word.now").replace("$amount$", moneyStr).replace("$unit$", Atm.config.getString("unit")));
        selectMeta.setLore(lore);
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
        return GlowUtil.setGlow(giveStack);
    }
}
