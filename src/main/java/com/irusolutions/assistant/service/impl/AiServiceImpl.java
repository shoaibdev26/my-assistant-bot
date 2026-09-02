package com.irusolutions.assistant.service.impl;

import com.irusolutions.assistant.payload.AiRequest;
import com.irusolutions.assistant.payload.AiResponse;
import com.irusolutions.assistant.service.AiServivce;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.generation.augmentation.ContextualQueryAugmenter;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AiServivce {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;


    @Override
    public AiResponse askAi(AiRequest aiRequest) {

        String prompt = """             
                Answer the user's query:                
                 {query}                              
                 rules: summerize the answer in max  100 words.                
                """;

        PromptTemplate promptTemplate = PromptTemplate.builder()
                .template(prompt)
                .variables(Map.of(
                        "query", aiRequest.query()
                ))
                .build();


//
        RetrievalAugmentationAdvisor ragAdvisor = RetrievalAugmentationAdvisor.builder()
                .documentRetriever(
                        VectorStoreDocumentRetriever.builder()
                                .vectorStore(vectorStore)
                                .topK(5)
                                .similarityThreshold(0.5)
                                .build()
                ).queryAugmenter(
                        ContextualQueryAugmenter.builder()
                                .allowEmptyContext(true)
                                .build()
                ).
                build();

        String content = chatClient
                .prompt()
                .system("Act as IT company assistant named,you name is Aliza. ")
                .user(promptTemplate.render())
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, aiRequest.sessionId()))
                .advisors(ragAdvisor)
                .call()
                .content();

        return new AiResponse(content);
    }
}
