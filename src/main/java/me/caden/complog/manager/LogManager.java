package me.caden.complog.manager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import me.caden.complog.ILogger;
import me.caden.complog.LogProvider;
import me.caden.complog.LogSearch;
import me.caden.complog.search.CommonsSearch;
import me.caden.complog.search.Log4JSearch;
import me.caden.complog.search.Slf4jSearch;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static me.caden.complog.LogProvider.JUL_PRIORITY;

/**
 * <h6>Manages the instantiation and selection of different logger implementations.
 *
 * <p>This class acts as the central point for handling various logging frameworks
 * by delegating logger creation and management based on the provided search strategies
 * and priority levels. It supports adding new logger types dynamically and choosing
 * the most appropriate logger based on compatibility checks and priorities.</p>
 *
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class LogManager {
    private final Map<String, Constructor<? extends ILogger>> loggerTypes = new HashMap<>();
    private final Map<String, LogSearch> loggerSearches = new HashMap<>();

    private Constructor<? extends ILogger> chosenLogger = null;
    private int highestPriority = 0;

    /**
     * Initializes the LogManager with predefined logger types and their corresponding search strategies.
     */
    public LogManager() {
        addLogger("me.caden.complog.loggers.CommonsLogger", new CommonsSearch());
        addLogger("me.caden.complog.loggers.Log4JLogger", new Log4JSearch());
        addLogger("me.caden.complog.loggers.JULLogger", () -> true, JUL_PRIORITY);
        addLogger("me.caden.complog.loggers.LogbackLogger", new Slf4jSearch());
        addLogger("me.caden.complog.loggers.Slf4jLogger", new Slf4jSearch());
    }

    /**
     * <h6>Invokes the appropriate logger based on the specified class.
     *
     * @param loggerClass the class of the logger to be invoked.
     * @param args additional arguments required for logger instantiation.
     * @return an instance of the logger, or null if the loggerClass is null.
     * @throws IllegalArgumentException if the loggerClass is ILogger itself.
     */
    public ILogger invokeLogger(@Nullable Class<? extends ILogger> loggerClass, Object... args) {
        if (loggerClass == null) {
            return invokeNullLogger(args);
        }

        if (loggerClass.equals(ILogger.class)) {
            // Can't invoke ILogger itself
            throw new IllegalArgumentException("Can only invoke an `ILogger` class");
        }

        Constructor<? extends ILogger> constructor = loggerTypes.get(loggerClass.getName());
        if (constructor == null) {
            throw new RuntimeException("Logger class not found: " + loggerClass.getName());
        }

        try {
            return constructor.newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <h6>Invokes the most suitable logger when no specific logger class is provided.
     *
     * @param args additional arguments required for logger instantiation.
     * @return an instance of the most suitable logger.
     */
    private ILogger invokeNullLogger(Object... args) {
        loggerSearches.forEach((key, value) -> {
            if (value.getPriority() > highestPriority && value.isCompatible()) {
                highestPriority = value.getPriority();
                chosenLogger = loggerTypes.get(key);
            }
        });

        try {
            return chosenLogger.newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        } finally {
            LogProvider.setLoggerType(chosenLogger.getDeclaringClass());
        }
    }

    /**
     * <h6>Adds a new logger type to the manager with a specified search strategy.
     *
     * @param loggerClass the class of the logger to add.
     * @param logSearch the search strategy for determining compatibility.
     */
    public void addLogger(@NotNull Class<? extends ILogger> loggerClass, @Nullable LogSearch logSearch) {
        try {
            Constructor<? extends ILogger> constructor = loggerClass.getConstructor(Class.class);
            loggerTypes.put(loggerClass.getName(), constructor);
            loggerSearches.put(loggerClass.getName(), logSearch == null ? () -> true : logSearch);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <h6>Adds a new logger type to the manager with a specified search strategy and priority.
     *
     * @param loggerClass the class of the logger to add.
     * @param logSearch the search strategy for determining compatibility.
     * @param priority the priority level of this logger.
     */
    public void addLogger(@NotNull Class<? extends ILogger> loggerClass, @Nullable LogSearch logSearch, int priority) {
        try {
            Constructor<? extends ILogger> constructor = loggerClass.getConstructor(Class.class);
            loggerTypes.put(loggerClass.getName(), constructor);
            loggerSearches.put(loggerClass.getName(), logSearch == null ? new PriorityDelegatingLogSearch(() -> true, priority) : new PriorityDelegatingLogSearch(logSearch, priority));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <h6>Adds a new logger type by its class name.
     *
     * @param className the fully qualified name of the logger class.
     * @param logSearch the search strategy for determining compatibility.
     */
    public void addLogger(@NotNull String className, @Nullable LogSearch logSearch) {
        try {
            Class<?> loggerClass = Class.forName(className);
            addLogger((Class<? extends ILogger>) loggerClass, logSearch);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <h6>Adds a new logger type by its class name with a specified priority.
     *
     * @param className the fully qualified name of the logger class.
     * @param logSearch the search strategy for determining compatibility.
     * @param priority the priority level of this logger.
     */
    public void addLogger(@NotNull String className, @Nullable LogSearch logSearch, int priority) {
        try {
            Class<?> loggerClass = Class.forName(className);
            // noinspection unchecked
            addLogger((Class<? extends ILogger>) loggerClass, logSearch, priority);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <h6>Changes the priority of an existing logger class.
     *
     * @param loggerClass the class of the logger whose priority is to be changed.
     * @param newPriority the new priority level.
     * @return true if the priority was successfully changed, false otherwise.
     */
    public boolean changePriority(@NotNull Class<? extends ILogger> loggerClass, int newPriority) {
        return changePriority(loggerClass.getName(), newPriority);
    }

    /**
     * <h6>Changes the priority of an existing logger class by its class name.
     *
     * @param className the fully qualified name of the logger class.
     * @param newPriority the new priority level.
     * @return true if the priority was successfully changed, false otherwise.
     */
    public boolean changePriority(@NotNull String className, int newPriority) {
        LogSearch logSearch = loggerSearches.get(className);
        if (logSearch != null) {
            loggerSearches.put(className, new PriorityDelegatingLogSearch(logSearch, newPriority));
            return true;
        }
        return false;
    }

    /**
     * <h6>A class that delegates log search functionality and incorporates priority.
     *
     * <p>This class wraps another {@linkplain LogSearch} implementation, adding a priority level
     * to influence the selection of loggers based on their compatibility and priority.</p>
     */
    @SuppressWarnings("ClassCanBeRecord")
    private static class PriorityDelegatingLogSearch implements LogSearch {
        private final LogSearch parentSearch;
        private final int priority;

        private PriorityDelegatingLogSearch(LogSearch parentSearch, int priority) {
            this.parentSearch = parentSearch;
            this.priority = priority;
        }

        @Override
        public boolean isCompatible() {
            return parentSearch.isCompatible();
        }

        @Override
        public int getPriority() {
            return priority;
        }
    }
}