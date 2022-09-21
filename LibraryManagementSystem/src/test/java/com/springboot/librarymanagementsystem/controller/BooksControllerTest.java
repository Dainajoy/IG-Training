package com.springboot.librarymanagementsystem.controller;


import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.springboot.librarymanagementsystem.model.Books_Info;
import com.springboot.librarymanagementsystem.service.BooksInfoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = BooksController.class)
public class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BooksInfoService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    private Books_Info book;


    @DisplayName("Junit test for creating new book using rest api")
    @Test
    public void givenBookObject_whenInsertbook_thenReturnSavedBook() throws Exception{
        Books_Info book = Books_Info.builder()
                .activeFlag(1).author("Rajesh Talwar").price(799).bookName("The Boy Who Wrote a Constitution")
                .noOfCopies(10L)
                .build();
        BDDMockito.given(bookService.saveBook(1L,book)).willReturn(book);

        ResultActions response = mockMvc.perform(post("/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));
        response.andExpect(status().isCreated()).
                andDo(print());

    }

    @DisplayName("Junit test for get all books using rest api")
    @Test
    public void givenBookObjectList_whenGetAllUser_thenReturnBookList() throws Exception {
        List<Books_Info> bookList = new ArrayList<>();
        bookList.add(Books_Info.builder().bookId(1L)
                .activeFlag(1).author("Rajesh Talwar").price(799).bookName("The Boy Who Wrote a Constitution")
                .noOfCopies(10l)
                .build());
        bookList.add(Books_Info.builder().bookId(2L)
                .activeFlag(1).author("Bimal Jalal").price(500).bookName("The India Story")
                .noOfCopies(10L)
                .build());
        BDDMockito.given(bookService.getAllBook()).willReturn(bookList);
        ResultActions response = mockMvc.perform(get("/getAllBook"));
        response.andExpect(status().isOk());
    }

    @DisplayName("Junit test for get book by book name using rest api")
    @Test
    public void givenBookObject_whenGetbyName_thenReturnBookObject() throws Exception {
        Books_Info book = Books_Info.builder()
                .activeFlag(1).author("G. V. Desani").price(300).bookName("Arms and the Man")
                .noOfCopies(10L)
                .build();
        BDDMockito.given(bookService.findBookByBook_Name("Arms and the Man")).willReturn((List<Books_Info>) book);
        ResultActions response = mockMvc.perform(get("/BookByName/Arms and the Man", book.getBookName()));
        response.andExpect(status().isOk()).andDo(print());

    }
    @DisplayName("Junit test for get book by author name using rest api")
    @Test
    public void givenBookObject_whenGetbyAuthor_thenReturnBookObject() throws Exception {
        Books_Info book = Books_Info.builder()
                .activeFlag(1).author("G. V. Desani").price(300).bookName("Arms and the Man")
                .noOfCopies(10L)
                .build();
        BDDMockito.given(bookService.getsBookByAuthorName("G. V. Desani")).willReturn((List<Books_Info>) book);
        ResultActions response = mockMvc.perform(get("/BookByAuthorName/G. V. Desani", book.getAuthor()));
        response.andExpect(status().isOk()).andDo(print());

    }

    @DisplayName("Junit test for get book by publication name using rest api")
    @Test
    public void givenBookObject_whenGetbyPublication_thenReturnBookObject() throws Exception {
        Books_Info book = Books_Info.builder()
                .activeFlag(1).author("G. V. Desani").price(300).bookName("Arms and the Man").
                  bookPublication("Penguin")
                .noOfCopies(10L)
                .build();
        BDDMockito.given(bookService.getsBookByPublication("Shivani")).willReturn((List<Books_Info>) book);
        ResultActions response = mockMvc.perform(get("/BookByPublication/Shivani", book.getAuthor()));
        response.andExpect(status().isOk()).andDo(print());
    }
    @DisplayName("Junit test for updating book using rest api")
    @Test
    public void givenBookObject_ToUpdateBookData_thenReturnBookObject() throws Exception {
        Books_Info savedbook = Books_Info.builder().bookId(4L)
                .activeFlag(1).author("G. V. Desani").price(300).bookName("Arms and the Man")
                .bookPublication("Shivani")
                .noOfCopies(10L)
                .build();
        Books_Info updatedbook = Books_Info.builder().bookId(4L)
                .activeFlag(1).author("G. V. Desani").price(300).bookName("Arms and the Man").
                bookPublication("Shankar")
                .noOfCopies(10L)
                .build();
        BDDMockito.given(bookService.getBookById(1l)).willReturn(savedbook);
        BDDMockito.given(bookService.updateBook(updatedbook)).willReturn(updatedbook);
        ResultActions response = mockMvc.perform(put("/updateBook", 1L));
        response.andExpect(status().isOk()).andDo(print());
    }

    @DisplayName("Junit test for deleteing book using rest api")
    @Test
    public void givenBookObject_ToDeleteBookData_thenReturnBookObject() throws Exception {
        Books_Info book = Books_Info.builder().bookId(1L)
                .activeFlag(1).author("G. V. Desani").price(300).bookName("Arms and the Man")
                .bookPublication("Shivani")
                .noOfCopies(10L)
                .build();
        BDDMockito.given(bookService.deleteBook(book.getBookName(),1L)).willReturn(book);
        ResultActions response = mockMvc.perform(delete("/deleteBookByName/Arms and the Man/1", book.getBookId()));
        response.andExpect(status().isOk()).andDo(print());
    }
}
