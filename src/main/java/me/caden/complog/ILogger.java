package me.caden.complog;

/**
 * <h6>A standard interface for logging messages at various levels of severity.
 *
 * <p>This interface provides methods for logging messages across different
 * severity levels, from fatal errors to trace-level debugging. Implementations
 * of this interface should define how these messages are handled, whether they
 * are written to a file, displayed on the console, or sent to an external logging service.</p>
 *
 * <p>The logging methods offer flexibility by allowing messages to be logged
 * with optional formatting arguments, as well as including throwable exceptions
 * for stack trace information.</p>
 *
 * <p>Each method has overloaded variants to accommodate different use cases,
 * ensuring that loggers can be used effectively in a variety of scenarios.</p>
 *
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public interface ILogger {

    /**
     * <h6>Logs a fatal message indicating a critical error that may cause the application to terminate.
     *
     * @param message the message to log.
     */
    void fatal(Object message);

    /**
     * <h6>Logs a fatal message with additional formatting arguments.
     *
     * @param message the message to log.
     * @param obj additional objects to be formatted into the message.
     */
    void fatal(Object message, Object... obj);

    /**
     * <h6>Logs a fatal message along with a throwable for capturing stack trace information.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the fatal error.
     */
    void fatal(Object message, Throwable throwable);

    /**
     * <h6>Logs a fatal message with additional formatting arguments and a throwable.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the fatal error.
     * @param obj additional objects to be formatted into the message.
     */
    void fatal(Object message, Throwable throwable, Object... obj);

    /**
     * <h6>Logs an error message indicating a significant problem that might impact functionality.
     *
     * @param message the message to log.
     */
    void error(Object message);

    /**
     * <h6>Logs an error message with additional formatting arguments.
     *
     * @param message the message to log.
     * @param obj additional objects to be formatted into the message.
     */
    void error(Object message, Object... obj);

    /**
     * <h6>Logs an error message along with a throwable for capturing stack trace information.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the error.
     */
    void error(Object message, Throwable throwable);

    /**
     * <h6>Logs an error message with additional formatting arguments and a throwable.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the error.
     * @param obj additional objects to be formatted into the message.
     */
    void error(Object message, Throwable throwable, Object... obj);

    /**
     * <h6>Logs a warning message indicating a potential problem or important situation to be aware of.
     *
     * @param message the message to log.
     */
    void warn(Object message);

    /**
     * <h6>Logs a warning message with additional formatting arguments.
     *
     * @param message the message to log.
     * @param obj additional objects to be formatted into the message.
     */
    void warn(Object message, Object... obj);

    /**
     * <h6>Logs a warning message along with a throwable for capturing stack trace information.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the warning.
     */
    void warn(Object message, Throwable throwable);

    /**
     * <h6>Logs a warning message with additional formatting arguments and a throwable.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the warning.
     * @param obj additional objects to be formatted into the message.
     */
    void warn(Object message, Throwable throwable, Object... obj);

    /**
     * <h6>Logs an informational message to provide general operational information.
     *
     * @param message the message to log.
     */
    void info(Object message);

    /**
     * <h6>Logs an informational message with additional formatting arguments.
     *
     * @param message the message to log.
     * @param obj additional objects to be formatted into the message.
     */
    void info(Object message, Object... obj);

    /**
     * <h6>Logs an informational message along with a throwable for capturing stack trace information.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the informational message.
     */
    void info(Object message, Throwable throwable);

    /**
     * <h6>Logs an informational message with additional formatting arguments and a throwable.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the informational message.
     * @param obj additional objects to be formatted into the message.
     */
    void info(Object message, Throwable throwable, Object... obj);

    /**
     * <h6>Logs a debug message for detailed technical information useful during development.
     *
     * @param message the message to log.
     */
    void debug(Object message);

    /**
     * <h6>Logs a debug message with additional formatting arguments.
     *
     * @param message the message to log.
     * @param obj additional objects to be formatted into the message.
     */
    void debug(Object message, Object... obj);

    /**
     * <h6>Logs a debug message along with a throwable for capturing stack trace information.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the debug message.
     */
    void debug(Object message, Throwable throwable);

    /**
     * <h6>Logs a debug message with additional formatting arguments and a throwable.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the debug message.
     * @param obj additional objects to be formatted into the message.
     */
    void debug(Object message, Throwable throwable, Object... obj);

    /**
     * <h6>Logs a trace message for the most detailed level of logging, often used for low-level debugging.
     *
     * @param message the message to log.
     */
    void trace(Object message);

    /**
     * <h6>Logs a trace message with additional formatting arguments.
     *
     * @param message the message to log.
     * @param obj additional objects to be formatted into the message.
     */
    void trace(Object message, Object... obj);

    /**
     * <h6>Logs a trace message along with a throwable for capturing stack trace information.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the trace message.
     */
    void trace(Object message, Throwable throwable);

    /**
     * <h6>Logs a trace message with additional formatting arguments and a throwable.
     *
     * @param message the message to log.
     * @param throwable the throwable associated with the trace message.
     * @param obj additional objects to be formatted into the message.
     */
    void trace(Object message, Throwable throwable, Object... obj);

}