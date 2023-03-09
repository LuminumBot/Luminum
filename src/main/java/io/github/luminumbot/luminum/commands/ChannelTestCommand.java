package io.github.luminumbot.luminum.commands;

import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.SlashCommandOptionChoice;
import org.javacord.api.interaction.SlashCommandOptionType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChannelTestCommand extends AbstractSlashCommand {
    public ChannelTestCommand() {
        super("channel", "A command dedicated to channels", getOptions());
    }

    private static List<SlashCommandOption> getOptions() {
        return Collections.singletonList(
                SlashCommandOption.createWithOptions(SlashCommandOptionType.SUB_COMMAND_GROUP, "edit", "Edits a channel",
                        Collections.singletonList(
                                SlashCommandOption.createWithOptions(SlashCommandOptionType.SUB_COMMAND, "allow", "Allows a permission to a user for a channel",
                                        Arrays.asList(
                                                SlashCommandOption.create(SlashCommandOptionType.CHANNEL, "channel", "The channel to modify", true),
                                                SlashCommandOption.create(SlashCommandOptionType.USER, "user", "The user which permissions should be changed", true),
                                                SlashCommandOption.createWithChoices(SlashCommandOptionType.DECIMAL, "permission", "The permission to allow", true,
                                                        Arrays.asList(
                                                                SlashCommandOptionChoice.create("manage", 0),
                                                                SlashCommandOptionChoice.create("show", 1)))
                                        )))));
    }

    @Override
    public void slashCommandHandler(SlashCommandInteraction interaction, String name, String description, SlashCommandCreateEvent event) {
        interaction
                .createImmediateResponder()
                .setContent("Hello")
                .respond();
    }
}
