package com.irusolutions.assistant.service;

import org.springframework.ai.document.Document;

import java.util.List;

public interface DataTransformer {
    List<Document> transformData(List<Document> list);
}
