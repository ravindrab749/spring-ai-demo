package com.ravi.spring_ai_demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;

@Slf4j
public abstract sealed class AbstractModelService<T extends ChatModel> permits OllamaModelService {

    private final ChatClient chatClient;

    public AbstractModelService(T chatModel) {
        this.chatClient = ChatClient.builder(chatModel).build();
    }

    private ChatClient.CallResponseSpec call(String prompt) {
        return chatClient.prompt(prompt).call();
    }

    protected ChatResponse getChatResponse(String prompt) {
        return call(prompt).chatResponse();
    }

    public String getContent(String prompt) {
        String content = call(prompt).content();
        log.info("Prompt response content: {}", content);
        return content;
    }
}
