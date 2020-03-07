package ml.peya.plugins.Events.Inventorys.Pickup;

import ml.peya.plugins.Atm;
import ml.peya.plugins.Enums.EnumItemValue;
import ml.peya.plugins.Interfaces.BalanceOutputInterface;
import ml.peya.plugins.Inventorys.Inventory;
import ml.peya.plugins.Inventorys.InventoryItem;
import ml.peya.plugins.Inventorys.InventoryMath;
import ml.peya.plugins.Moneys.MoneyCoreSystem;
import ml.peya.plugins.Moneys.MoneyUnit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class OpenNowInInventory
{



    public static void process(Player player, ItemStack stack, InventoryClickEvent e)
    {

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
    }
}
