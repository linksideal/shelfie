package de.linksideal.shelfie.repository;

import de.linksideal.shelfie.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByUsername(String username);
}
