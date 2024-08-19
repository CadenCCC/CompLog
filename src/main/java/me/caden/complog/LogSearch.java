package me.caden.complog;

/**
 * <h6>Defines a contract for determining the compatibility of a logger type.
 *
 * <p>This interface allows different loggers to implement custom logic for checking
 * whether they are suitable for use in the current environment. The priority level
 * is used to influence the order in which loggers are selected.</p>
 *
 * <p>Implementations should override the {@linkplain #isCompatible()} method to define the
 * compatibility logic and may optionally override the {@linkplain #getPriority()} method
 * to specify the priority level.</p>
 *
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public interface LogSearch {

    /**
     * <h6>Checks if the logger type is compatible with the current environment.
     *
     * @return true if the logger type is compatible, false otherwise.
     */
    boolean isCompatible();

    /**
     * <h6>Retrieves the priority level of this logger type.
     *
     * @return the priority level, where higher values indicate higher priority.
     */
    default int getPriority() {
        return 0;
    }

}