package io.github.luminumbot.luminum.commands;

import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;

import java.text.SimpleDateFormat;
import java.util.Date;

import static io.github.luminumbot.luminum.utils.Date.convertIDtoUnix;

public class RegdateCommand extends AbstractSlashCommand {
    public RegdateCommand() {
        super("regdate", "Get user registration date");
    }

    @Override
    public void slashCommandHandler(SlashCommandInteraction interaction, String name, String description, SlashCommandCreateEvent event) {
        interaction
                .createImmediateResponder()
                .setContent("Your registration date: " + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(
                                convertIDtoUnix(interaction.getUser().getId())
                        ))
                )
                .respond();
    }
}
