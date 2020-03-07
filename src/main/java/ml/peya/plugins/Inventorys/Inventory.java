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
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 9, "§6§lATM");
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
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, "§c§lお預け入れ");
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
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 18, "§9§lお引き出し");
        inventory.setItem(0, EnumItemValue.ONE.getItem());
        inventory.setItem(1, EnumItemValue.TEN.getItem());
        inventory.setItem(2, EnumItemValue.HUNDRED.getItem());
        inventory.setItem(3, EnumItemValue.ONE_THOUSAND.getItem());
        inventory.setItem(4, EnumItemValue.TEN_THOUSAND.getItem());
        inventory.setItem(5, EnumItemValue.HUNDRED_THOUSAND.getItem());
        inventory.setItem(6, EnumItemValue.ONE_MILLION.getItem());
        inventory.setItem(7, EnumItemValue.TEN_MILLION.getItem());
        inventory.setItem(8, EnumItemValue.HUNDRED_MILLION.getItem());
        inventory.setItem(9, InventoryItem.getBackButtonItem("戻る"));
        inventory.setItem(10, InventoryItem.getBackButtonItem("戻る"));
        inventory.setItem(11, InventoryItem.getBackButtonItem("戻る"));
        inventory.setItem(12, InventoryItem.getBackButtonItem("戻る"));
        inventory.setItem(13, InventoryItem.getBackButtonItem("戻る"));
        inventory.setItem(14, InventoryItem.getBackButtonItem("戻る"));
        inventory.setItem(15, InventoryItem.getBackButtonItem("戻る"));
        inventory.setItem(16, InventoryItem.getBackButtonItem("戻る"));
        inventory.setItem(17, InventoryItem.getBackButtonItem("戻る"));
        player.openInventory(inventory);
        Atm.openInventory.change(player, EnumOpenNowInventoryTypes.OUT_INVENTORY);
    }
}
