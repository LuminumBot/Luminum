package io.github.luminumbot.luminum;

import io.github.luminumbot.luminum.commands.ChannelTestCommand;
import io.github.luminumbot.luminum.commands.PingCommand;
import io.github.luminumbot.luminum.commands.RegdateCommand;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Luminum {

    private static final DiscordApi api = new DiscordApiBuilder()
            .setToken(System.getenv("LUMINUM_TOKEN"))
            .login()
            .join();

    public static DiscordApi getApi() {
        return api;
    }

    public static void main(String[] args) {
        api.addSlashCommandCreateListener(new PingCommand());
        api.addSlashCommandCreateListener(new ChannelTestCommand());
        api.addSlashCommandCreateListener(new RegdateCommand());
    }
}