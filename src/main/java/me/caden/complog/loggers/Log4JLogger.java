package me.caden.complog.loggers;

import me.caden.complog.ILogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class Log4JLogger implements ILogger {
    private final Logger log4jLogger;

    public Log4JLogger(Class<?> parentClass) {
        this.log4jLogger = LogManager.getLogger(parentClass);
    }

    @Override
    public void fatal(Object message) {
        log4jLogger.fatal(message);
    }

    @Override
    public void fatal(Object message, Object... obj) {
        log4jLogger.fatal(message.toString(), obj);
    }

    @Override
    public void fatal(Object message, Throwable throwable) {
        log4jLogger.fatal(message.toString(), throwable);
    }

    @Override
    public void fatal(Object message, Throwable throwable, Object... obj) {
        log4jLogger.fatal(message.toString(), throwable, obj);
    }

    @Override
    public void error(Object message) {
        log4jLogger.error(message);
    }

    @Override
    public void error(Object message, Object... obj) {
        log4jLogger.error(message.toString(), obj);
    }

    @Override
    public void error(Object message, Throwable throwable) {
        log4jLogger.error(message.toString(), throwable);
    }

    @Override
    public void error(Object message, Throwable throwable, Object... obj) {
        log4jLogger.error(message.toString(), throwable, obj);
    }

    @Override
    public void warn(Object message) {
        log4jLogger.warn(message);
    }

    @Override
    public void warn(Object message, Object... obj) {
        log4jLogger.warn(message.toString(), obj);
    }

    @Override
    public void warn(Object message, Throwable throwable) {
        log4jLogger.warn(message.toString(), throwable);
    }

    @Override
    public void warn(Object message, Throwable throwable, Object... obj) {
        log4jLogger.warn(message.toString(), throwable, obj);
    }

    @Override
    public void info(Object message) {
        log4jLogger.info(message);
    }

    @Override
    public void info(Object message, Object... obj) {
        log4jLogger.info(message.toString(), obj);
    }

    @Override
    public void info(Object message, Throwable throwable) {
        log4jLogger.info(message.toString(), throwable);
    }

    @Override
    public void info(Object message, Throwable throwable, Object... obj) {
        log4jLogger.info(message.toString(), throwable, obj);
    }

    @Override
    public void debug(Object message) {
        log4jLogger.debug(message);
    }

    @Override
    public void debug(Object message, Object... obj) {
        log4jLogger.debug(message.toString(), obj);
    }

    @Override
    public void debug(Object message, Throwable throwable) {
        log4jLogger.debug(message.toString(), throwable);
    }

    @Override
    public void debug(Object message, Throwable throwable, Object... obj) {
        log4jLogger.debug(message.toString(), throwable, obj);
    }

    @Override
    public void trace(Object message) {
        log4jLogger.trace(message);
    }

    @Override
    public void trace(Object message, Object... obj) {
        log4jLogger.trace(message.toString(), obj);
    }

    @Override
    public void trace(Object message, Throwable throwable) {
        log4jLogger.trace(message.toString(), throwable);
    }

    @Override
    public void trace(Object message, Throwable throwable, Object... obj) {
        log4jLogger.trace(message.toString(), throwable, obj);
    }
}