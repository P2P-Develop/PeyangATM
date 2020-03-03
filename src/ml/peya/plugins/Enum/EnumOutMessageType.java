package ml.peya.plugins.Enum;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum EnumOutMessageType
{
    FINEST(-100),
    FINER(-50),
    FINE(0),
    CONFIG(25),
    INFO(50),
    WARNING(75),
    SEVERE(100);

    EnumOutMessageType(int level) {}

    public void log(Logger logger, String message)
    {
        switch(this)
        {
            case FINEST:
                logger.log(Level.FINEST, message);
            case FINER:
                logger.log(Level.FINER, message);
            case FINE:
                logger.log(Level.FINE, message);
            case CONFIG:
                logger.log(Level.CONFIG, message);
            case INFO:
                logger.log(Level.INFO, message);
            case WARNING:
                logger.log(Level.WARNING, message);
            case SEVERE:
                logger.log(Level.SEVERE, message);

        }
    }

}
