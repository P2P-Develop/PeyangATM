package ml.peya.plugins.Inventorys;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Enums.EnumItemValue;
import ml.peya.plugins.Enums.EnumOpenNowInventoryTypes;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Inventory
{
    public static void openSelectInventory(Player player)
    {
        String textTitle = Atm.language.translateString("word.title");
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 9, textTitle);
        ItemStack outStack = InventoryItem.getItem(InventoryItemType.OUT_ITEM);
        ItemStack inStack = InventoryItem.getItem(InventoryItemType.OUT_ITEM);
        ItemStack selectStack = InventoryItem.getSelectItems(player);
        inventory.setItem(0, inStack);
        inventory.setItem(1, inStack);
        inventory.setItem(2, inStack);
        inventory.setItem(3, inStack);
        inventory.setItem(4, selectStack);
        inventory.setItem(5, outStack);
        inventory.setItem(6, outStack);
        inventory.setItem(7, outStack);
        inventory.setItem(8, outStack);
        player.openInventory(inventory);
        Atm.openInventory.change(player, EnumOpenNowInventoryTypes.SELECT_INVENTORY);
    }

    public static void openInInventory(Player player)
    {
        String textTitle = Atm.language.translateString("word.in");
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, textTitle);
        ItemStack backItem = InventoryItem.getItem(InventoryItemType.BACK_ITEM);
        inventory.setItem(53, backItem);
        inventory.setItem(52, backItem);
        inventory.setItem(51, backItem);
        inventory.setItem(50, backItem);
        inventory.setItem(49, InventoryItem.getGiveItem(0));
        inventory.setItem(48, backItem);
        inventory.setItem(47, backItem);
        inventory.setItem(46, backItem);
        inventory.setItem(45, backItem);
        player.openInventory(inventory);
        Atm.openInventory.change(player, EnumOpenNowInventoryTypes.IN_INVENTORY);
    }

    public static void openOutInventory(Player player)
    {
        String textTitle = Atm.language.translateString("word.out");
        ItemStack backButton = InventoryItem.getItem(InventoryItemType.BACK_ITEM);
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 18, textTitle);
        inventory.setItem(0, EnumItemValue.ONE.getItem());
        inventory.setItem(1, EnumItemValue.TEN.getItem());
        inventory.setItem(2, EnumItemValue.HUNDRED.getItem());
        inventory.setItem(3, EnumItemValue.ONE_THOUSAND.getItem());
        inventory.setItem(4, EnumItemValue.TEN_THOUSAND.getItem());
        inventory.setItem(5, EnumItemValue.HUNDRED_THOUSAND.getItem());
        inventory.setItem(6, EnumItemValue.ONE_MILLION.getItem());
        inventory.setItem(7, EnumItemValue.TEN_MILLION.getItem());
        inventory.setItem(8, EnumItemValue.HUNDRED_MILLION.getItem());
        inventory.setItem(9, backButton);
        inventory.setItem(10, backButton);
        inventory.setItem(11, backButton);
        inventory.setItem(12, backButton);
        inventory.setItem(13, backButton);
        inventory.setItem(14, backButton);
        inventory.setItem(15, backButton);
        inventory.setItem(16, backButton);
        inventory.setItem(17, backButton);
        player.openInventory(inventory);
        Atm.openInventory.change(player, EnumOpenNowInventoryTypes.OUT_INVENTORY);
    }
}
