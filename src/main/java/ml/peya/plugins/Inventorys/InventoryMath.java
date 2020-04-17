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
            for (int i = 1; i <= stack.getAmount(); i++)
            {
                if (!((stack.equals(InventoryItem.getItem(InventoryItemType.BACK_ITEM)) || stack.getItemMeta().getDisplayName().equals(Atm.language.translateString("word.in")))))
                    player.getInventory().addItem(stack);
            }
        }
    }

    public static ArrayList<ItemStack> getMoneyItemList(ItemStack... stacks)
    {
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

        return moneyItems;
    }

}
