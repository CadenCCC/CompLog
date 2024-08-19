package me.caden.complog.loggers;

import me.caden.complog.ILogger;
import me.caden.complog.util.StringFormat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class JULLogger implements ILogger { // TODO: write java docs explaining how JUL doesnt have LEVEL's needed to have separate shit
    private final Logger julLogger;

    private final String regex = "{}";

    public JULLogger(Class<?> parentClass) {
        this.julLogger = Logger.getLogger(parentClass.getName());
    }

    @Override
    public void fatal(Object message) {
        julLogger.log(Level.SEVERE, message.toString());
    }

    @Override
    public void fatal(Object message, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.SEVERE, format.toString());
    }

    @Override
    public void fatal(Object message, Throwable throwable) {
        julLogger.log(Level.SEVERE, message.toString(), throwable);
    }

    @Override
    public void fatal(Object message, Throwable throwable, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.SEVERE, format.toString(), throwable);
    }

    @Override
    public void error(Object message) {
        julLogger.log(Level.SEVERE, message.toString());
    }

    @Override
    public void error(Object message, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.SEVERE, format.toString());
    }

    @Override
    public void error(Object message, Throwable throwable) {
        julLogger.log(Level.SEVERE, message.toString(), throwable);
    }

    @Override
    public void error(Object message, Throwable throwable, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.SEVERE, format.toString(), throwable);
    }

    @Override
    public void warn(Object message) {
        julLogger.log(Level.WARNING, message.toString());
    }

    @Override
    public void warn(Object message, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.WARNING, format.toString());
    }

    @Override
    public void warn(Object message, Throwable throwable) {
        julLogger.log(Level.WARNING, message.toString(), throwable);
    }

    @Override
    public void warn(Object message, Throwable throwable, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.WARNING, format.toString(), throwable);
    }

    @Override
    public void info(Object message) {
        julLogger.log(Level.INFO, message.toString());
    }

    @Override
    public void info(Object message, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.INFO, format.toString());
    }

    @Override
    public void info(Object message, Throwable throwable) {
        julLogger.log(Level.INFO, message.toString(), throwable);
    }

    @Override
    public void info(Object message, Throwable throwable, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.INFO, format.toString(), throwable);
    }

    @Override
    public void debug(Object message) {
        julLogger.log(Level.ALL, message.toString());
    }

    @Override
    public void debug(Object message, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.ALL, format.toString());
    }

    @Override
    public void debug(Object message, Throwable throwable) {
        julLogger.log(Level.ALL, message.toString(), throwable);
    }

    @Override
    public void debug(Object message, Throwable throwable, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.ALL, format.toString(), throwable);
    }

    @Override
    public void trace(Object message) {
        julLogger.log(Level.SEVERE, message.toString());
    }

    @Override
    public void trace(Object message, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.SEVERE, format.toString());
    }

    @Override
    public void trace(Object message, Throwable throwable) {
        julLogger.log(Level.SEVERE, message.toString(), throwable);
    }

    @Override
    public void trace(Object message, Throwable throwable, Object... obj) {
        StringFormat format = new StringFormat()
                .setRegex(regex)
                .setInputs(obj)
                .setOriginalString(message.toString());
        julLogger.log(Level.SEVERE, format.toString(), throwable);
    }
}