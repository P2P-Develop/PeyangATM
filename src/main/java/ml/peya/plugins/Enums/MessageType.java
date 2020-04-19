package ml.peya.plugins.Enums;

import ml.peya.plugins.*;

public enum MessageType
{
    SUCCESSIN("successIn"),
    SUCCESSOUT("successOut"),
    SUCCESSRELOAD("successReload");
    String str;
    MessageType(String str)
    {
        this.str = str;
    }

    public String toString()
    {
        return Atm.language.translateString("message." + str);
    }
}
