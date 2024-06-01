package de.linksideal.shelfie.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "book")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
        String isbn;
        String name;
}
