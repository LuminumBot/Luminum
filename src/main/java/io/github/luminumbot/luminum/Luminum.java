package io.github.luminumbot.luminum;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandInteraction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Luminum {

    private static final DiscordApi api = new DiscordApiBuilder()
            .setToken(System.getenv("LUMINUM_TOKEN"))
            .login()
            .join();

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

        SlashCommand.with("regdate", "Get user registration date")
                .createGlobal(api)
                .join();

        api.addSlashCommandCreateListener(event -> {
            SlashCommandInteraction interaction = event.getSlashCommandInteraction();

            if (interaction.getFullCommandName().equals("regdate")) {
                interaction
                        .createImmediateResponder()
                        .setContent("Your registration date: " + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(
                                        convertIDtoUnix(interaction.getUser().getId())
                                ))
                        )
                        .respond();
            }
        });
    }

    private static long convertIDtoUnix(long id) {
        /* Note: id has to be str */
        var bin = Long.toBinaryString(id);
        var m = 64 - bin.length();
        var unixbin = bin.substring(0, 42 - m);
        return Long.parseLong(unixbin, 2) + 1420070400000L;
    }
}