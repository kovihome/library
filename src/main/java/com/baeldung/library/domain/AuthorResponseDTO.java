package com.baeldung.library.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class AuthorResponseDTO {
    private long id;
    private String name;
    private LocalDate birthDate;
    private Country originCountry;
    private int bookCount;

    public AuthorResponseDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.birthDate = author.getBirth_date();
        this.originCountry = author.getOrigin_country();
        this.bookCount = author.getBooks() != null ? author.getBooks().size() : 0;
    }
}
