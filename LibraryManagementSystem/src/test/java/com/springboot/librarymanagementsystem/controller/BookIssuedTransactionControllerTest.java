package com.springboot.librarymanagementsystem.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.springboot.librarymanagementsystem.model.BookIssuedTransaction_Info;
import com.springboot.librarymanagementsystem.model.Books_Info;
import com.springboot.librarymanagementsystem.repository.BookIssueRepository;
import com.springboot.librarymanagementsystem.serviceImpl.BookIssuedTransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = BookIssuedTransactionController.class)
public class BookIssuedTransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookIssuedTransactionServiceImpl bookIssueService;

    @Mock
    private BookIssueRepository bookIssueRepository;
    @Autowired
    private ObjectMapper objectMapper;

    private BookIssuedTransaction_Info bookIssue;
    @BeforeEach
    public void setupBookIssue() {
        bookIssue = bookIssue.builder().bookIssueddate(new Date()).transactionStatus("Approved").remarks("Book Issued").build();
    }


    @DisplayName("Junit test for creating new bookIssue Transaction using rest api")
    @Test
    public void givenBookIssuedObject_whenInsertBookIssued_thenReturnSavedTransaction() throws Exception {
        BookIssuedTransaction_Info bookIssuedTransaction = BookIssuedTransaction_Info.builder().remarks("Approved").
                transactionStatus("Transaction Approved").build();
        BDDMockito.given(bookIssueService.saveTransaction(bookIssuedTransaction, 2L, 1l, 1L)).willAnswer(invocation -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/Transaction/1/1/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookIssuedTransaction)));
        response.andDo(print()).
                andExpect(status().isCreated());

    }

    @DisplayName("Junit test for geting all transaction using rest api")
    @Test
    public void givenBookObjectList_whenGetAllUser_thenReturnBookList() throws Exception {
        List<BookIssuedTransaction_Info> transactionList = new ArrayList<>();
        transactionList.add(BookIssuedTransaction_Info.builder().remarks("Approved").
                transactionStatus("Transaction Approved").build());
        transactionList.add(BookIssuedTransaction_Info.builder().remarks("Rejected").
                transactionStatus("Transaction Approved").build());
        BDDMockito.given(bookIssueService.findAllBookIssue()).willReturn(transactionList);
        ResultActions response = mockMvc.perform(get("/getAllTransaction"));
        response.andExpect(status().isOk());
    }

    @DisplayName("Junit test for get transaction by transaction id using rest api")
    @Test
    public void givenBookObject_whenGetbyName_thenReturnBookObject() throws Exception {
        BookIssuedTransaction_Info bookIssuedTransaction = BookIssuedTransaction_Info.builder().transactionId(1L).remarks("Approved").
                transactionStatus("Transaction Approved").build();
        BDDMockito.given(bookIssueService.findTransactionByTransactionId(1L)).willReturn(Optional.of(bookIssuedTransaction));
        ResultActions response = mockMvc.perform(get("/getTransactionByTransactionId/1", bookIssuedTransaction.getTransactionId()));
        response.andExpect(status().isOk()).andDo(print());
    }

    @DisplayName("Junit test for get transaction by transaction status using rest api")
    @Test
    public void givenBookObject_whenGetbyStatus_thenReturnBookObject() throws Exception {
        BookIssuedTransaction_Info bookIssuedTransaction = BookIssuedTransaction_Info.builder().transactionId(1L).remarks("Approved").
                transactionStatus("Transaction Approved").build();


        ResultActions response = mockMvc.perform(get("/getTransactionByStatus/Approved", bookIssuedTransaction.getTransactionId()));
        response.andExpect(status().isOk()).andDo(print());
        BDDMockito.lenient().when(bookIssueService.findTransactionByStatus("Approved")).
                thenReturn((List<BookIssuedTransaction_Info>) bookIssuedTransaction);
    }

    @DisplayName("Junit test for get book issue by transaction id")
    @Test
    public void givenBookIssue_whenFindById_thenReturnBookIssue() {
        BDDMockito.given(bookIssueRepository.findById(bookIssue.getTransactionId())).willReturn(Optional.of(bookIssue));
        BookIssuedTransaction_Info savedBookIssue = bookIssueService.getBookIssueById(bookIssue.getTransactionId()).get();
        assertThat(savedBookIssue).isNotNull();
    }


}

