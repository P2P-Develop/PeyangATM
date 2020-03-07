package ml.peya.plugins.Events.Inventorys;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Interfaces.BalanceOutputInterface;
import ml.peya.plugins.Enums.EnumItemValue;
import ml.peya.plugins.Inventorys.InventoryItem;
import ml.peya.plugins.Inventorys.InventoryMath;
import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Moneys.MoneyCoreSystem;
import ml.peya.plugins.Moneys.MoneyUnit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryItemPickupEvent implements Listener
{
    @EventHandler
    public static void onInventoryPickup(InventoryClickEvent e)
    {
        ItemStack stack = e.getCurrentItem();
        if (stack == null)
            return;
        Player player = (Player) e.getWhoClicked();
        switch (Atm.openInventory.get(player))
        {
            case SELECT_INVENTORY:
                e.setCancelled(true);
                if (stack.equals(InventoryItem.getInItem()))
                    Inventory.openInInventory(player);
                else if (stack.equals(InventoryItem.getOutItem()))
                    Inventory.openOutInventory(player);
                break;
            case IN_INVENTORY:
                if(stack.equals(InventoryItem.getBackButtonItem()))
                {
                    e.setCancelled(true);
                    Inventory.openSelectInventory(player);
                    return;
                }
                ItemStack inItems = e.getInventory().getItem(49);
                if (inItems == null || stack.getItemMeta() == null || stack.getItemMeta().getDisplayName() == null)
                    return;
                if (stack.getItemMeta().getDisplayName().equals("§a§lお預け入れ"))
                {
                    e.setCancelled(true);
                    BalanceOutputInterface output = MoneyCoreSystem.giveMoney(InventoryMath.mathInventoryItems(e.getInventory()), player);
                    switch (output.getType())
                    {
                        case OK:
                            player.sendMessage("§f§l" + InventoryMath.mathInventoryItems(e.getInventory()) + "§2§lPeyallionを入金しました。");
                            e.getInventory().clear();
                            Inventory.openSelectInventory(player);
                            break;
                        case NOACCOUNT:
                            player.sendMessage("§4§lエラー: アカウントが存在しません。");
                            break;
                    }
                }
                break;
            case OUT_INVENTORY:
                e.setCancelled(true);
                if(!MoneyUnit.isMoneyItem(stack))
                    return;
                if (stack.equals(InventoryItem.getBackButtonItem()))
                {
                    Inventory.openSelectInventory(player);
                    return;
                }
                BalanceOutputInterface out =  MoneyCoreSystem.withDrawMoney(EnumItemValue.ONE.getEnumItemValuesByInt(MoneyUnit.getMoneyByItems(stack)), player);
                switch (out.getType())
                {
                    case OK:
                        player.getInventory().addItem(stack);
                        player.sendMessage("§f§l" + MoneyUnit.getMoneyByItems(stack) + "§2§lPeyallionを引き出ししました。");
                        break;
                    case NOACCOUNT:
                        player.sendMessage("§4§lエラー: アカウントが存在しません。");
                        break;
                    case NOMONEY:
                        player.sendMessage("§4§lエラー: 引き出せる預金がありません。");
                        break;
                }
                break;
        }
    }
}
