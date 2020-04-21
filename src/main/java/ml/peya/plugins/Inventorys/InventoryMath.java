package ml.peya.plugins.Inventorys;

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

    public static void returnToPlayer(Player player, boolean isNotMoney, ItemStack... stacks)
    {
        for (ItemStack stack: stacks)
        {
            if (InventoryItem.isAirOrNull(stack))
                continue;
            if (InventoryItem.hasSystemItem(stack))
                continue;
            returnItemFromStack(player, stack, isNotMoney);
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

    private static void returnItemFromStack(Player player, ItemStack itemStack, boolean isNotMoney)
    {
        if (isNotMoney || !MoneyUnit.isMoneyItem(itemStack))
            player.getInventory().addItem(itemStack);
    }
}
