package com.example.SPGeorge.repo;


import com.example.SPGeorge.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {}