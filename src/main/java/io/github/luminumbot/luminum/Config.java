package io.github.luminumbot.luminum;

public final class Config {
    public static final String DISCORD_TOKEN = System.getenv("LUMINUM_TOKEN");
    public static final String OPENAI_TOKEN = System.getenv("OPENAI_TOKEN");
    public static final String WEATHER_TOKEN = System.getenv("WEATHER_TOKEN");
    public static final String YANDEX_TOKEN = System.getenv("YANDEX_TOKEN");
    public static final String OPENAI_MODEL = "text-davinci-002";
    public static final double OPENAI_TEMPERATURE = 1.2;
    public static final int OPENAI_MAX_TOKENS = 1024;
    private Config() {
        // Private constructor to prevent class instance creation
    }
}
