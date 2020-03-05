package ml.peya.plugins.Inventory;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Enum.EnumItemValues;
import ml.peya.plugins.Enum.EnumOpenNowInventoryTypes;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Inventorys
{
    public static void openSelectInventory(Player player)
    {
        Inventory inventory = Bukkit.createInventory(null, 9, "§6§lATM");
        ItemStack outStack = InventoryItems.getOutItem();
        ItemStack inStack = InventoryItems.getInItem();
        ItemStack selectStack = InventoryItems.getSelectItems();
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
        Inventory inventory = Bukkit.createInventory(null, 54, "§c§lお預け入れ");
        inventory.setItem(53, InventoryItems.getBackButtonItem());
        inventory.setItem(52, InventoryItems.getBackButtonItem());
        inventory.setItem(51, InventoryItems.getBackButtonItem());
        inventory.setItem(50, InventoryItems.getBackButtonItem());
        inventory.setItem(49, InventoryItems.getGiveItem(0));
        inventory.setItem(48, InventoryItems.getBackButtonItem());
        inventory.setItem(47, InventoryItems.getBackButtonItem());
        inventory.setItem(46, InventoryItems.getBackButtonItem());
        inventory.setItem(45, InventoryItems.getBackButtonItem());
        player.openInventory(inventory);
        Atm.openInventory.change(player, EnumOpenNowInventoryTypes.IN_INVENTORY);
    }

    public static void openOutInventory(Player player)
    {
        Inventory inventory = Bukkit.createInventory(null, 18, "§9§lお引き出し");
        inventory.setItem(0, EnumItemValues.ONE.getItem());
        inventory.setItem(1, EnumItemValues.TEN.getItem());
        inventory.setItem(2, EnumItemValues.HUNDRED.getItem());
        inventory.setItem(3, EnumItemValues.ONE_THOUSAND.getItem());
        inventory.setItem(4, EnumItemValues.TEN_THOUSAND.getItem());
        inventory.setItem(5, EnumItemValues.HUNDRED_THOUSAND.getItem());
        inventory.setItem(6, EnumItemValues.ONE_MILLION.getItem());
        inventory.setItem(7, EnumItemValues.TEN_MILLION.getItem());
        inventory.setItem(8, EnumItemValues.HUNDRED_MILLION.getItem());
        inventory.setItem(9, InventoryItems.getBackButtonItem("戻る"));
        inventory.setItem(10, InventoryItems.getBackButtonItem("戻る"));
        inventory.setItem(11, InventoryItems.getBackButtonItem("戻る"));
        inventory.setItem(12, InventoryItems.getBackButtonItem("戻る"));
        inventory.setItem(13, InventoryItems.getBackButtonItem("戻る"));
        inventory.setItem(14, InventoryItems.getBackButtonItem("戻る"));
        inventory.setItem(15, InventoryItems.getBackButtonItem("戻る"));
        inventory.setItem(16, InventoryItems.getBackButtonItem("戻る"));
        inventory.setItem(17, InventoryItems.getBackButtonItem("戻る"));
        player.openInventory(inventory);
        Atm.openInventory.change(player, EnumOpenNowInventoryTypes.OUT_INVENTORY);
    }
}
