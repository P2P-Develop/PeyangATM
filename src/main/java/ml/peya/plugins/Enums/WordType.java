package ml.peya.plugins.Enums;

import ml.peya.plugins.*;

public enum WordType
{
    IN("in"),
    OUT("out"),
    NOW("now"),
    TITLE("title"),
    PREFIX("prefix");
    String str;
    WordType(String str)
    {
        this.str = str;
    }

    public String toString()
    {
        return Atm.language.translateString("word." + str);
    }
}
