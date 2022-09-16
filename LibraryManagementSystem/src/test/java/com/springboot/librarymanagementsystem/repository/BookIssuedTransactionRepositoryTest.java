package com.springboot.librarymanagementsystem.repository;

import static org.assertj.core.api.Assertions.assertThat;


import com.springboot.librarymanagementsystem.model.BookIssuedTransaction_Info;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookIssuedTransactionRepositoryTest {

    @Autowired
    private BookIssueRepository bookIssuedTransactionRepository;

    private BookIssuedTransaction_Info bookIssuedTransaction;

    @BeforeEach
    public void setUp() {
        bookIssuedTransaction = BookIssuedTransaction_Info.builder().remarks("Approved").
                transactionStatus("Transaction Approved").build();
    }

    @DisplayName("Junit test for save data in book transaction.")
    @Test
    public void givenBookIssuedObject_whenFindAll_thenReturnBookList() {
        bookIssuedTransactionRepository.save(bookIssuedTransaction);
        BookIssuedTransaction_Info book = bookIssuedTransactionRepository.
                findById(bookIssuedTransaction.getTransactionId()).get();
        assertThat(book).isNotNull();
    }

    @DisplayName("Junit Test for get All Transaction.")
    @Test
    public void givenBookListObject_whenFindAll_thenReturnBookList() {
        bookIssuedTransactionRepository.save(bookIssuedTransaction);
        List<BookIssuedTransaction_Info> transactionList = bookIssuedTransactionRepository.findAll();
        assertThat(transactionList).isNotNull();
        assertThat(transactionList.size()).isGreaterThanOrEqualTo(6);
    }

    @DisplayName("Junit test for getting all transaction by transaction id.")
    @Test
    public void givenUserObject_whenFindById_thenReturnUser() {
        bookIssuedTransactionRepository.save(bookIssuedTransaction);
        BookIssuedTransaction_Info savedTransaction = bookIssuedTransactionRepository.findById(bookIssuedTransaction.getTransactionId()).get();
        assertThat(savedTransaction).isNotNull();
    }

    @DisplayName("Junit test for getting all transaction by status.")
    @Test
    public void givenUserObject_whenFindByName_thenReturnUser() {
        bookIssuedTransactionRepository.save(bookIssuedTransaction);
        List<BookIssuedTransaction_Info> savedUser = bookIssuedTransactionRepository.findBytransactionStatus(bookIssuedTransaction.getTransactionStatus());
        assertThat(savedUser).isNotNull();
    }

    @DisplayName("Junit test for updating transaction.")
    @Test
    public void givenUserObject_whenUpdate_thenReturnUser() {
        bookIssuedTransactionRepository.save(bookIssuedTransaction);
        BookIssuedTransaction_Info savedTransaction = bookIssuedTransactionRepository.findById(bookIssuedTransaction.getTransactionId()).get();
        savedTransaction.setRemarks("Rejected");
        savedTransaction.setTransactionStatus("Book is not available");
        BookIssuedTransaction_Info bookUpdated = bookIssuedTransactionRepository.save(savedTransaction);
        assertThat(bookUpdated.getRemarks()).isEqualTo("Rejected");
        assertThat(bookUpdated.getTransactionStatus()).isEqualTo("Book is not available");
    }

}

