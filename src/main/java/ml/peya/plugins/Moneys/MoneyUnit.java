package ml.peya.plugins.Moneys;

import ml.peya.plugins.*;
import ml.peya.plugins.Inventorys.*;
import ml.peya.plugins.Utils.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import java.util.*;

public class MoneyUnit
{
    private static String colorCode;
    private static Material item;
    private static String preSuffix;

    private static void switchMoney(int money)
    {
        ArrayList<Material> items = Atm.itemList;
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
    }

    public static ItemStack getItemByInt(int money)
    {

        String moneyString = String.valueOf(money);

        ItemStack stack = new ItemStack(item);

        ArrayList<String> lore = new ArrayList<>();
        ArrayList<String> loreTranslate = Atm.language.translateStringList("lore");

        switchMoney(money);

        lore.add(loreTranslate.get(0).replace("$server$", Atm.config.getString("server")));
        lore.add(colorCode + loreTranslate.get(1).replace("$amount", moneyString).replace("$unit$", Atm.config.getString("unit")));
        lore.add(loreTranslate.get(2));

        loreTranslate.remove(2);
        loreTranslate.remove(1);
        loreTranslate.remove(0);
        lore.addAll(loreTranslate);

        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(colorCode + moneyString + preSuffix + "Peyallion");
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return GlowUtil.setGlow(stack);
    }

    public static int getMoneyByItems(ItemStack item)
    {
        ArrayList<Material> itemList= Atm.itemList;
        if (!isMoneyItem(item)) return 0;
        Material itemMaterial = item.getType();
        return getMoneyByMaterial(itemMaterial, itemList);
    }

    private static int getMoneyByMaterial(Material itemMaterial, ArrayList<Material> itemList)
    {
        for (Material item: itemList)
        {
            if (item.equals(itemMaterial))
                return getDataBase().get(itemList.indexOf(item));
        }
        return 0;
    }

    private static ArrayList<Integer> getDataBase()
    {
        ArrayList<Integer> dataBase = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < 8; i ++)
        {
            dataBase.add(10 * count);
            count = 10 * count;
        }
        return dataBase;
    }

    public static boolean isMoneyItem(ItemStack item)
    {
        if (InventoryItem.isAirOrNull(item))
            return false;
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = (ArrayList<String>) meta.getLore();
        if (!meta.hasLore() || lore.size() == 0)
            return false;
        String realLore = Atm.language.translateStringList("lore").get(0).replace("$server$", Atm.config.getString("server"));
        return lore.get(0).equals(realLore);
    }

}
