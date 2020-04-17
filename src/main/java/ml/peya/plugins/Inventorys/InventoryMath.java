package ml.peya.plugins.Inventorys;

import ml.peya.plugins.*;
import ml.peya.plugins.Moneys.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.*;

import java.util.*;

public class InventoryMath
{
    public static int mathInventoryItems(Inventory inventory)
    {
        int money = 0;
        ItemStack[] stacks = inventory.getStorageContents();
        ArrayList<ItemStack> moneyItems =  getMoneyItemList(stacks);
        for (ItemStack moneyItem: moneyItems)
            money += MoneyUnit.getMoneyByItems(moneyItem);
        return money;
    }

    public static void returnToPlayer(Player player, ItemStack... stacks)
    {
        for (ItemStack stack: stacks)
        {
            if (InventoryItem.isAirOrNull(stack))
                continue;
            returnItemFromStack(player, stack);
        }
    }

    public static ArrayList<ItemStack> getMoneyItemList(ItemStack... stacks)
    {
        ArrayList<ItemStack> moneyItems = new ArrayList<>();
        for (ItemStack stack: stacks)
        {
            if (InventoryItem.isAirOrNull(stack))
                continue;
            addItemFromStack(moneyItems, stack);
        }

        return moneyItems;
    }

    private static void addItemFromStack(ArrayList<ItemStack> stack, ItemStack itemStack)
    {
        for (int i = 1; i <= itemStack.getAmount(); i++)
        {
            if (MoneyUnit.isMoneyItem(itemStack))
                stack.add(itemStack);
        }
    }

    private static void returnItemFromStack(Player player, ItemStack itemStack)
    {
        for (int i = 1; i <= itemStack.getAmount(); i++)
        {
            if (!(itemStack.equals(InventoryItem.getItem(InventoryItemType.BACK_ITEM)) ||
                    itemStack.getItemMeta().getDisplayName().equals(Atm.language.translateString("word.in"))))
                player.getInventory().addItem(itemStack);
        }
    }

}
