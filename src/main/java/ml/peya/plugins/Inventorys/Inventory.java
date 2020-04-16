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
        ItemStack outStack = InventoryItem.getOutItem();
        ItemStack inStack = InventoryItem.getInItem();
        ItemStack selectStack = InventoryItem.getSelectItems();
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
        inventory.setItem(53, InventoryItem.getBackButtonItem());
        inventory.setItem(52, InventoryItem.getBackButtonItem());
        inventory.setItem(51, InventoryItem.getBackButtonItem());
        inventory.setItem(50, InventoryItem.getBackButtonItem());
        inventory.setItem(49, InventoryItem.getGiveItem(0));
        inventory.setItem(48, InventoryItem.getBackButtonItem());
        inventory.setItem(47, InventoryItem.getBackButtonItem());
        inventory.setItem(46, InventoryItem.getBackButtonItem());
        inventory.setItem(45, InventoryItem.getBackButtonItem());
        player.openInventory(inventory);
        Atm.openInventory.change(player, EnumOpenNowInventoryTypes.IN_INVENTORY);
    }

    public static void openOutInventory(Player player)
    {
        String textTitle = Atm.language.translateString("word.out");
        ItemStack backButton = InventoryItem.getBackButtonItem();
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
