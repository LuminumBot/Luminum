package io.github.luminumbot.luminum;

import io.github.luminumbot.luminum.commands.GptImageCommand;
import io.github.luminumbot.luminum.commands.GptTextCommand;
import io.github.luminumbot.luminum.commands.PingCommand;
import io.github.luminumbot.luminum.commands.RegdateCommand;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import static io.github.luminumbot.luminum.Config.DISCORD_TOKEN;

public class Luminum {

    private static final DiscordApi api = new DiscordApiBuilder()
            .setToken(DISCORD_TOKEN)
            .login()
            .join();

    public static DiscordApi getApi() {
        return api;
    }

    public static void main(String[] args) {
        api.addSlashCommandCreateListener(new PingCommand());
        api.addSlashCommandCreateListener(new GptTextCommand());
        api.addSlashCommandCreateListener(new RegdateCommand());
        api.addSlashCommandCreateListener(new GptImageCommand());
    }
}