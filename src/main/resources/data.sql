INSERT INTO author (name, surname) VALUES ('Robert', 'Martin');
INSERT INTO author (name, surname) VALUES ('Erich', 'Gamma');
INSERT INTO author (name, surname) VALUES ('Joshua', 'Bloch');

INSERT INTO book (title) VALUES ('Clean Code');
INSERT INTO book (title) VALUES ('Design Patterns');
INSERT INTO book (title) VALUES ('Effective Java');

INSERT INTO book_author (book_id, author_id) VALUES (1, 1);
INSERT INTO book_author (book_id, author_id) VALUES (2, 2);
INSERT INTO book_author (book_id, author_id) VALUES (3, 3);
INSERT INTO book_author (book_id, author_id) VALUES (2, 1);
