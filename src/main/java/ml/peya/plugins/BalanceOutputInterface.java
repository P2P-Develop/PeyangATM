package ml.peya.plugins;

import ml.peya.plugins.Enum.EnumBalanceOutput;

public class BalanceOutputInterface
{

    private EnumBalanceOutput type;
    private String message;
    private boolean isSuccess;
    public BalanceOutputInterface(EnumBalanceOutput type, String message, boolean isSuccess)
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
