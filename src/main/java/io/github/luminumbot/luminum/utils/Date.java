package io.github.luminumbot.luminum.utils;

public class Date {
    public static long convertIDtoUnix(long id) {
        var bin = Long.toBinaryString(id);
        var m = 64 - bin.length();
        var unixbin = bin.substring(0, 42 - m);
        return Long.parseLong(unixbin, 2) + 1420070400000L;
    }
}
