package org.bookManager.backendSpringBoot.service;

import org.bookManager.backendSpringBoot.entity.Author;
import org.bookManager.backendSpringBoot.repo.AuthorRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> findAll(){
        return repository.findAll();
    }

    public Author save(Author author){
        return repository.save(author);
    }

    public Author findById(Long id){
        return repository.findById(id).get();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
