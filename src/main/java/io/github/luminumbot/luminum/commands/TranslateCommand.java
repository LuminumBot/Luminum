package io.github.luminumbot.luminum.commands;

import io.github.luminumbot.luminum.utils.Yandex;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.SlashCommandOptionType;

import java.util.ArrayList;
import java.util.List;


public class TranslateCommand extends AbstractSlashCommand {

    public TranslateCommand() {
        super("translate", "Перевести текст", getOptions());
    }

    private static List<SlashCommandOption> getOptions() {
        List<SlashCommandOption> list = new ArrayList<>();
        list.add(SlashCommandOption.create(SlashCommandOptionType.STRING, "text", "Text to translate", true));
        list.add(SlashCommandOption.create(SlashCommandOptionType.STRING, "language", "Language to be translated", true));
        return list;
    }

    @Override
    public void slashCommandHandler(SlashCommandInteraction interaction, String name, String description, SlashCommandCreateEvent event) {
        interaction
                .respondLater()
                .thenAccept(interactionOriginalResponseUpdater ->
                        interactionOriginalResponseUpdater.setContent(Yandex.getTranslate(interaction.getArguments().get(0).getStringValue().get(), interaction.getArguments().get(1).getStringValue().get()))
                                .update());
    }
}
