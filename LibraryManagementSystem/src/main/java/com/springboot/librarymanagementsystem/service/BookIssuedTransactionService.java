package com.springboot.librarymanagementsystem.service;

import com.springboot.librarymanagementsystem.model.BookIssuedTransaction_Info;
import com.springboot.librarymanagementsystem.model.Books_Info;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BookIssuedTransactionService {
    public BookIssuedTransaction_Info saveTransaction(BookIssuedTransaction_Info bookIssuedTransaction, long userId, long bookId, long libId);

    public List<BookIssuedTransaction_Info> findAllBookIssue();

    public Optional<BookIssuedTransaction_Info> findTransactionByTransactionId(Long id);

    public List<BookIssuedTransaction_Info> findTransactionByStatus(String name);

    public BookIssuedTransaction_Info updateTransaction(BookIssuedTransaction_Info bookIssuedTransaction);
        Optional<BookIssuedTransaction_Info> getBookIssueById(Long transactionId);


}
