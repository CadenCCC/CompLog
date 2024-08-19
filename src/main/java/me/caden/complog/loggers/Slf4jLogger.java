package me.caden.complog.loggers;

import me.caden.complog.ILogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class Slf4jLogger implements ILogger { // TODO: add javadocs saying that fatal is actually a error because of slf4j lib
    private final Logger slf4jLogger;

    public Slf4jLogger(Class<?> parentClass) {
        this.slf4jLogger = LoggerFactory.getLogger(parentClass);
    }

    @Override
    public void fatal(Object message) {
        slf4jLogger.error(message.toString());
    }

    @Override
    public void fatal(Object message, Object... obj) {
        slf4jLogger.error(message.toString(), obj);
    }

    @Override
    public void fatal(Object message, Throwable throwable) {
        slf4jLogger.error(message.toString(), throwable);
    }

    @Override
    public void fatal(Object message, Throwable throwable, Object... obj) {
        slf4jLogger.error(message.toString(), throwable, obj);
    }

    @Override
    public void error(Object message) {
        slf4jLogger.error(message.toString());
    }

    @Override
    public void error(Object message, Object... obj) {
        slf4jLogger.error(message.toString(), obj);
    }

    @Override
    public void error(Object message, Throwable throwable) {
        slf4jLogger.error(message.toString(), throwable);
    }

    @Override
    public void error(Object message, Throwable throwable, Object... obj) {
        slf4jLogger.error(message.toString(), throwable, obj);
    }

    @Override
    public void warn(Object message) {
        slf4jLogger.warn(message.toString());
    }

    @Override
    public void warn(Object message, Object... obj) {
        slf4jLogger.warn(message.toString(), obj);
    }

    @Override
    public void warn(Object message, Throwable throwable) {
        slf4jLogger.warn(message.toString(), throwable);
    }

    @Override
    public void warn(Object message, Throwable throwable, Object... obj) {
        slf4jLogger.warn(message.toString(), throwable, obj);
    }

    @Override
    public void info(Object message) {
        slf4jLogger.info(message.toString());
    }

    @Override
    public void info(Object message, Object... obj) {
        slf4jLogger.info(message.toString(), obj);
    }

    @Override
    public void info(Object message, Throwable throwable) {
        slf4jLogger.info(message.toString(), throwable);
    }

    @Override
    public void info(Object message, Throwable throwable, Object... obj) {
        slf4jLogger.info(message.toString(), throwable, obj);
    }

    @Override
    public void debug(Object message) {
        slf4jLogger.debug(message.toString());
    }

    @Override
    public void debug(Object message, Object... obj) {
        slf4jLogger.debug(message.toString(), obj);
    }

    @Override
    public void debug(Object message, Throwable throwable) {
        slf4jLogger.debug(message.toString(), throwable);
    }

    @Override
    public void debug(Object message, Throwable throwable, Object... obj) {
        slf4jLogger.debug(message.toString(), throwable, obj);
    }

    @Override
    public void trace(Object message) {
        slf4jLogger.trace(message.toString());
    }

    @Override
    public void trace(Object message, Object... obj) {
        slf4jLogger.trace(message.toString(), obj);
    }

    @Override
    public void trace(Object message, Throwable throwable) {
        slf4jLogger.trace(message.toString(), throwable);
    }

    @Override
    public void trace(Object message, Throwable throwable, Object... obj) {
        slf4jLogger.trace(message.toString(), throwable, obj);
    }
}