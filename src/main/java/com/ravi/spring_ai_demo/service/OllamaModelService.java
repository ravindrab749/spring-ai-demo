package com.ravi.spring_ai_demo.service;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public final class OllamaModelService extends AbstractModelService<OllamaChatModel> {

    public OllamaModelService(OllamaChatModel chatModel) {
        super(chatModel);
    }
}
