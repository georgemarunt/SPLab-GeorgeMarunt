package com.example.SPGeorge.helper.strategy;

import com.example.SPGeorge.entity.Book;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void add(Book book);
}
