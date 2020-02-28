package ml.peya.plugins;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Inventorys
{
    public static void openSelectInventory(Player player)
    {
        Atm.openInventory = EnumOpenNowInventoryTypes.SELECT_INVENTORY;
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
    }

    public static void openInInventory(Player player)
    {
        Atm.openInventory = EnumOpenNowInventoryTypes.IN_INVENTORY;
        Inventory inventory = Bukkit.createInventory(null, 54, "§c§lお預け入れ");
        player.openInventory(inventory);

    }

    public static void openOutInventory(Player player)
    {
        Atm.openInventory = EnumOpenNowInventoryTypes.OUT_INVENTORY;
        Inventory inventory = Bukkit.createInventory(null, 9, "§9§lお引き出し");
        inventory.setItem(0, EnumItemValues.ONE.getItem());
        inventory.setItem(1, EnumItemValues.TEN.getItem());
        inventory.setItem(2, EnumItemValues.HUNDRED.getItem());
        inventory.setItem(3, EnumItemValues.ONE_THOUSAND.getItem());
        inventory.setItem(4, EnumItemValues.TEN_THOUSAND.getItem());
        inventory.setItem(5, EnumItemValues.HUNDRED_THOUSAND.getItem());
        inventory.setItem(6, EnumItemValues.ONE_MILLION.getItem());
        inventory.setItem(7, EnumItemValues.TEN_MILLION.getItem());
        inventory.setItem(8, EnumItemValues.HUNDRED_MILLION.getItem());
        player.openInventory(inventory);
    }
}
