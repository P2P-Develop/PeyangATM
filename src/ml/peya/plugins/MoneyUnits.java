package ml.peya.plugins;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MoneyUnits
{
    public static ItemStack getItemByInt(int money)
    {
        String colorCode = "";
        String suffix = "";
        Material items = Material.IRON_BARDING;
        String moneyString = String.valueOf(money);
        switch (money)
        {
            case 1: //いち
                colorCode = "§7";
                items = Material.COAL;
                break;
            case 10: //じゅう
                colorCode = "§9";
                items = Material.WHEAT;
                break;
            case 100: //ひゃく
                colorCode = "§f";
                items = Material.SLIME_BALL;
            case 1000: //せん
                colorCode = "§c";
                items = Material.GOLD_NUGGET;
                break;
            case 10000: //いちまん
                colorCode = "§6";
                items = Material.IRON_NUGGET;
                break;
            case 100000: //じゅうまん
                colorCode = "§l§4";
                items = Material.GOLD_NUGGET;
                break;
            case 1000000: //ひゃくまん
                colorCode = "§l§b";
                items = Material.GOLD_BARDING;
                break;
            case 10000000: //いっせんまん
                colorCode = "§l§5";
                items = Material.GHAST_TEAR;
                break;
            case 100000000: //いちおく
                colorCode = "§1§k1§k§92§l§6";
                items = Material.DIAMOND;
                suffix = "§1§k1§k§92§r";
        }
        ItemStack stack = new ItemStack(Material.IRON_BARDING);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(colorCode + moneyString + "Peyallion" + suffix);
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§c§lペや鯖§9で使える貨幣。");
        lore.add(colorCode + moneyString + suffix + "§aPeyallionの価値がある。");
        lore.add("§c右クリック §6でATMを開ける。");
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }
}
