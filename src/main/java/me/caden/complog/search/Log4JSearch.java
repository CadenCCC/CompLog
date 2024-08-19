package me.caden.complog.search;

import me.caden.complog.LogSearch;

/**
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class Log4JSearch implements LogSearch {

    @Override
    public boolean isCompatible() {
        final String log4JManager = "org.apache.logging.log4j.LogManager";
        try {
            Class.forName(log4JManager);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    @Override
    public int getPriority() {
        return 2;
    }
}