package io.github.luminumbot.luminum.commands;

import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandBuilder;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

import static io.github.luminumbot.luminum.Luminum.getApi;

public abstract class AbstractSlashCommand implements SlashCommandCreateListener {
    private final String name;
    private final String description;

    public AbstractSlashCommand(String name, String description) {
        SlashCommandBuilder commandBuilder = SlashCommand.with(name, description);
        commandBuilder.createGlobal(getApi()).join();
        this.name = name;
        this.description = description;
    }

    public abstract void slashCommandHandler(SlashCommandInteraction interaction, String name, String description, SlashCommandCreateEvent event);
    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        SlashCommandInteraction interaction = event.getSlashCommandInteraction();
        if (interaction.getFullCommandName().equals(name)) {
            slashCommandHandler(interaction, name, description, event);
        }
    }
}
