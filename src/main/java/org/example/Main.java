package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        DocumentManager manager = new DocumentManager();

        DocumentManager.Author author = DocumentManager.Author.builder()
                .id("1")
                .name("Bohdan Ryzhko")
                .build();

        DocumentManager.Document doc1 = DocumentManager.Document.builder()
                .title("Test task")
                .content("Executing the test task")
                .author(author)
                .build();

        DocumentManager.Document savedDoc = manager.save(doc1);

        System.out.println("Saved Document: " + savedDoc);

        DocumentManager.SearchRequest request = DocumentManager.SearchRequest.builder()
                .titlePrefixes(Collections.singletonList("Test"))
                .build();

        List<DocumentManager.Document> results = manager.search(request);
        System.out.println("Search Results: " + results);

        Optional<DocumentManager.Document> foundDoc = manager.findById(savedDoc.getId());
        System.out.println("Found Document by ID: " + foundDoc.orElse(null));
    }
}

