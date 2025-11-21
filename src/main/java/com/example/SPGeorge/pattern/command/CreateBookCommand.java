package com.example.SPGeorge.pattern.command;

import com.example.SPGeorge.entity.Book;
import com.example.SPGeorge.repo.BookRepository;
import lombok.Getter;

public class CreateBookCommand implements Command {

    private final BookRepository repository;
    @Getter
    private Book book;
    private boolean created;

    public CreateBookCommand(BookRepository repository, Book book) {
        this.repository = repository;
        this.book = book;
    }

    @Override
    public void execute() {
        book = repository.save(book);
        created = true;
        System.out.println("Command: Book created with ID " + book.getId());
    }

    @Override
    public void undo() {
        if (created && book != null && book.getId() != null) {
            repository.deleteById(book.getId());
            System.out.println("Command: Book creation undone for ID " + book.getId());
        }
    }
}
