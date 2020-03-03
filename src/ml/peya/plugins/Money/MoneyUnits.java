package ml.peya.plugins.Money;

import net.minecraft.server.v1_12_R1.Items;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MoneyUnits
{
    public static ItemStack getItemByInt(int money)
    {
        String colorCode = "";
        String suffix = "";
        String preSuffix = "";
        String loreSuffix = "";
        Material items = Material.IRON_BARDING;
        String moneyString = String.valueOf(money);
        switch (money)
        {
            case 1: //いち
                colorCode = "§7";
                items = Material.COAL;
                preSuffix = "§a";
                break;
            case 10: //じゅう
                colorCode = "§9";
                items = Material.WHEAT;
                preSuffix = "§a";
                break;
            case 100: //ひゃく
                colorCode = "§f";
                items = Material.SLIME_BALL;
                preSuffix = "§a";
                break;
            case 1000: //せん
                colorCode = "§c";
                items = Material.IRON_NUGGET;
                preSuffix = "§a";
                break;
            case 10000: //いちまん
                colorCode = "§6";
                items = Material.IRON_INGOT;
                preSuffix = "§a";
                break;
            case 100000: //じゅうまん
                colorCode = "§4§l";
                items = Material.GOLD_NUGGET;
                preSuffix = "§a";
                break;
            case 1000000: //ひゃくまん
                colorCode = "§b§l";
                items = Material.GOLD_INGOT;
                preSuffix = "§a";
                break;
            case 10000000: //いっせんまん
                colorCode = "§5§l";
                items = Material.GHAST_TEAR;
                preSuffix = "§a";
                break;
            case 100000000: //いちおく
                colorCode = "§1§k1§9§k2§l§6";
                items = Material.DIAMOND;
                preSuffix = "§9§k2§1§k1§r§a";
                break;
        }
        ItemStack stack = new ItemStack(items);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(colorCode + moneyString + preSuffix + "Peyallion" + suffix);
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§c§lペや鯖§9で使える貨幣。");
        lore.add(colorCode + moneyString + loreSuffix + suffix + "§aPeyallionの価値がある。");
        lore.add("§cクリック§6でATMを開ける。");
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }

    public static int getMoneyByItems(ItemStack item)
    {
        if (!isMoneyItem(item)) return 0;

        switch (item.getType())
        {
            case COAL: //いち
                return 1;
            case WHEAT: //じゅう
                return 10;
            case SLIME_BALL: //ひゃく
                return 100;
            case IRON_NUGGET: //せん
                return 1000;
            case IRON_INGOT: //いちまん
                return 10000;
            case GOLD_NUGGET: //じゅうまん
                return 100000;
            case GOLD_INGOT: //ひゃくまん
                return 1000000;
            case GHAST_TEAR: //いっせんまん
                return 10000000;
            case DIAMOND: //いちおく
                return 100000000;
            default:
                return 0;
        }
    }


    public static boolean isMoneyItem(ItemStack item)
    {
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = (ArrayList<String>) meta.getLore();
        if (!meta.hasLore())
            return false;
        if (lore.size() == 0)
            return false;
        return lore.get(0).equals("§c§lペや鯖§9で使える貨幣。");
    }

}
