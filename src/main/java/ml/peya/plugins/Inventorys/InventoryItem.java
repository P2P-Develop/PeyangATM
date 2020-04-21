package ml.peya.plugins.Inventorys;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
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

    public static boolean hasInItem(ItemStack stack)
    {
        return stack.hasItemMeta() && stack.getItemMeta().hasDisplayName() && stack.getItemMeta().getDisplayName().equals(WordType.IN.toString());
    }

    public static ItemStack getItem(InventoryItemType itemType)
    {
        short metaValue;
        String displayName;
        switch (itemType)
        {
            case IN_ITEM:
                metaValue = 11;
                displayName = "word.in";
                break;
            case BACK_ITEM:
                metaValue = 14;
                displayName = "word.back";
                break;
            case OUT_ITEM:
                metaValue = 14;
                displayName = "word.out";
                break;
            default:
                metaValue = 0;
                displayName = "";
        }
        ItemStack backStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, metaValue);
        ItemMeta backMeta = backStack.getItemMeta();
        backMeta.setDisplayName(Atm.language.translateString(displayName));
        backStack.setItemMeta(backMeta);
        return backStack;
    }


    public static ItemStack getSelectItems (Player player)
    {
        ItemStack selectStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
        ItemMeta selectMeta = selectStack.getItemMeta();
        selectMeta.setDisplayName(String.format("%s §r| %s", WordType.IN.toString(), WordType.OUT.toString()));
        ArrayList<String> lore = new ArrayList<>();
        int moneyInt = BigDecimal.valueOf(MoneyCoreSystem.getMoney(player)).intValue();
        lore.add(Translate.replaceMoney(WordType.NOW.toString(), moneyInt));
        selectMeta.setLore(lore);
        selectStack.setItemMeta(selectMeta);
        return selectStack;
    }


    public static ItemStack getGiveItem(int money)
    {
        ItemStack giveStack = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta giveMeta = giveStack.getItemMeta();
        giveMeta.setDisplayName(WordType.IN.toString());
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Translate.replaceMoney(WordType.NOW.toString(), money));
        giveMeta.setLore(lore);
        giveStack.setItemMeta(giveMeta);
        return GlowUtil.setGlow(giveStack);
}

    public static boolean isAirOrNull(ItemStack stack)
    {
        return stack == null || stack.getType() == Material.AIR;
    }
}
