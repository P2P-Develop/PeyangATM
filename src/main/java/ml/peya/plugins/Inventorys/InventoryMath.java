package ml.peya.plugins.Inventorys;

import ml.peya.plugins.Moneys.MoneyUnit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class InventoryMath
{
    public static int mathInventoryItems(Inventory inventory)
    {
        int money = 0;
        ItemStack[] stacks = inventory.getStorageContents();
        ArrayList<ItemStack> moneyItems = new ArrayList<>();
        for (ItemStack stack: stacks)
        {
            if (stack == null)
                continue;
            for (int i = 1; i <= stack.getAmount(); i++)
            {
                if (MoneyUnit.isMoneyItem(stack))
                    moneyItems.add(stack);

            }
        }
        if (moneyItems.size() == 0)
            return 0;
        for (ItemStack moneyItem: moneyItems)
            money += MoneyUnit.getMoneyByItems(moneyItem);

        return money;
    }
}
