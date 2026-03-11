package com.baeldung.library.service;

import com.baeldung.library.domain.Author;
import com.baeldung.library.domain.AuthorResponseDTO;
import com.baeldung.library.repo.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final Logger logger = LoggerFactory.getLogger(AuthorService.class);

    public AuthorService(@Autowired AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorResponseDTO getAuthorById(Long id) {
        return new AuthorResponseDTO(authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Author not found")));
    }

    public List<AuthorResponseDTO> getAllAuthors() {
        logger.info("getAllAuthors()");
        List<AuthorResponseDTO> authors = new ArrayList<>();
        authorRepository.findAll().forEach(author -> authors.add(new AuthorResponseDTO(author)));
        return authors;
    }

    public AuthorResponseDTO createAuthor(Author author) {
        logger.info("createAuthor()");
        return new AuthorResponseDTO(authorRepository.save(author));
    }

    @Transactional
    public AuthorResponseDTO updateAuthor(Long id, Author author) {
        logger.info("updateAuthor()");
        var authorExisting = authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Author not found"));
        if (!author.getName().isBlank()) {
            authorExisting.setName(author.getName());
        }
        if (author.getBirth_date() != null) {
            authorExisting.setBirth_date(author.getBirth_date());
        }
        if (author.getOrigin_country() != null) {
            authorExisting.setOrigin_country(author.getOrigin_country());
        }
        return new AuthorResponseDTO(authorRepository.save(authorExisting));
    }

    public void deleteAuthor(Long id) {
        logger.info("deleteAuthor()");
        authorRepository.deleteById(id);
    }

    public List<AuthorResponseDTO> searchAuthors(String name, String birthDate, String originCountry, Integer bookCount) {
        logger.info("searchAuthors()");
        Specification<Author> spec = (Specification<Author>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            if (birthDate != null) {
                predicates.add(criteriaBuilder.equal(root.get("birth_date"), birthDate));
            }
            if (originCountry != null) {
                predicates.add(criteriaBuilder.equal(root.get("origin_country"), originCountry));
            }
            if (bookCount != null) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.size(root.get("books")), bookCount));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        var authors = authorRepository.findAll(spec);

        List<AuthorResponseDTO> authorsResponse = new ArrayList<>();
        authors.forEach(author -> authorsResponse.add(new AuthorResponseDTO(author)));
        return authorsResponse;
    }
}
