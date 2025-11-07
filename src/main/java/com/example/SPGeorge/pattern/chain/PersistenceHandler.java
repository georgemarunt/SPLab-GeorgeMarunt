package com.example.SPGeorge.pattern.chain;

import com.example.SPGeorge.entity.Book;
import com.example.SPGeorge.pattern.chain.BookRequestHandler;
import java.util.Map;

public class PersistenceHandler extends BookRequestHandler {
    private final Map<Long, Book> repository;

    public PersistenceHandler(Map<Long, Book> repository) {
        this.repository = repository;
    }

    @Override
    public Object handle(Map<String, Object> request) {
        String operation = (String) request.get("operation");
        System.out.println("PersistenceHandler: Handling " + operation + " operation");

        switch (operation) {
            case "GET":
                Long id = (Long) request.get("id");
                return repository.get(id);

            case "CREATE":
            case "UPDATE":
                Book book = (Book) request.get("book");
                repository.put(book.getId(), book);
                System.out.println("PersistenceHandler: Book persisted with ID " + book.getId());
                return book;

            case "DELETE":
                Long deleteId = (Long) request.get("id");
                repository.remove(deleteId);
                System.out.println("PersistenceHandler: Book deleted with ID " + deleteId);
                return true;

            default:
                System.out.println("PersistenceHandler: Unknown operation");
                return null;
        }
    }
}
