package com.irusolutions.assistant.service.impl;

import com.irusolutions.assistant.service.DataTransformer;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataTransformerImpl implements DataTransformer {
    @Override
    public List<Document> transformData(List<Document> list) {
        final List<Character> DEFAULT_PUNCTUATION_MARKS = List.of('.', '?', '!', '\n');
        var tokenTextSplitter= new TokenTextSplitter(150,200,10,5000,true,DEFAULT_PUNCTUATION_MARKS);
        return tokenTextSplitter.apply(list);
    }
}
