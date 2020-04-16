package ml.peya.plugins.Utils;

import ml.peya.plugins.Enums.*;

public class BalanceOutputUtil
{

    private EnumBalanceOutput type;
    private String message;
    private boolean isSuccess;
    public BalanceOutputUtil(EnumBalanceOutput type, String message, boolean isSuccess)
    {
        this.type = type;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public EnumBalanceOutput getType()
    {
        return type;
    }

    public String getMessage()
    {
        return message;
    }

    public boolean isSuccess()
    {
        return this.isSuccess;
    }
}
