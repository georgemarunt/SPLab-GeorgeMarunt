package com.example.SPGeorge.repo;

import com.example.SPGeorge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}