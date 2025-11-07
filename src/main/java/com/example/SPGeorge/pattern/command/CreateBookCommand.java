package com.example.SPGeorge.pattern.command;

import com.example.SPGeorge.entity.Book;
import java.util.Map;

public class CreateBookCommand implements Command {
    private final Map<Long, Book> repository;
    private final Book book;

    public CreateBookCommand(Map<Long, Book> repository, Book book) {
        this.repository = repository;
        this.book = book;
    }

    @Override
    public void execute() {
        repository.put(book.getId(), book);
        System.out.println("Command: Book created with ID " + book.getId());
    }

    @Override
    public void undo() {
        repository.remove(book.getId());
        System.out.println("Command: Book creation undone for ID " + book.getId());
    }
}
