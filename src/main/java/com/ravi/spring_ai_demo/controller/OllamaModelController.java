package com.ravi.spring_ai_demo.controller;

import com.ravi.spring_ai_demo.service.OllamaModelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ollama")
public class OllamaModelController {

    private final OllamaModelService ollamaModelService;

    public OllamaModelController(OllamaModelService ollamaModelService) {
        this.ollamaModelService = ollamaModelService;
    }

    @GetMapping("/{promptMessage}")
    public String getPromptResponse(@PathVariable String promptMessage) {
        return ollamaModelService.getContent(promptMessage);
    }
}
