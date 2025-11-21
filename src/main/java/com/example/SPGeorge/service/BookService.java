package com.example.SPGeorge.service;

import com.example.SPGeorge.entity.Book;
import com.example.SPGeorge.pattern.chain.AuthorizationHandler;
import com.example.SPGeorge.pattern.chain.BookRequestHandler;
import com.example.SPGeorge.pattern.chain.LoggingHandler;
import com.example.SPGeorge.pattern.chain.PersistenceHandler;
import com.example.SPGeorge.pattern.chain.ValidationHandler;
import com.example.SPGeorge.pattern.command.Command;
import com.example.SPGeorge.pattern.command.CommandInvoker;
import com.example.SPGeorge.pattern.command.CreateBookCommand;
import com.example.SPGeorge.pattern.command.DeleteBookCommand;
import com.example.SPGeorge.pattern.command.UpdateBookCommand;
import com.example.SPGeorge.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CommandInvoker commandInvoker = new CommandInvoker();
    private final BookRequestHandler handlerChain;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

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
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Map<String, Object> request = new HashMap<>();
        request.put("operation", "GET");
        request.put("id", id);
        return (Book) handlerChain.handle(request);
    }

    public Book createBook(Book book) {
        CreateBookCommand command = new CreateBookCommand(bookRepository, book);
        commandInvoker.executeCommand(command);

        Map<String, Object> request = new HashMap<>();
        request.put("operation", "CREATE");
        request.put("book", command.getBook());
        handlerChain.handle(request);

        return command.getBook();
    }

    public Book updateBook(Long id, Book book) {
        if (!bookRepository.existsById(id)) {
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
        if (!bookRepository.existsById(id)) {
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
