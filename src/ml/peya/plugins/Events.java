package ml.peya.plugins;

import com.sun.applet2.preloader.event.InitEvent;
import io.netty.handler.codec.mqtt.MqttMessageBuilders;
import net.minecraft.server.v1_12_R1.Items;
import net.minecraft.server.v1_12_R1.PlayerInteractManager;
import net.minecraft.server.v1_12_R1.TileEntityHopper;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Events implements Listener
{
    @EventHandler
    public static void onInventoryClose(InventoryCloseEvent e)
    {
        ItemStack[] stacks = e.getInventory().getStorageContents();
        ArrayList<ItemStack> moneyItems = new ArrayList<ItemStack>();
        if(!(Atm.openInventory == EnumOpenNowInventoryTypes.IN_INVENTORY))
        {
            Atm.openInventory = EnumOpenNowInventoryTypes.NO_INVENTORY;
            return;
        }
        for (ItemStack stack: stacks)
        {
            if (stack == null)
                continue;
            ItemMeta meta = stack.getItemMeta();
            for (int i = 1; i <= stack.getAmount(); i++)
            {
                if (MoneyUnits.isMoneyItem(stack))
                {
                    e.getPlayer().getInventory().addItem(stack);
                }

            }
        }


        Atm.openInventory = EnumOpenNowInventoryTypes.NO_INVENTORY;
    }

    @EventHandler
    public static void onInventoryPickup(InventoryClickEvent e)
    {
        ItemStack stack = e.getCurrentItem();
        if (stack == null)
        {
            return;
        }
        Player player = (Player) e.getWhoClicked();
        switch (Atm.openInventory)
        {
            case SELECT_INVENTORY:
                e.setCancelled(true);
                if (stack.equals(InventoryItems.getInItem()))
                {
                    Inventorys.openInInventory(player);
                }
                else if (stack.equals(InventoryItems.getOutItem()))
                {
                    Inventorys.openOutInventory(player);
                }
                break;
            case IN_INVENTORY:
                if(stack.equals(InventoryItems.getBackButtonItem()))
                {
                    e.setCancelled(true);
                    Inventorys.openSelectInventory(player);
                    return;
                }
                ItemStack inItems = e.getInventory().getItem(49);
                if (inItems == null || stack.getItemMeta() == null || stack.getItemMeta().getDisplayName() == null)
                {
                    return;
                }

                if (stack.getItemMeta().getDisplayName().equals("§a§lお預け入れ"))
                {
                    e.setCancelled(true);
                    BalanceOutput output = MoneyCoreSystem.giveMoney(InventoryMaths.mathInventoryItems(e.getInventory()), player);
                    switch (output.getType())
                    {
                        case OK:
                            player.sendMessage("§f§l" + InventoryMaths.mathInventoryItems(e.getInventory()) + "§2§lPeyallionを入金しました。");
                            e.getInventory().clear();
                            Inventorys.openSelectInventory(player);
                            break;
                        case NOACCOUNT:
                            player.sendMessage("§4§lエラー: アカウントが存在しません。");
                            break;
                    }
                }
                break;
            case OUT_INVENTORY:
                e.setCancelled(true);
                if (stack.equals(InventoryItems.getBackButtonItem("戻る")))
                {
                    Inventorys.openSelectInventory(player);
                }
                BalanceOutput out =  MoneyCoreSystem.withDrawMoney(EnumItemValues.ONE.getEnumItemValuesByInt(MoneyUnits.getMoneyByItems(stack)), player);
                switch (out.getType())
                {
                    case OK:
                        player.getInventory().addItem(stack);
                        player.sendMessage("§f§l" + MoneyUnits.getMoneyByItems(stack) + "§2§lPeyallionを引き出ししました。");
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


    @EventHandler
    public static void onMoveItemEvent(InventoryMoveItemEvent e)
    {
        Inventory inventory = e.getDestination();
        if(inventory.getSize() != 54)
        {
            return;
        }

        ItemStack inItems = inventory.getItem(49);
        if (inItems == null)
        {
            return;
        }
        if (inItems.getItemMeta().getDisplayName().equals("§a§lお預け入れ"))
        {
            int money = InventoryMaths.mathInventoryItems(inventory);
            inItems = InventoryItems.getGiveItem(money);
            inventory.setItem(49, inItems);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e)
    {
        Inventory inventory = e.getInventory();
        if(inventory.getSize() != 54)
        {
            return;
        }

        ItemStack inItems = inventory.getItem(49);
        if (inItems == null)
        {
            return;
        }
        if (inItems.getItemMeta().getDisplayName().equals("§a§lお預け入れ"))
        {
            int money = InventoryMaths.mathInventoryItems(inventory);
            inItems = InventoryItems.getGiveItem(money);
            inventory.setItem(49, inItems);
        }
    }

    @EventHandler
    public void onInteractEvent(PlayerInteractEvent e)
    {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getInventory().getItemInMainHand() != null && MoneyUnits.isMoneyItem(player.getInventory().getItemInMainHand()))
        {
            Inventorys.openSelectInventory(player);
        }
        else if (block != null && block.getState() instanceof Sign && e.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            Sign sign = (Sign) block.getState();
            String line = sign.getLine(0);
            if (line.equals("[ATM]"))
            {
                Inventorys.openSelectInventory(player);
            }
        }

    }
}
