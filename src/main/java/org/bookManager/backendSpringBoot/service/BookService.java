package org.bookManager.backendSpringBoot.service;

import org.bookManager.backendSpringBoot.entity.Author;
import org.bookManager.backendSpringBoot.entity.Book;
import org.bookManager.backendSpringBoot.repo.BookRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book save(Book book){
        return repository.save(book);
    }

    public Book findById(Long id){
        return repository.findById(id).get();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
