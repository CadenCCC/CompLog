package me.caden.complog.search;

import me.caden.complog.LogSearch;

/**
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class CommonsSearch implements LogSearch {

    @Override
    public boolean isCompatible() {
        final String logFactoryClass = "org.apache.commons.logging.LogFactory";
        try {
            Class.forName(logFactoryClass);
            return true;
        } catch (ClassNotFoundException ignored) {
            return false;
        }
    }
}