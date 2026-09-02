package com.irusolutions.assistant.service;

import com.irusolutions.assistant.payload.AiRequest;
import com.irusolutions.assistant.payload.AiResponse;

public interface AiServivce {

    AiResponse askAi(AiRequest aiRequest);
}
