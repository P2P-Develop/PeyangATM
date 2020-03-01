package ml.peya.plugins;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;

public class InventoryMaths
{
    public static int mathInventoryItems(Inventory inventory)
    {
        int money = 0;
        ItemStack[] stacks = inventory.getStorageContents();
        ArrayList<ItemStack> moneyItems = new ArrayList<ItemStack>();
        for (ItemStack stack: stacks)
        {
            if (stack == null)
                continue;
            ItemMeta meta = stack.getItemMeta();
            for (int i = 1; i <= stack.getAmount(); i++)
            {
                if (MoneyUnits.isMoneyItem(stack))
                {
                    moneyItems.add(stack);
                }

            }
        }
        if (moneyItems.size() == 0)
        {
            return 0;
        }
        for (ItemStack moneyItem: moneyItems)
        {
            money += MoneyUnits.getMoneyByItems(moneyItem);
        }

        return money;
    }
}
