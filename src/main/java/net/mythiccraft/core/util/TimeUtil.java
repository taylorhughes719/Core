package net.mythiccraft.core.util;

import java.util.concurrent.TimeUnit;

/**
 * Time utilities.
 */
public class TimeUtil {

    /**
     * Convert minutes to seconds.
     *
     * @param time The time in minutes
     * @return The time in seconds
     */
    public static long fromMinutesToSeconds(long time) {
        return TimeUnit.MINUTES.toSeconds(time);
    }

    /**
     * Convert seconds to minutes.
     *
     * @param time The time in seconds
     * @return The time in minutes
     */
    public static long fromSecondsToMinutes(long time) {
        return TimeUnit.SECONDS.toMinutes(time);
    }

    /**
     * Convert ticks to seconds.
     *
     * @param time The time in ticks
     * @return The time in seconds
     */
    public static long fromTicksToSeconds(long time) {
        return time / 20;
    }

    /**
     * Convert seconds to ticks.
     *
     * @param time The time in seconds
     * @return The time in ticks
     */
    public static long fromSecondsToTicks(long time) {
        return time * 20;
    }

    /**
     * Get the current system time in milliseconds.
     *
     * @return The time
     */
    public static long getSystemTimeMS() {
        return System.currentTimeMillis();
    }
}
