package com.springboot.librarymanagementsystem.controller;

import com.springboot.librarymanagementsystem.exception.ResourceNotFoundException;
import com.springboot.librarymanagementsystem.model.Books_Info;
import com.springboot.librarymanagementsystem.model.User;
import com.springboot.librarymanagementsystem.repository.UserRepository;
import com.springboot.librarymanagementsystem.service.BooksInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BooksController {
    private static final Logger log = LoggerFactory.getLogger(BooksController.class);

    @Autowired
    private BooksInfoService bookService;


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/books/{libId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String saveBook(@PathVariable Long libId, @RequestBody Books_Info book) {
        log.info("Adding book through json in bookController.");
        User lib = userRepository.findById(libId).get();
        if (lib == null) {
            throw new ResourceNotFoundException("Librarian not found with this Id:" + libId);
        } else {
            bookService.saveBook(libId, book);
            return "Book Added Successfully";
        }
    }

    @GetMapping("/getAllBook")
    public List<Books_Info> findAllBooks() {
        log.info("Fetching All Books Available in bookController.");
        return bookService.getAllBook();
    }

    @GetMapping("/BookByName/{name}")
    public List<Books_Info> findBookBybook_Name(@PathVariable String name) {

        log.info("Fetching book By Name in bookController.");
        List<Books_Info> books=bookService.findBookByBook_Name(name);
        if(books.isEmpty()){
            throw new ResourceNotFoundException("No books by this name:"+name);
        }
        return books ;
    }

    @GetMapping("/BookByAuthorName/{name}")
    public ResponseEntity<List<Books_Info>> findBookByAuthorName(@PathVariable String name) {
        log.info("Fetching book By Author in bookController.");
        List<Books_Info>books=bookService.getsBookByAuthorName(name);

        return new ResponseEntity <List<Books_Info>>(books, HttpStatus.OK) ;
    }

    @GetMapping("/BookByPublication/{bookPublication}")
    public List<Books_Info> findBookByPublication(@PathVariable String bookPublication) {
        log.info("Fetching book By Publication in bookController.");
        List<Books_Info> books = bookService.getsBookByPublication(bookPublication);
        if(books.isEmpty()){
            throw new ResourceNotFoundException("No book by this publisher:"+bookPublication);
        }
        return bookService.getsBookByPublication(bookPublication);
    }

    @PutMapping("/updateBook")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Books_Info updateProduct(@RequestBody Books_Info book) {
        log.info("Updating book details in bookController.");
        return bookService.updateBook(book);

    }

}
