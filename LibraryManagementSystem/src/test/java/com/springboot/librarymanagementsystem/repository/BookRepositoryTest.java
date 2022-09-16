package com.springboot.librarymanagementsystem.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


import com.springboot.librarymanagementsystem.model.Books_Info;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.bind.annotation.GetMapping;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private Books_Info book;


    @BeforeEach
    public void setup() {
        book = Books_Info.builder().activeFlag(1).author("Jokha Alharthi").price(499).bookName("Celestial Bodies")
                .noOfCopies(10L).bookPublication("Paperback").build();
    }

    @DisplayName("Junit test for adding single row.")
    @Test
    public void givenBookObject_whenSave_thenReturnSavedBook() {
        book = Books_Info.builder().activeFlag(1).author("Jokha Alharthi").price(499).bookName("Celestial Bodies")
                .noOfCopies(10L).bookPublication("Paperback").build();

        Books_Info booksaved = bookRepository.save(book);
        assertThat(booksaved).isNotNull();
        assertThat(booksaved.getBookId()).isGreaterThan(0);
    }

    @DisplayName("JUnit test for getting all books.")
    @Test
    public void givenBookList_whenFindAll_thenBookList() {

        bookRepository.save(book);
        List<Books_Info> allBook = bookRepository.findAll();
        assertThat(allBook.size()).isGreaterThanOrEqualTo(14);

    }

    @DisplayName("JUnit test for getting book by id.")
    @Test
    public void givenBookObject_whenFindById_thenReturnBookObject() {

        bookRepository.save(book);

        Books_Info bookDB = bookRepository.findById(book.getBookId()).get();

        assertThat(bookDB).isNotNull();
    }


    @DisplayName("JUnit test for getting book by Name.")
    @Test
    public void givenBookObject_whenFindByName_thenReturnBookObject() {
        bookRepository.save(book);

        List<Books_Info> bookdb = bookRepository.findBybookName(book.getBookName());
        assertThat(bookdb).isNotNull();
    }

    @DisplayName("JUnit test for getting book by Author.")
    @Test
    public void givenBookObject_whenFindByAuthor_thenReturnBookObject() {
        bookRepository.save(book);

        List<Books_Info> bookdb = bookRepository.findByAuthor(book.getAuthor());
        assertThat(bookdb).isNotNull();

    }

    @DisplayName("JUnit test for getting book by Publication.")
    @Test
    public void givenBookObject_whenFindByPubliction_thenReturnBookObject() {
        bookRepository.save(book);

        List<Books_Info> bookdb = bookRepository.findByBookPublication(book.getBookPublication());
        assertThat(bookdb).isNotNull();

    }

    @DisplayName("JUnit test for update book operation")
    @Test
    public void givenBookObject_whenUpdateBookData_thenReturnUpdatedBookData() {

        bookRepository.save(book);

        Books_Info savedBook = bookRepository.findById(book.getBookId()).get();
        savedBook.setActiveFlag(0);
        savedBook.setPrice(900);

        Books_Info updatedBook = bookRepository.save(savedBook);

        assertThat(updatedBook.getActiveFlag()).isEqualTo(0);
        assertThat(updatedBook.getPrice()).isEqualTo(900);
    }

    @DisplayName("JUnit test for delete(Update Active Flag To 0) book.")
    @Test
    public void givenEmployeeObject_whenDelete_thenRemoveEmployee() {

        bookRepository.save(book);

        Books_Info checkActiveFlag = bookRepository.getById(book.getBookId());
        checkActiveFlag.setActiveFlag(0);
        Books_Info updatedBookData = bookRepository.save(checkActiveFlag);


        assertThat(updatedBookData.getActiveFlag()).isEqualTo(0);
    }

}