package com.baeldung.library.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Author {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate birth_date;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Country origin_country;

    @ManyToMany(mappedBy = "authors")
    @ToString.Exclude
    private List<Book> books;

}
