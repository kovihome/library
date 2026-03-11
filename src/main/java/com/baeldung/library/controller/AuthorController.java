package com.baeldung.library.controller;

import com.baeldung.library.domain.Author;
import com.baeldung.library.domain.AuthorResponseDTO;
import com.baeldung.library.domain.UserRole;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.baeldung.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    public AuthorController(@Autowired AuthorService authorService) {
        this.authorService = authorService;
    }

    private final AuthorService authorService;

    private final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping
    public List<AuthorResponseDTO> getAllAuthors() {
        logger.info("getAllAuthors invoked");
        return authorService.getAllAuthors();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public AuthorResponseDTO getAuthorById(@PathVariable Long id) {
        logger.info("getAuthorById invoked");
        try {
            return authorService.getAuthorById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public AuthorResponseDTO createAuthor(@RequestBody Author author) {
        logger.info("createAuthor invoked");
        return authorService.createAuthor(author);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public AuthorResponseDTO updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        logger.info("updateAuthor invoked");
        try {
            return authorService.updateAuthor(id, author);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        logger.info("deleteAuthor invoked");
        try {
            authorService.deleteAuthor(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        }
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/search")
    public List<AuthorResponseDTO> searchAuthors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String birthDate,
            @RequestParam(required = false) String originCountry,
            @RequestParam(required = false) Integer bookCount) {
        logger.info("searchAuthors invoked");
        return authorService.searchAuthors(name, birthDate, originCountry, bookCount);
    }
}
