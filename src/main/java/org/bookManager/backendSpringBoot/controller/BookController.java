package org.bookManager.backendSpringBoot.controller;

import org.bookManager.backendSpringBoot.entity.Author;
import org.bookManager.backendSpringBoot.entity.Book;
import org.bookManager.backendSpringBoot.service.BookService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService service;

    public BookController(BookService bookService) {
        this.service = bookService;
    }

    @GetMapping("/getAll")
    public List<Book> findAll(){
        return service.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Book book){
        return ResponseEntity.ok(service.save(book));
    }

    @PostMapping("/update")
    public ResponseEntity<Book> update(@RequestBody Book book){
        return ResponseEntity.ok(service.save(book));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){

        Book book;
        try{
            book = service.findById(id);
        }catch (NoSuchElementException e){
            return new ResponseEntity("Not found element by id "+id, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(book);
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
