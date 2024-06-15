package de.linksideal.shelfie.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Authority {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
        @Column(nullable = false) String username;
        @Column(nullable = false) String authority;
}
