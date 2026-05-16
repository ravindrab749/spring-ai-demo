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

    protected ChatResponse getChatResponse(String prompt) {
        return chatClient.prompt(prompt).call().chatResponse();
    }

    public String getContent(String prompt) {
        String content = chatClient.prompt(prompt).call().content();
        log.info("Prompt response content: {}", content);
        return content;
    }
}
