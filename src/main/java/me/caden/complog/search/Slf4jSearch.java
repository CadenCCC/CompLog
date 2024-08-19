package me.caden.complog.search;

import me.caden.complog.LogSearch;

/**
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class Slf4jSearch implements LogSearch {

    @Override
    public boolean isCompatible() {
        final String slf4jManager = "org.slf4j.LoggerFactory";
        try {
            Class.forName(slf4jManager);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    @Override
    public int getPriority() {
        return 1;
    }
}