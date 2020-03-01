package ml.peya.plugins;


import jp.jyn.jecon.Jecon;
import jp.jyn.jecon.repository.BalanceRepository;
import net.milkbowl.vault.Vault;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MoneyCoreSystem
{
    static Jecon jecon = Atm.jecon;
    static BalanceRepository repository = jecon.getRepository();
    public static BalanceOutput withDrawMoney(EnumItemValues money, Player player)
    {
        UUID uuid = player.getUniqueId();
        BalanceOutput output = hasBalance(uuid, money.getMoney());
        switch(output.getType())
        {
            case OK:
                repository.withdraw(uuid, money.getMoney());
                return new BalanceOutput(output.getType(), "OK", true);
            case NOACCOUNT:
                return new BalanceOutput(output.getType(), "No Account", false);
            case NOMONEY:
                return new BalanceOutput(output.getType(), "No Money.", false);
            default:
                return new BalanceOutput(BalanceOutput.Type.ERROR, "Unknown error.", false);
        }
    }

    public static BalanceOutput hasBalance(UUID uuid, double money)
    {
        if (!hasAccount(uuid))
        {
            return new BalanceOutput(BalanceOutput.Type.NOACCOUNT, "NO Account!", false);
        }
        if (repository.has(uuid, money))
        {
            return new BalanceOutput(BalanceOutput.Type.OK, "", true);
        }
        else
        {
            return new BalanceOutput(BalanceOutput.Type.NOMONEY, "No Money.", false);
        }
    }

    public static boolean hasAccount(UUID uuid)
    {
        return repository.hasAccount(uuid);
    }

    public static BalanceOutput giveMoney(int money, Player player)
    {
        UUID uuid = player.getUniqueId();
        if(hasAccount(uuid))
        {
            repository.deposit(uuid, money);
            return new BalanceOutput(BalanceOutput.Type.OK, "Ok", true);
        }

        return new BalanceOutput(BalanceOutput.Type.NOACCOUNT, "Failed", false);
    }
}
