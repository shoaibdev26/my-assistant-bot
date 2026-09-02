package com.irusolutions.assistant.payload;

public record AiRequest(
        Long sessionId,
        String query
) {
}
