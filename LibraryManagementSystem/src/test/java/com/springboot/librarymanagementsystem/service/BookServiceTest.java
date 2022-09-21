package com.springboot.librarymanagementsystem.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.*;

import com.springboot.librarymanagementsystem.exception.ResourceNotFoundException;
import com.springboot.librarymanagementsystem.model.Books_Info;
import com.springboot.librarymanagementsystem.model.User;
import com.springboot.librarymanagementsystem.repository.BookRepository;
import com.springboot.librarymanagementsystem.repository.UserRepository;
import com.springboot.librarymanagementsystem.serviceImpl.BooksInfoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {


    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BooksInfoServiceImpl bookService;

    private Books_Info book;
    @BeforeEach
    public void setUpBook(){
        book= Books_Info.builder().bookId(4L).bookName("Arms and the Man")
                .author("G. V. Desani").bookPublication("Shivani")
                .noOfCopies(10L).totalPages(765L).price(300).build();
    }
    @DisplayName("Junit Test for Save Book")
    @Test
    public void givenBookObject_whenSave_thenReturnBookObject(){
        BDDMockito.given(bookRepository.findById(book.getBookId())).willReturn(Optional.empty());
        BDDMockito.given(bookRepository.save(book)).willReturn(book);
        Books_Info savedBook=bookService.saveBook(4L,book);
        assertThat(savedBook).isNull();
    }
    @DisplayName("Junit Test for Save Book throws an exception")
    @Test
    public void givenBookObject_whenSave_thenThrowException(){
        BDDMockito.given(bookRepository.findById(book.getBookId())).willReturn(Optional.of(book));
        assertThrows(ResourceNotFoundException.class,()->{
            bookService.saveBookInfo(book);
        });
        verify(bookRepository,never()).save(any(Books_Info.class));
    }
    @DisplayName("Junit Test for get All Books")
    @Test
    public void givenBookObject_whenFindAll_thenReturnBookList(){
        BDDMockito.given(bookRepository.findAll()).willReturn(Collections.singletonList(book));
        List<Books_Info>bookList=bookService.getAllBook();
        assertThat(bookList).isNotNull();
        assertThat(bookList.size()).isEqualTo(1);
    }
    @DisplayName("Junit Test for get Book by id")
    @Test
    public void givenBookObject_whenFindById_thenReturnBookObject(){
        BDDMockito.given(bookRepository.findById(book.getBookId())).willReturn(Optional.of(book));
        Books_Info savedBook=bookService.getBookById(book.getBookId());
        assertThat(savedBook).isNotNull();
    }
    @DisplayName("Junit Test for Update Book")
    @Test
    public void givenBookObject_WhenUpdateBook_thenReturnBookObject(){
        BDDMockito.given(bookRepository.save(book)).willReturn(book);
        book.setBookName("Dark Sea");
        book.setTotalPages(900L);
        book.setPrice(500);
        book.setNoOfCopies(50L);
        book.setBookPublication("Sri Publications");


        Books_Info updateBook=bookService.updateBook(book);
        assertThat(updateBook.getBookName()).isEqualTo("Dark Sea");
        assertThat(updateBook.getTotalPages()).isEqualTo(900);
        assertThat(updateBook.getPrice()).isEqualTo(500);
        assertThat(updateBook.getNoOfCopies()).isEqualTo(50);
        assertThat(updateBook.getBookPublication()).isEqualTo("Sri Publications");

    }
    @DisplayName("Junit Test for Deleting a Book")
    @Test
    public void givenBookObject_whenDeleteById_thenReturnNothing(){
        BDDMockito.willDoNothing().given(bookRepository).deleteById(book.getBookId());
        bookService.deleteBookById(book.getBookId());
        verify(bookRepository,times(1)).deleteById(book.getBookId());



    }


}