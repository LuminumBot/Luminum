package io.github.luminumbot.luminum.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.luminumbot.luminum.Config;
import lombok.SneakyThrows;
import okhttp3.*;

import java.util.Arrays;

public class Yandex {

    private static final String API_KEY = Config.YANDEX_TOKEN;
    private static final String TRANSLATE_URL = "https://translate.api.cloud.yandex.net/translate/v2/translate";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static String getTranslate(String text, String traget_language) {
        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType, "{\"targetLanguageCode\":\"" + traget_language + "\",\"texts\":" + Arrays.toString(new String[]{text}).replace("[", "[\"").replace(", ", "\",\"").replace("]", "\"]") + "}");

        Request request = new Request.Builder()
                .url(TRANSLATE_URL)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Api-Key " + API_KEY)
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        JsonNode jsonNode = objectMapper.readTree(response.body().string());
        JsonNode translations = jsonNode.get("translations");
        if (translations.isArray() && translations.size() > 0) {
            JsonNode translation = translations.get(0);
            return translation.get("text").asText();
        } else {
            throw new RuntimeException("Translation not found.");
        }
    }
}