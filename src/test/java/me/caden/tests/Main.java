package me.caden.tests;

import me.caden.complog.ILogger;
import me.caden.complog.LogProvider;

/**
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        ILogger logger = LogProvider.getLogger(Main.class);
        logger.info("Hello World");
    }
}