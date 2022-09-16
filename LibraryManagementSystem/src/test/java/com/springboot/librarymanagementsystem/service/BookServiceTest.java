package com.springboot.librarymanagementsystem.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.springboot.librarymanagementsystem.model.Books_Info;
import com.springboot.librarymanagementsystem.repository.BookRepository;
import com.springboot.librarymanagementsystem.repository.UserRepository;
import com.springboot.librarymanagementsystem.serviceImpl.BooksInfoServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;







@ExtendWith(MockitoExtension.class)
public class BookServiceTest {


    @Mock
    private BookRepository bookRepository;

    @Mock
    private UserRepository usersRepository;

    @InjectMocks
    private BooksInfoServiceImpl bookService;

    private Books_Info book;


    @DisplayName("Junit test for save book service.")
    @Test
    public void givenUserObject_whenSave_thenReturnUserObject() {
        Books_Info book = Books_Info.builder().bookId(10L)
                .activeFlag(1).bookName("A Revenue Stamp")
                .author("Amrita Pritam")
                .price(670).createdOn(new Date())
                .build();
        BDDMockito.given(bookRepository.save(book)).willReturn(book);
        Books_Info savedBook = bookService.saveBook(1L, book);
        assertThat(savedBook).isNotNull();
    }

    @DisplayName("Junit test for get all books")
    @Test
    public void givenBookObject_whenFindAll_thenReturnBookObjcet() {
        Books_Info book = Books_Info.builder().bookId(10L)
                .activeFlag(1).bookName("A Revenue Stamp")
                .author("Amrita Pritam")
                .price(670).createdOn(new Date())
                .build();
        BDDMockito.given(bookRepository.findAll()).willReturn((List<Books_Info>) book);
        List<Books_Info> bookList = bookService.getAllBook();
        assertThat(bookList).isNotNull();
        assertThat(bookList.size()).isGreaterThan(0);
    }

    @DisplayName("Junit test for get book by book id")
    @Test
    public void givenBookObject_whenFindById_thenReturnBookObject() {
        Books_Info book = Books_Info.builder().bookId(10L)
                .activeFlag(1).bookName("A Revenue Stamp")
                .author("Amrita Pritam")
                .price(670).createdOn(new Date())
                .build();
        BDDMockito.given(bookRepository.findById(book.getBookId())).willReturn(Optional.of(book));
        Books_Info savedBook = bookService.getBookById(book.getBookId());
        assertThat(savedBook).isNotNull();
    }

    @DisplayName("Junit test for get book by book name.")
    @Test
    public void givenBookObject_whenFindByName_thenReturnBookObject() {
        Books_Info book = Books_Info.builder().bookId(10L)
                .activeFlag(1).bookName("A Revenue Stamp")
                .author("Amrita Pritam")
                .price(670).createdOn(new Date())
                .build();
        BDDMockito.given(bookRepository.findBybookName(book.getBookName())).willReturn((List<Books_Info>) book);
        List<Books_Info> savedBook = bookService.findBookByBook_Name(book.getBookName());
        assertThat(savedBook).isNotNull();
    }

    @DisplayName("Junit test for get book by publication.")
    @Test
    public void givenBookObject_whenFindByPublication_thenReturnBookObject() {
        Books_Info book = Books_Info.builder().bookId(10L)
                .activeFlag(1).bookName("A Revenue Stamp")
                .author("Amrita Pritam").bookPublication("Pearson Publication")
                .price(670).createdOn(new Date())
                .build();
        BDDMockito.given(bookRepository.findByBookPublication("Pearson Publication")).willReturn((List<Books_Info>) book);
        List<Books_Info> savedBook = bookService.getsBookByPublication(book.getBookPublication());
        assertThat(savedBook).isNotNull();
    }

    @DisplayName("Junit test for get book by publication.")
    @Test
    public void givenBookObject_whenFindByAuthor_thenReturnBookObject() {
        Books_Info book = Books_Info.builder().bookId(10L)
                .activeFlag(1).bookName("A Revenue Stamp")
                .author("Amrita Pritam").bookPublication("Pearson Publication")
                .price(670).createdOn(new Date())
                .build();
        BDDMockito.given(bookRepository.findByAuthor("Amrita Pritam")).willReturn((List<Books_Info>) book);
        List<Books_Info> savedBook = bookService.getsBookByAuthorName(book.getAuthor());
        assertThat(savedBook).isNotNull();
    }

    @DisplayName("Junit test for delete book")
    @Test
    public void givenBookObject_whenDeleteById_thenReturnNothing() {
        Books_Info book = Books_Info.builder().bookId(10L)
                .activeFlag(1).bookName("A Revenue Stamp")
                .author("Amrita Pritam").bookPublication("Pearson Publication")
                .price(670).createdOn(new Date())
                .build();
        BDDMockito.willDoNothing().given(bookRepository).deleteById(book.getBookId());
        bookService.deleteBook("Arun", 1L);
        verify(bookRepository, times(1)).deleteById(book.getBookId());
    }

}