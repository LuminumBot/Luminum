package io.github.luminumbot.luminum.commands;

import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;

import java.time.Duration;
import java.time.Instant;

public class PingCommand extends AbstractSlashCommand {
    public PingCommand() {
        super("ping", "Check bot latency");
    }

    @Override
    public void slashCommandHandler(SlashCommandInteraction interaction, String name, String description, SlashCommandCreateEvent event) {
        Instant now = Instant.now();
        Instant interactionTime = Instant.ofEpochMilli(interaction.getCreationTimestamp().toEpochMilli());
        long duration = Duration.between(interactionTime, now).toMillis();
        interaction
                .createImmediateResponder()
                .setContent("Pong " + duration + "мс")
                .respond();
    }
}
