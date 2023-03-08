package io.github.luminumbot.luminum;

import io.github.luminumbot.luminum.commands.RegdateCommand;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandInteraction;

public class Luminum {

    private static final DiscordApi api = new DiscordApiBuilder()
            .setToken(System.getenv("LUMINUM_TOKEN"))
            .login()
            .join();

    public static DiscordApi getApi() {
        return api;
    }

    public static void main(String[] args) {
        SlashCommand.with("ping", "Check bot latency")
                .createGlobal(api)
                .join();


        api.addSlashCommandCreateListener(event -> {
            SlashCommandInteraction interaction = event.getSlashCommandInteraction();

            if (interaction.getFullCommandName().equals("ping")) {
                interaction
                        .createImmediateResponder()
                        .setContent("Pong")
                        .respond();
            }
        });
        api.addSlashCommandCreateListener(new RegdateCommand());
    }
}