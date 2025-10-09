package com.example.SPGeorge;

import com.example.SPGeorge.entity.*;

import com.example.SPGeorge.repo.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(BookRepository books) {
        return args -> {
            Book firstbook = new Book(8L,"Cer senin");
            Author ioanaPop = new Author(6L,"Cristian Somber");
            firstbook.addAuthor(ioanaPop);

            Chapter capitolUnu = new Chapter(12L,"Amurg");
            SubChapter subUnu = new SubChapter(13L,"Amurg.1");
            SubChapter subUnuUnu = new SubChapter(14L,"Amurg.1.1");
            SubChapter subUnuUnuUnu = new SubChapter(15L,"Amurg.1.1.1");

            subUnuUnuUnu.addParagraph(new Paragraph(10L,"Era o seara minunata."));
            subUnu.addParagraph(new Paragraph(1L,"Text din subcapitol 1"));
            subUnuUnu.addParagraph(new Paragraph(2L,"Text din subcapitol 1.1"));
            subUnuUnuUnu.addImage(new Image(3L,"img-amurg.jpg"));

            subUnuUnu.addSubChapter(subUnuUnuUnu);
            subUnu.addSubChapter(subUnuUnu);
            capitolUnu.addSubChapter(subUnu);
            firstbook.addChapter(capitolUnu);

            books.save(firstbook);
        };
    }
}