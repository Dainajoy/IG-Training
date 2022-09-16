package com.springboot.librarymanagementsystem.serviceImpl;

import com.springboot.librarymanagementsystem.model.Books_Info;
import com.springboot.librarymanagementsystem.model.User;
import com.springboot.librarymanagementsystem.repository.BookRepository;
import com.springboot.librarymanagementsystem.repository.UserRepository;
import com.springboot.librarymanagementsystem.service.BooksInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksInfoServiceImpl implements BooksInfoService {
    private static final Logger log = LoggerFactory.getLogger(BooksInfoServiceImpl.class);

    @Autowired
    private BookRepository bookrepository;

    @Autowired
    private UserRepository userrepository;

    public Books_Info saveBook(Long libId, Books_Info book) {
        log.info("Book service called for save book.");
        User user = userrepository.findById(libId).get();
        book.setCreatedBy(user);
        book.setModifiedBy(user);
        return bookrepository.save(book);
    }

    public List<Books_Info> getAllBook() {
        log.info("Book service called for getting all book.");
        return bookrepository.findAll();
    }

    public Books_Info getBookById(Long id) {
        log.info("Book service called for finding book by id.");
        return bookrepository.findById(id).orElse(null);
    }

    public List<Books_Info> findBookByBook_Name(String name) {
        log.info("Book service called for finding book by name.");
        List<Books_Info> books = new ArrayList<>();
        return bookrepository.findBybookName(name);

    }

    public List<Books_Info> getsBookByAuthorName(String author) {
        log.info("Book service called for getting all book's by author name.");
        List<Books_Info> books = new ArrayList<>();
        return bookrepository.findByAuthor(author);
    }

    public List<Books_Info> getsBookByPublication(String name) {
        log.info("Book service called for getting all book's by publication name.");
        return bookrepository.findByBookPublication(name);
    }



    public Books_Info deleteBook(String name, Long id) {
        log.info("Book service called for deleting all book's.");
        List<Books_Info> existingBook = bookrepository.findBybookName(name);
        User user = userrepository.findById(id).get();
        existingBook.get(0).setActiveFlag(0);
        existingBook.get(0).setNoOfCopies(0L);
        existingBook.get(0).setModifiedBy(user);
        return bookrepository.save(existingBook.get(0));
    }

    public Books_Info updateBook(Books_Info book) {
        log.info("Book service for updating all book's.");
        Books_Info existingBook = bookrepository.findById(book.getBookId()).orElse(null);
        existingBook.setBookName(book.getBookName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setBookPublication(book.getBookPublication());
        existingBook.setPrice(book.getPrice());
        existingBook.setNoOfCopies(book.getNoOfCopies());
        existingBook.setCreatedBy(book.getCreatedBy());
        existingBook.setCreatedOn(book.getCreatedOn());
        existingBook.setModifiedBy(book.getModifiedBy());
        existingBook.setModifiedOn(book.getModifiedOn());
        existingBook.setActiveFlag(book.getActiveFlag());
        return bookrepository.save(existingBook);
    }
}
