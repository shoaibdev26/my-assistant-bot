package com.irusolutions.assistant.controller;

import com.irusolutions.assistant.payload.AiRequest;
import com.irusolutions.assistant.payload.AiResponse;
import com.irusolutions.assistant.service.AiServivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AiController {

    private final AiServivce aiService;

    @PostMapping("/ask")
    public ResponseEntity<AiResponse> askAI(
            @RequestBody AiRequest aiRequest
    ) {


        AiResponse response = aiService.askAi(aiRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
