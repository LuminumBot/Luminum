package io.github.luminumbot.luminum.commands;

import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.SlashCommandOptionType;

import java.util.Collections;
import java.util.List;

import static io.github.luminumbot.luminum.utils.OpenAI.answerGPT;

public class GptCommand extends AbstractSlashCommand {
    public GptCommand() {
        super("chatgpt", "Получить ответ от нееросети", getOptions());
    }

    private static List<SlashCommandOption> getOptions() {
        return Collections.singletonList(
                SlashCommandOption.create(SlashCommandOptionType.STRING, "text", "Text to SendChatGPT", true)
        );
    }

    @Override
    public void slashCommandHandler(SlashCommandInteraction interaction, String name, String description, SlashCommandCreateEvent event) {
        interaction
                .respondLater()
                .thenAccept(interactionOriginalResponseUpdater ->
                        interactionOriginalResponseUpdater.setContent(answerGPT(interaction.getUser().getId(),
                                interaction.getArguments().get(0).getStringValue().get()))
                                .update());
    }
}
