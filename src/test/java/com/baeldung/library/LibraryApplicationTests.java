package com.baeldung.library;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.emptyIterable;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.library.repo.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class LibraryApplicationTests {

    @Autowired
    private BookRepository bookRepo;

    @Test
    void contextLoads() {
        //
    }

    @Test
    void persistenceWorks() {
        bookRepo.findAll();
    }

    @Test
    void dataExists() {
        assertThat(bookRepo.findAll(), not(emptyIterable()));
    }

}
