package ml.peya.plugins;

import com.google.common.math.IntMath;
import org.bukkit.craftbukkit.libs.jline.console.history.PersistentHistory;
import org.bukkit.inventory.ItemStack;


public enum EnumItemValues
{
    ONE(1), //いち
    TEN(10), //じゅう
    HUNDRED(100), //ひゃく
    ONE_THOUSAND(1000), //せん
    TEN_THOUSAND(10000), //まん
    HUNDRED_THOUSAND(100000), //じゅうまん
    ONE_MILLION(1000000), //ひゃくまん
    TEN_MILLION(10000000), //いっせんまん
    HUNDRED_MILLION(100000000); //いちおく

    private ItemStack moneyStacks;
    private int money = 0;
    EnumItemValues(int money)
    {
        this.moneyStacks = MoneyUnits.getItemByInt(money);
        this.money = money;
    }

    public EnumItemValues getEnumItemValuesByInt(int money)
    {
        this.moneyStacks = MoneyUnits.getItemByInt(money);
        this.money = money;
        return this;
    }

    public ItemStack getItem()
    {
        return this.moneyStacks;
    }

    public int getMoney()
    {
         return this.money;
    }
}
