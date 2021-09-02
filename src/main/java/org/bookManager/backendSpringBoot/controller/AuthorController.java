package org.bookManager.backendSpringBoot.controller;

import org.bookManager.backendSpringBoot.BackendSpringbootApplication;
import org.bookManager.backendSpringBoot.entity.Author;
import org.bookManager.backendSpringBoot.service.AuthorService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<Author> findAll(){
        return service.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Author> add(@RequestBody Author author){
        return ResponseEntity.ok(service.save(author));
    }

    @PostMapping("/update")
    public ResponseEntity<Author> update(@RequestBody Author author){
        return ResponseEntity.ok(service.save(author));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id){
        String face;
        Author author;
        try{
            author = service.findById(id);
        }catch (NoSuchElementException e){
            return new ResponseEntity("Not found element by id "+id, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(author);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){

        try {
            service.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("Element with id "+ id+" not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
