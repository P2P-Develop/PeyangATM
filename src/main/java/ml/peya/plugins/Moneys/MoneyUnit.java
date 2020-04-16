package ml.peya.plugins.Moneys;

import ml.peya.plugins.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import java.util.*;

public class MoneyUnit
{
    public static ItemStack getItemByInt(int money)
    {
        String colorCode = "";
        String preSuffix = "";
        ArrayList<Material> items = Atm.itemList;
        Material item;
        String moneyString = String.valueOf(money);
        switch (money)
        {
            case 1: //いち
                colorCode = "§7";
                item = items.get(0);
                preSuffix = "§a";
                break;
            case 10: //じゅう
                colorCode = "§9";
                item = items.get(1);
                preSuffix = "§a";
                break;
            case 100: //ひゃく
                colorCode = "§f";
                item = items.get(2);
                preSuffix = "§a";
                break;
            case 1000: //せん
                colorCode = "§c";
                item = items.get(3);
                preSuffix = "§a";
                break;
            case 10000: //いちまん
                colorCode = "§6";
                item = items.get(4);
                preSuffix = "§a";
                break;
            case 100000: //じゅうまん
                colorCode = "§4§l";
                item = items.get(5);
                preSuffix = "§a";
                break;
            case 1000000: //ひゃくまん
                colorCode = "§b§l";
                item = items.get(6);
                preSuffix = "§a";
                break;
            case 10000000: //いっせんまん
                colorCode = "§5§l";
                item = items.get(7);
                preSuffix = "§a";
                break;
            case 100000000: //いちおく
                colorCode = "§1§k1§9§k2§l§6";
                item = items.get(8);
                preSuffix = "§9§k2§1§k1§r§a";
                break;
            default:
                colorCode = "Unknown";
                item = Material.BARRIER;
                preSuffix = "Unknown";
        }
        ItemStack stack = new ItemStack(item);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(colorCode + moneyString + preSuffix + "Peyallion");
        ArrayList<String> lore = new ArrayList<>();
        ArrayList<String> loreTranslate = Atm.language.translateStringList("lore");

        lore.add(loreTranslate.get(0).replace("$server$", Atm.config.getString("server")));
        lore.add(colorCode + loreTranslate.get(1).replace("$amount", moneyString).replace("$unit$", Atm.config.getString("unit")));
        lore.add(loreTranslate.get(2));

        loreTranslate.remove(2);
        loreTranslate.remove(1);
        loreTranslate.remove(0);
        lore.addAll(loreTranslate);

        meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }

    public static int getMoneyByItems(ItemStack item)
    {
        ArrayList<Material> itemList= Atm.itemList;
        if (!isMoneyItem(item)) return 0;
        Material itemMaterial = item.getType();
        if(itemList.get(0).equals(item.getType()))
            return 1;
        else if (itemList.get(1).equals(itemMaterial))
            return 10;
        else if (itemList.get(2).equals(itemMaterial))
            return 100;
        else if (itemList.get(3).equals(itemMaterial))
            return 1000;
        else if (itemList.get(4).equals(itemMaterial))
            return 10000;
        else if (itemList.get(5).equals(itemMaterial))
            return 100000;
        else if (itemList.get(6).equals(itemMaterial))
            return 1000000;
        else if (itemList.get(7).equals(itemMaterial))
            return 10000000;
        else if (itemList.get(8).equals(itemMaterial))
            return 100000000;
        else
            return 0;

    }


    public static boolean isMoneyItem(ItemStack item)
    {
        if (item == null)
            return false;
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = (ArrayList<String>) meta.getLore();
        if (!meta.hasLore() || lore.size() == 0)
            return false;
        String realLore = Atm.language.translateStringList("lore").get(0).replace("$server$", Atm.config.getString("server"));
        return lore.get(0).equals(realLore);
    }

}
