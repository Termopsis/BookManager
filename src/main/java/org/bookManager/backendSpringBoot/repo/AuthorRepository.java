package org.bookManager.backendSpringBoot.repo;

import org.bookManager.backendSpringBoot.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
