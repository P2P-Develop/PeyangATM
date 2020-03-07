package ml.peya.plugins.Events.Inventorys.Pickup;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Enums.EnumItemValue;
import ml.peya.plugins.Interfaces.BalanceOutputInterface;
import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Inventorys.InventoryItem;
import ml.peya.plugins.Moneys.MoneyCoreSystem;
import ml.peya.plugins.Moneys.MoneyUnit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class OpenNowOutInventory
{
    public static void process(Player player, ItemStack stack)
    {
        if(!MoneyUnit.isMoneyItem(stack))
            return;
        if (stack.equals(InventoryItem.getBackButtonItem()))
        {
            Inventory.openSelectInventory(player);
            return;
        }
        BalanceOutputInterface out =  MoneyCoreSystem.withDrawMoney(EnumItemValue.ONE.getEnumItemValuesByInt(MoneyUnit.getMoneyByItems(stack)), player, Atm.configInterface.debt);
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
    }
}
