--changeset kovi:2
-- add sample authors
INSERT INTO author (id, name, birth_date, origin_country) VALUES (nextval('author_seq'), 'Jack McDevitt', '1945-04-14', 'US');
INSERT INTO author (id, name, birth_date, origin_country) VALUES (nextval('author_seq'), 'Isaac Asimov', '1920-01-02', 'RU');
INSERT INTO author (id, name, birth_date, origin_country) VALUES (nextval('author_seq'), 'Frank Herbert', '1920-10-08', 'US');
INSERT INTO author (id, name, birth_date, origin_country) VALUES (nextval('author_seq'), 'Robert Silverberg', '1935-01-15', 'US');

INSERT INTO book (id, isbn, title) VALUES (nextval('book_seq'), '978-0-441-79553-6', 'A Talent for War'); -- Jack McDevitt
INSERT INTO book (id, isbn, title) VALUES (nextval('book_seq'), '978-0-441-00077-0', 'The Engines of God'); -- Jack McDevitt
INSERT INTO book (id, isbn, title) VALUES (nextval('book_seq'), '978-0-345-31798-8', 'Foundation'); -- Isaac Asimov
INSERT INTO book (id, isbn, title) VALUES (nextval('book_seq'), '978-0-575-04700-3', 'The Positronic Man'); -- Isaac Asimov, Robert Silverberg
INSERT INTO book (id, isbn, title) VALUES (nextval('book_seq'), '978-0-441-00079-4', 'Nightfall'); -- Isaac Asimov, Robert Silverberg

INSERT INTO book_authors (authors_id, books_id) VALUES (
    (SELECT id FROM author WHERE name = 'Jack McDevitt'),
    (SELECT id FROM book WHERE isbn = '978-0-441-79553-6')); -- Jack McDevitt - A Talent for War
INSERT INTO book_authors (authors_id, books_id) VALUES (
    (SELECT id FROM author WHERE name = 'Jack McDevitt'),
    (SELECT id FROM book WHERE isbn = '978-0-441-00077-0')); -- Jack McDevitt- The Engines of God
INSERT INTO book_authors (authors_id, books_id) VALUES (
    (SELECT id FROM author WHERE name = 'Isaac Asimov'),
    (SELECT id FROM book WHERE isbn = '978-0-345-31798-8')); -- Isaac Asimov - Foundation
INSERT INTO book_authors (authors_id, books_id) VALUES (
    (SELECT id FROM author WHERE name = 'Isaac Asimov'),
    (SELECT id FROM book WHERE isbn = '978-0-575-04700-3')); -- Isaac Asimov - The Positronic Man
INSERT INTO book_authors (authors_id, books_id) VALUES (
    (SELECT id FROM author WHERE name = 'Robert Silverberg'),
    (SELECT id FROM book WHERE isbn = '978-0-575-04700-3')); -- Robert Silverberg - The Positronic Man
INSERT INTO book_authors (authors_id, books_id) VALUES (
    (SELECT id FROM author WHERE name = 'Isaac Asimov'),
    (SELECT id FROM book WHERE isbn = '978-0-441-00079-4')); -- Isaac Asimov - Nightfall
INSERT INTO book_authors (authors_id, books_id) VALUES (
    (SELECT id FROM author WHERE name = 'Robert Silverberg'),
    (SELECT id FROM book WHERE isbn = '978-0-441-00079-4')); -- Robert Silverberg - Nightfall
