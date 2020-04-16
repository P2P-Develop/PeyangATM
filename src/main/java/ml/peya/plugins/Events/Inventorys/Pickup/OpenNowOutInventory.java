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
        if (stack.equals(InventoryItem.getBackButtonItem()))
        {
            Inventory.openSelectInventory(player);
            return;
        }
        if(!MoneyUnit.isMoneyItem(stack))
            return;

        LanguageUtil language = Atm.language;
        BalanceOutputUtil out =  MoneyCoreSystem.withDrawMoney(EnumItemValue.ONE.getEnumItemValuesByInt(MoneyUnit.getMoneyByItems(stack)), player, Atm.config.getBoolean("debt"));
        switch (out.getType())
        {
            case OK:
                player.getInventory().addItem(stack);
                player.sendMessage(language.translateString("message.successOut").replace("$amount$", String.valueOf(MoneyUnit.getMoneyByItems(stack))).replace("$unit$", Atm.config.getString("unit")));
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
