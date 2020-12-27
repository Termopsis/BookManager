package org.bookManager.backendSpringBoot.repo;

import org.bookManager.backendSpringBoot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
