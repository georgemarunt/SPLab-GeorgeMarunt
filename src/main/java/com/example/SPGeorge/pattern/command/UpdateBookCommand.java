package com.example.SPGeorge.pattern.command;

import com.example.SPGeorge.entity.Book;
import com.example.SPGeorge.pattern.command.Command;
import java.util.Map;

public class UpdateBookCommand implements Command {
    private final Map<Long, Book> repository;
    private final Long id;
    private final Book newBook;
    private Book oldBook;

    public UpdateBookCommand(Map<Long, Book> repository, Long id, Book newBook) {
        this.repository = repository;
        this.id = id;
        this.newBook = newBook;
    }

    @Override
    public void execute() {
        oldBook = repository.get(id);
        repository.put(id, newBook);
        System.out.println("Command: Book updated with ID " + id);
    }

    @Override
    public void undo() {
        if (oldBook != null) {
            repository.put(id, oldBook);
            System.out.println("Command: Book update undone for ID " + id);
        }
    }
}

