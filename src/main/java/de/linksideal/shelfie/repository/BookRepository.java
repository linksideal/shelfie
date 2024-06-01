package de.linksideal.shelfie.repository;

import de.linksideal.shelfie.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
