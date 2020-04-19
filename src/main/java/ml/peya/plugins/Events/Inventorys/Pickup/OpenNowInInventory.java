package ml.peya.plugins.Events.Inventorys.Pickup;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Inventorys.*;
import ml.peya.plugins.Moneys.*;
import ml.peya.plugins.Utils.*;
import org.bukkit.entity.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;

public class OpenNowInInventory
{
    public static void process(Player player, ItemStack stack, InventoryClickEvent e)
    {
        ItemStack inItems = e.getInventory().getItem(49);
        if (inItems == null || stack.getItemMeta() == null || stack.getItemMeta().getDisplayName() == null)
            return;
        LanguageUtil language = Atm.language;
        if (stack.getItemMeta().getDisplayName().equals(WordType.IN.toString()))
        {
            e.setCancelled(true);
            BalanceOutputUtil output = MoneyCoreSystem.giveMoney(player, InventoryMath.mathInventoryItems(e.getInventory()));
            switch (output.getType())
            {
                case OK:
                    player.sendMessage(Translate.replaceMoney(MessageType.SUCCESSIN.toString(), InventoryMath.mathInventoryItems(e.getInventory())));
                    e.getInventory().clear();
                    Inventory.openSelectInventory(player);
                    break;
                case NOACCOUNT:
                    player.sendMessage(language.translateString("error.noAccount"));
                    break;
            }
        }
    }
}
