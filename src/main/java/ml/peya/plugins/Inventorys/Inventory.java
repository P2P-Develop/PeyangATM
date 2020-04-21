package ml.peya.plugins.Inventorys;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public class Inventory
{
    public static void openSelectInventory(Player player)
    {

        player.openInventory(getSelectInventory(player));
        Atm.openInventory.change(player, OpenNowInventoryType.SELECT_INVENTORY);
    }

    public static void openInInventory(Player player)
    {
        player.openInventory(getInInventory());
        Atm.openInventory.change(player, OpenNowInventoryType.IN_INVENTORY);
    }

    public static void openOutInventory(Player player)
    {
        player.openInventory(getOutInventory());
        Atm.openInventory.change(player, OpenNowInventoryType.OUT_INVENTORY);
    }

    public static org.bukkit.inventory.Inventory getInInventory()
    {
        String textTitle = WordType.IN.toString();
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
        return inventory;
    }

    public static org.bukkit.inventory.Inventory getOutInventory()
    {
        String textTitle = WordType.OUT.toString();
        ItemStack backButton = InventoryItem.getItem(InventoryItemType.BACK_ITEM);
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 18, textTitle);
        inventory.setItem(0, ItemValue.ONE.getItem());
        inventory.setItem(1, ItemValue.TEN.getItem());
        inventory.setItem(2, ItemValue.HUNDRED.getItem());
        inventory.setItem(3, ItemValue.ONE_THOUSAND.getItem());
        inventory.setItem(4, ItemValue.TEN_THOUSAND.getItem());
        inventory.setItem(5, ItemValue.HUNDRED_THOUSAND.getItem());
        inventory.setItem(6, ItemValue.ONE_MILLION.getItem());
        inventory.setItem(7, ItemValue.TEN_MILLION.getItem());
        inventory.setItem(8, ItemValue.HUNDRED_MILLION.getItem());
        inventory.setItem(9, backButton);
        inventory.setItem(10, backButton);
        inventory.setItem(11, backButton);
        inventory.setItem(12, backButton);
        inventory.setItem(13, backButton);
        inventory.setItem(14, backButton);
        inventory.setItem(15, backButton);
        inventory.setItem(16, backButton);
        inventory.setItem(17, backButton);
        return inventory;
    }

    public static org.bukkit.inventory.Inventory getSelectInventory(Player player)
    {
        String textTitle = WordType.TITLE.toString();
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 9, textTitle);
        ItemStack outStack = InventoryItem.getItem(InventoryItemType.OUT_ITEM);
        ItemStack inStack = InventoryItem.getItem(InventoryItemType.IN_ITEM);
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
        return inventory;
    }
}
