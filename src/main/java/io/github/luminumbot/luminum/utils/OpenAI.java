package io.github.luminumbot.luminum.utils;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import static io.github.luminumbot.luminum.Config.*;

public class OpenAI {
    private static final OpenAiService service = new OpenAiService(OPENAI_TOKEN);

    public String answerGPT(Long id, String question) {
        if (question.length() < 5) {
            return "Your message too short";
        }
        CompletionRequest request = CompletionRequest.builder()
                .prompt(question)
                .model(OPENAI_MODEL)
                .echo(true)
                .temperature(OPENAI_TEMPERATURE)
                .maxTokens(OPENAI_MAX_TOKENS)
                .build();
        return service.createCompletion(request).getChoices().get(0).getText();
    }

}