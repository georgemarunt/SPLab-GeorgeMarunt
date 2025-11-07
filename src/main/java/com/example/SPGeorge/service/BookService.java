package com.example.SPGeorge.service;

import com.example.SPGeorge.entity.Book;
import com.example.SPGeorge.pattern.command.Command;
import com.example.SPGeorge.pattern.command.CommandInvoker;
import com.example.SPGeorge.pattern.chain.BookRequestHandler;
import com.example.SPGeorge.pattern.chain.*;
import com.example.SPGeorge.pattern.command.CreateBookCommand;
import com.example.SPGeorge.pattern.command.DeleteBookCommand;
import com.example.SPGeorge.pattern.command.UpdateBookCommand;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {

    private final Map<Long, Book> bookRepository = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private final CommandInvoker commandInvoker = new CommandInvoker();
    private final BookRequestHandler handlerChain;

    public BookService() {
        BookRequestHandler validationHandler = new ValidationHandler();
        BookRequestHandler authorizationHandler = new AuthorizationHandler();
        BookRequestHandler loggingHandler = new LoggingHandler();
        BookRequestHandler persistenceHandler = new PersistenceHandler(bookRepository);

        validationHandler.setNext(authorizationHandler);
        authorizationHandler.setNext(loggingHandler);
        loggingHandler.setNext(persistenceHandler);

        this.handlerChain = validationHandler;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookRepository.values());
    }

    public Book getBookById(Long id) {
        Map<String, Object> request = new HashMap<>();
        request.put("operation", "GET");
        request.put("id", id);

        return (Book) handlerChain.handle(request);
    }

    public Book createBook(Book book) {
        if (book.getId() == null) {
            book.setId(idCounter.getAndIncrement());
        }

        Command command = new CreateBookCommand(bookRepository, book);
        commandInvoker.executeCommand(command);

        Map<String, Object> request = new HashMap<>();
        request.put("operation", "CREATE");
        request.put("book", book);

        handlerChain.handle(request);
        return book;
    }

    public Book updateBook(Long id, Book book) {
        if (!bookRepository.containsKey(id)) {
            return null;
        }

        book.setId(id);
        Command command = new UpdateBookCommand(bookRepository, id, book);
        commandInvoker.executeCommand(command);

        Map<String, Object> request = new HashMap<>();
        request.put("operation", "UPDATE");
        request.put("id", id);
        request.put("book", book);

        handlerChain.handle(request);
        return book;
    }

    public boolean deleteBook(Long id) {
        if (!bookRepository.containsKey(id)) {
            return false;
        }

        Command command = new DeleteBookCommand(bookRepository, id);
        commandInvoker.executeCommand(command);

        Map<String, Object> request = new HashMap<>();
        request.put("operation", "DELETE");
        request.put("id", id);

        handlerChain.handle(request);
        return true;
    }

    public void undoLastCommand() {
        commandInvoker.undo();
    }
}