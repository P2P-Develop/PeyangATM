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
            if (MoneyCoreSystem.isOverflow(player, InventoryMath.mathInventoryItems(e.getInventory())))
                player.sendMessage(language.translateString("error.overflow"));
            else
                in(e.getInventory(), player);
        }
    }

    private static void in(org.bukkit.inventory.Inventory inventory, Player player)
    {
        BalanceOutputUtil output = MoneyCoreSystem.giveMoney(player, InventoryMath.mathInventoryItems(inventory));
        switch (output.getType())
        {
            case OK:
                player.sendMessage(Translate.replaceMoney(MessageType.SUCCESSIN.toString(), InventoryMath.mathInventoryItems(inventory)));
                InventoryMath.returnToPlayer(player, false, inventory.getContents());
                inventory.clear();
                Inventory.openSelectInventory(player);
                break;
            case NOACCOUNT:
                player.sendMessage(Atm.language.translateString("error.noAccount"));
                break;
        }
    }

}
