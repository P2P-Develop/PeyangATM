package ml.peya.plugins.Errors;

import ml.peya.plugins.Interfaces.BalanceOutputInterface;

public class BalanceError
{
    public static String error(BalanceOutputInterface balanceOutputInterface)
    {
        String message;
        switch (balanceOutputInterface.getType())
        {
            case NOACCOUNT:
                message  = "§4§lエラー: アカウントが存在しません。";
                break;
            case NOMONEY:
                message = "§4§lエラー: 引き出せる預金がありません。";
                break;
            case ERROR:
            default:
                message = "§4§lエラー: 不明なエラーです。";
        }

        return message;
    }
}
