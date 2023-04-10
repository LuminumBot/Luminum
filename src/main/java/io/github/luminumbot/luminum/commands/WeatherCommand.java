package io.github.luminumbot.luminum.commands;

import io.github.luminumbot.luminum.utils.WeatherAPI;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.SlashCommandOptionType;

import java.util.Collections;
import java.util.List;

public class WeatherCommand extends AbstractSlashCommand {
    public WeatherCommand() {
        super("weather", "Узнайте погоду в вашем городе", getOptions());
    }

    private static List<SlashCommandOption> getOptions() {
        return Collections.singletonList(
                SlashCommandOption.create(SlashCommandOptionType.STRING, "city", "City where get weather", true)
        );
    }

    @Override
    public void slashCommandHandler(SlashCommandInteraction interaction, String name, String description, SlashCommandCreateEvent event) {
        List<String> weather = WeatherAPI.getWeather(interaction.getArguments().get(0).getStringValue().get());
        interaction
                .createImmediateResponder()
                .setContent(weather.get(0) + "\n" + weather.get(1))
                .respond();
    }
}
