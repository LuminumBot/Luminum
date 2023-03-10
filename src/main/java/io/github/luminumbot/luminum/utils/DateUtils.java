package io.github.luminumbot.luminum.utils;

public final class DateUtils {
    private DateUtils() {
        // Private constructor to prevent class instance creation
    }

    public static long discordIdToUnixTime(long id) {
        var bin = Long.toBinaryString(id);
        var m = 64 - bin.length();
        var unixBin = bin.substring(0, 42 - m);
        return Long.parseLong(unixBin, 2) + 1420070400000L;
    }
}
