package me.caden.complog;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import me.caden.complog.manager.LogManager;

/**
 * <h6>Provides access to the logging system by managing and supplying the appropriate logger instances.
 *
 * <p>This class is a singleton-like provider for accessing and managing loggers in the application.
 * It leverages the {@linkplain LogManager} to dynamically select and instantiate loggers based on the
 * user's choice or default logger types.</p>
 *
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public final class LogProvider {
    private static final LogManager logManager = new LogManager();

    private static Class<? extends ILogger> loggerClass;

    public static final int JUL_PRIORITY = 100;

    /**
     * <h6>Sets the logger type to be used by the {@linkplain LogProvider}.
     *
     * @param loggerClass the class of the logger to be used.
     */
    public static void setLoggerType(@NotNull Class<? extends ILogger> loggerClass) {
        LogProvider.loggerClass = loggerClass;
    }

    /**
     * <h6>Retrieves a logger instance for the specified class.
     *
     * @param clazz the class for which the logger is being requested.
     * @return an instance of the logger.
     */
    @NotNull
    public static ILogger getLogger(@NotNull Class<?> clazz) {
        return getLogger(clazz, null);
    }

    /**
     * <h6>Retrieves a logger instance for the specified class and allows specifying the logger type.
     *
     * @param clazz the class for which the logger is being requested.
     * @param loggerClass the class of the logger to be used, or null to use the default logger type.
     * @return an instance of the logger.
     */
    @NotNull
    public static ILogger getLogger(@NotNull Class<?> clazz, @Nullable Class<? extends ILogger> loggerClass) {
        if (loggerClass != null) {
            setLoggerType(loggerClass);
            return logManager.invokeLogger(loggerClass, clazz);
        }

        return logManager.invokeLogger(LogProvider.loggerClass, clazz);
    }

    /**
     * <h6>Provides access to the {@linkplain LogManager} instance used by the {@linkplain LogProvider}.
     *
     * @return the {@linkplain LogManager} instance.
     */
    @NotNull
    public static LogManager getLogManager() {
        return logManager;
    }
}