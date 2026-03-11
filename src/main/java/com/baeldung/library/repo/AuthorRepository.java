package com.baeldung.library.repo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.baeldung.library.domain.Author;

@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface AuthorRepository extends CrudRepository<Author, Long>, PagingAndSortingRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    //
}