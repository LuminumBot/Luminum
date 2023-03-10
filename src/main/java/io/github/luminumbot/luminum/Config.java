package io.github.luminumbot.luminum;

public final class Config {
    public static final String DISCORD_TOKEN = System.getenv("LUMINUM_TOKEN");
    public static final String OPENAI_TOKEN = "OPENAI_TOKEN";
    public static final String OPENAI_MODEL = "text-davinci-003";
    public static final double OPENAI_TEMPERATURE = 0.4;
    public static final int OPENAI_MAX_TOKENS = 4000;
    private Config() {
        // Private constructor to prevent class instance creation
    }
}
