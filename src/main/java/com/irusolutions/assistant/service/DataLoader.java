package com.irusolutions.assistant.service;

import org.springframework.ai.document.Document;

import java.util.List;

public interface DataLoader {

    List<Document> loadDataFromJson();

    List<Document> loadDocumentFromPdf();

}
