package ml.peya.plugins.Moneys;

import ml.peya.plugins.*;
import ml.peya.plugins.Enums.*;
import ml.peya.plugins.Utils.*;
import net.milkbowl.vault.economy.*;
import org.bukkit.entity.*;

public class MoneyCoreSystem
{
    private static Economy economy = Atm.economy;
    public static BalanceOutputUtil withDrawMoney(EnumItemValue money, Player player, boolean isDebt)
    {
        BalanceOutputUtil output = hasBalance(player, money.getMoney());
        switch(output.getType())
        {
            case OK:
                economy.withdrawPlayer(player, money.getMoney());
                return new BalanceOutputUtil(output.getType(), "OK", true);
            case NOACCOUNT:
                return new BalanceOutputUtil(output.getType(), "No Account", false);
            case NOMONEY:
                if (isDebt)
                {
                    economy.withdrawPlayer(player, money.getMoney());
                    return new BalanceOutputUtil(output.getType(), "OK", true);
                }
                else
                    return new BalanceOutputUtil(output.getType(), "No Money.", false);
            default:
                return new BalanceOutputUtil(EnumBalanceOutput.ERROR, "Unknown error.", false);
        }
    }

    public static BalanceOutputUtil hasBalance(Player player, double money)
    {
        if (!hasAccount(player))
            return new BalanceOutputUtil(EnumBalanceOutput.NOACCOUNT, "NO Account!", false);
        if (economy.has(player, money))
            return new BalanceOutputUtil(EnumBalanceOutput.OK, "", true);
        else
            return new BalanceOutputUtil(EnumBalanceOutput.NOMONEY, "No Money.", false);
    }

    public static boolean hasAccount(Player player)
    {
        return economy.hasAccount(player);
    }

    public static BalanceOutputUtil giveMoney(Player player, int money)
    {
        if(hasAccount(player))
        {
            economy.depositPlayer(player, money);
            return new BalanceOutputUtil(EnumBalanceOutput.OK, "Ok", true);
        }

        return new BalanceOutputUtil(EnumBalanceOutput.NOACCOUNT, "Failed", false);
    }
}
