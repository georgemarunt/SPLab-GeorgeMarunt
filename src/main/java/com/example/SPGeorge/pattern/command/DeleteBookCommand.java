package com.example.SPGeorge.pattern.command;

import com.example.SPGeorge.entity.Book;
import java.util.Map;

public class DeleteBookCommand implements Command {
    private final Map<Long, Book> repository;
    private final Long id;
    private Book deletedBook;

    public DeleteBookCommand(Map<Long, Book> repository, Long id) {
        this.repository = repository;
        this.id = id;
    }

    @Override
    public void execute() {
        deletedBook = repository.remove(id);
        System.out.println("Command: Book deleted with ID " + id);
    }

    @Override
    public void undo() {
        if (deletedBook != null) {
            repository.put(id, deletedBook);
            System.out.println("Command: Book deletion undone for ID " + id);
        }
    }
}
