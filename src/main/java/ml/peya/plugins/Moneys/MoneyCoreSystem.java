package ml.peya.plugins.Moneys;


import jp.jyn.jecon.Jecon;
import jp.jyn.jecon.repository.BalanceRepository;
import ml.peya.plugins.Atm;
import ml.peya.plugins.Interfaces.BalanceOutputInterface;
import ml.peya.plugins.Enums.EnumBalanceOutput;
import ml.peya.plugins.Enums.EnumItemValue;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MoneyCoreSystem
{
    static Jecon jecon = Atm.jecon;
    static BalanceRepository repository = jecon.getRepository();
    public static BalanceOutputInterface withDrawMoney(EnumItemValue money, Player player)
    {
        UUID uuid = player.getUniqueId();
        BalanceOutputInterface output = hasBalance(uuid, money.getMoney());
        switch(output.getType())
        {
            case OK:
                repository.withdraw(uuid, money.getMoney());
                return new BalanceOutputInterface(output.getType(), "OK", true);
            case NOACCOUNT:
                return new BalanceOutputInterface(output.getType(), "No Account", false);
            case NOMONEY:
                return new BalanceOutputInterface(output.getType(), "No Money.", false);
            default:
                return new BalanceOutputInterface(EnumBalanceOutput.ERROR, "Unknown error.", false);
        }
    }

    public static BalanceOutputInterface hasBalance(UUID uuid, double money)
    {
        if (!hasAccount(uuid))
        {
            return new BalanceOutputInterface(EnumBalanceOutput.NOACCOUNT, "NO Account!", false);
        }
        if (repository.has(uuid, money))
        {
            return new BalanceOutputInterface(EnumBalanceOutput.OK, "", true);
        }
        else
        {
            return new BalanceOutputInterface(EnumBalanceOutput.NOMONEY, "No Money.", false);
        }
    }

    public static boolean hasAccount(UUID uuid)
    {
        return repository.hasAccount(uuid);
    }

    public static BalanceOutputInterface giveMoney(int money, Player player)
    {
        UUID uuid = player.getUniqueId();
        if(hasAccount(uuid))
        {
            repository.deposit(uuid, money);
            return new BalanceOutputInterface(EnumBalanceOutput.OK, "Ok", true);
        }

        return new BalanceOutputInterface(EnumBalanceOutput.NOACCOUNT, "Failed", false);
    }
}
