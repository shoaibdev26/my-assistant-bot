//package com.irusolutions.assistant;
//
//import com.irusolutions.assistant.service.DataLoader;
//import com.irusolutions.assistant.service.DataTransformer;
//import org.junit.jupiter.api.Test;
//import org.springframework.ai.document.Document;
//import org.springframework.ai.vectorstore.VectorStore;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//class MyAssistantApplicationTests {
//
//    @Autowired
//    private DataLoader dataLoader;
//    @Autowired
//    private DataTransformer dataTransformer;
//
//    @Autowired
//    private VectorStore vectorStore;
//
//	@Test
//	void contextLoads() {
//	}
//
//    @Test
//    void testLoadData(){
//
//
//        List<Document> documents = this.dataLoader.loadDocumentFromPdf();
//        System.out.println(documents.size());
//        List<Document> transformedData = dataTransformer.transformData(documents);
//        System.out.println(transformedData.size());
//
//
//        transformedData.forEach(document -> {
//            System.out.println(document.getFormattedContent());
//            System.out.println("-------------------------------------");
//        });
//
//        vectorStore.add(transformedData);
//        System.out.println("document saved to db");
//
//
//
//    }
//
//}
