package me.caden.complog.loggers;

import me.caden.complog.ILogger;
import me.caden.complog.util.StringFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class CommonsLogger implements ILogger {
    private final Log commonsLogger;

    private final String regex = "{}";

    public CommonsLogger(Class<?> parentClass) {
        this.commonsLogger = LogFactory.getLog(parentClass);
    }

    @Override
    public void fatal(Object message) {
        commonsLogger.fatal(message);
    }

    @Override
    public void fatal(Object message, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.fatal(stringFormat.format());
    }

    @Override
    public void fatal(Object message, Throwable throwable) {
        commonsLogger.fatal(message, throwable);
    }

    @Override
    public void fatal(Object message, Throwable throwable, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.fatal(stringFormat.format(), throwable);
    }

    @Override
    public void error(Object message) {
        commonsLogger.error(message);
    }

    @Override
    public void error(Object message, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.error(stringFormat.format());
    }

    @Override
    public void error(Object message, Throwable throwable) {
        commonsLogger.error(message, throwable);
    }

    @Override
    public void error(Object message, Throwable throwable, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.error(stringFormat.format(), throwable);
    }

    @Override
    public void warn(Object message) {
        commonsLogger.warn(message);
    }

    @Override
    public void warn(Object message, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.warn(stringFormat.format());
    }

    @Override
    public void warn(Object message, Throwable throwable) {
        commonsLogger.warn(message, throwable);
    }

    @Override
    public void warn(Object message, Throwable throwable, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.warn(stringFormat.format(), throwable);
    }

    @Override
    public void info(Object message) {
        commonsLogger.info(message);
    }

    @Override
    public void info(Object message, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.info(stringFormat.format());
    }

    @Override
    public void info(Object message, Throwable throwable) {
        commonsLogger.info(message, throwable);
    }

    @Override
    public void info(Object message, Throwable throwable, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.info(stringFormat.format(), throwable);
    }

    @Override
    public void debug(Object message) {
        commonsLogger.debug(message);
    }

    @Override
    public void debug(Object message, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.debug(stringFormat.format());
    }

    @Override
    public void debug(Object message, Throwable throwable) {
        commonsLogger.debug(message, throwable);
    }

    @Override
    public void debug(Object message, Throwable throwable, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.debug(stringFormat.format(), throwable);
    }

    @Override
    public void trace(Object message) {
        commonsLogger.trace(message);
    }

    @Override
    public void trace(Object message, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.trace(stringFormat.format());
    }

    @Override
    public void trace(Object message, Throwable throwable) {
        commonsLogger.trace(message, throwable);
    }

    @Override
    public void trace(Object message, Throwable throwable, Object... obj) {
        StringFormat stringFormat = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        commonsLogger.trace(stringFormat.format(), throwable);
    }
}