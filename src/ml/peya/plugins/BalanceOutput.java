package ml.peya.plugins;


public class BalanceOutput
{
    enum Type
    {
        ERROR,
        OK,
        NOACCOUNT,
        NOMONEY;
    }
    private Type type;
    private String message;
    private boolean isSuccess;
    BalanceOutput(Type type, String message, boolean isSuccess)
    {
        this.type = type;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public Type getType()
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
