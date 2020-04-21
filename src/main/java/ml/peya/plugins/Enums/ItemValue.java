package ml.peya.plugins.Enums;

import ml.peya.plugins.Moneys.*;
import org.bukkit.inventory.*;


public enum ItemValue
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

    private ItemStack moneyStack;
    ItemValue(int money)
    {
        this.moneyStack = MoneyUnit.getItemByInt(money);
    }

    public ItemStack getItem()
    {
        return this.moneyStack;
    }
}
