package ml.peya.plugins.Events.Inventorys.Pickup;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Inventorys.*;
import ml.peya.plugins.Moneys.*;
import ml.peya.plugins.Utils.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public class OpenNowOutInventory
{
    public static void process(Player player, ItemStack stack)
    {
        if (stack.equals(InventoryItem.getItem(InventoryItemType.BACK_ITEM)))
        {
            Inventory.openSelectInventory(player);
            return;
        }
        if(!MoneyUnit.isMoneyItem(stack))
            return;

        LanguageUtil language = Atm.language;
        BalanceOutputUtil out =  MoneyCoreSystem.withDrawMoney(ItemValue.ONE.getEnumItemValuesByInt(MoneyUnit.getMoneyByItems(stack)), player, Atm.config.getBoolean("debt"));
        switch (out.getType())
        {
            case OK:
                player.getInventory().addItem(stack);
                player.sendMessage(Translate.replaceMoney(MessageType.SUCCESSOUT.toString(), MoneyUnit.getMoneyByItems(stack)));
                break;
            case NOACCOUNT:
                player.sendMessage(language.translateString("error.noAccount"));
                break;
            case NOMONEY:
                player.sendMessage(language.translateString("error.noHaveMoney"));
                break;
        }
    }
}
