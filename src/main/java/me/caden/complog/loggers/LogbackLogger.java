package me.caden.complog.loggers;

import me.caden.complog.ILogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class LogbackLogger implements ILogger {
    private final Logger logbackLogger;

    public LogbackLogger(Class<?> parentClass) {
        logbackLogger = LoggerFactory.getLogger(parentClass);
    }

    @Override
    public void fatal(Object message) {
        logbackLogger.error(message.toString());
    }

    @Override
    public void fatal(Object message, Object... obj) {
        logbackLogger.error(message.toString(), obj);
    }

    @Override
    public void fatal(Object message, Throwable throwable) {
        logbackLogger.error(message.toString(), throwable);
    }

    @Override
    public void fatal(Object message, Throwable throwable, Object... obj) {
        logbackLogger.error(message.toString(), throwable, obj);
    }

    @Override
    public void error(Object message) {
        logbackLogger.error(message.toString());
    }

    @Override
    public void error(Object message, Object... obj) {
        logbackLogger.error(message.toString(), obj);
    }

    @Override
    public void error(Object message, Throwable throwable) {
        logbackLogger.error(message.toString(), throwable);
    }

    @Override
    public void error(Object message, Throwable throwable, Object... obj) {
        logbackLogger.error(message.toString(), throwable, obj);
    }

    @Override
    public void warn(Object message) {
        logbackLogger.warn(message.toString());
    }

    @Override
    public void warn(Object message, Object... obj) {
        logbackLogger.warn(message.toString(), obj);
    }

    @Override
    public void warn(Object message, Throwable throwable) {
        logbackLogger.warn(message.toString(), throwable);
    }

    @Override
    public void warn(Object message, Throwable throwable, Object... obj) {
        logbackLogger.warn(message.toString(), throwable, obj);
    }

    @Override
    public void info(Object message) {
        logbackLogger.info(message.toString());
    }

    @Override
    public void info(Object message, Object... obj) {
        logbackLogger.info(message.toString(), obj);
    }

    @Override
    public void info(Object message, Throwable throwable) {
        logbackLogger.info(message.toString(), throwable);
    }

    @Override
    public void info(Object message, Throwable throwable, Object... obj) {
        logbackLogger.info(message.toString(), throwable, obj);
    }

    @Override
    public void debug(Object message) {
        logbackLogger.debug(message.toString());
    }

    @Override
    public void debug(Object message, Object... obj) {
        logbackLogger.debug(message.toString(), obj);
    }

    @Override
    public void debug(Object message, Throwable throwable) {
        logbackLogger.debug(message.toString(), throwable);
    }

    @Override
    public void debug(Object message, Throwable throwable, Object... obj) {
        logbackLogger.debug(message.toString(), throwable, obj);
    }

    @Override
    public void trace(Object message) {
        logbackLogger.trace(message.toString());
    }

    @Override
    public void trace(Object message, Object... obj) {
        logbackLogger.trace(message.toString(), obj);
    }

    @Override
    public void trace(Object message, Throwable throwable) {
        logbackLogger.trace(message.toString(), throwable);
    }

    @Override
    public void trace(Object message, Throwable throwable, Object... obj) {
        logbackLogger.trace(message.toString(), throwable, obj);
    }
}