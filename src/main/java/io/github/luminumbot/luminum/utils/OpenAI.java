package io.github.luminumbot.luminum.utils;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class OpenAI {
    private static final OpenAiService service = new OpenAiService("OPENAI_TOKEN");

    public String answerGPT(Long id, String question) {
        if (question.length() < 5) {
            return "Your message too short";
        }
        CompletionRequest request = CompletionRequest.builder()
                .prompt(question)
                .model("text-davinci-003")
                .echo(true)
                .temperature(0.4)
                .maxTokens(4000)
                .build();
        return service.createCompletion(request).getChoices().get(0).getText();
    }

}