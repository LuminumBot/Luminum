package io.github.luminumbot.luminum.utils;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.service.OpenAiService;

import static io.github.luminumbot.luminum.Config.*;

public final class OpenAI {
    private static final OpenAiService service = new OpenAiService(OPENAI_TOKEN);

    public static String textAnswerGPT(Long id, String question) {
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

    public static String imageAnswerGPT(Long id, String question) {
        if (question.length() < 5) {
            return "Your message too short";
        }
        CreateImageRequest imageRequest = CreateImageRequest.builder()
                .prompt(question)
                .responseFormat("url")
                .n(1)
                .build();
        return service.createImage(imageRequest).getData().get(0).getUrl();
    }

}