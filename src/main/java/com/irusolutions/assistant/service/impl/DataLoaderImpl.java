package com.irusolutions.assistant.service.impl;

import com.irusolutions.assistant.service.DataLoader;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataLoaderImpl implements DataLoader {


    @Value("classpath:IT_Courses.pdf")
    private Resource pdfResource;

    @Override
    public List<Document> loadDataFromJson() {
        return List.of();
    }

    @Override
    public List<Document> loadDocumentFromPdf() {
        var pdfPdfDocumentReader=new PagePdfDocumentReader(pdfResource, PdfDocumentReaderConfig.builder()
                .withPageTopMargin(0)
                .withPageExtractedTextFormatter(ExtractedTextFormatter.builder()
                        .withNumberOfTopTextLinesToDelete(0)
                        .build())
                .withPagesPerDocument(1)
                .build());
        return pdfPdfDocumentReader.read();
    }
}
