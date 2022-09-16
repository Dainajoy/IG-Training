package com.springboot.librarymanagementsystem.serviceImpl;

import com.springboot.librarymanagementsystem.model.BookIssuedTransaction_Info;
import com.springboot.librarymanagementsystem.model.Books_Info;
import com.springboot.librarymanagementsystem.model.User;
import com.springboot.librarymanagementsystem.repository.BookIssueRepository;
import com.springboot.librarymanagementsystem.repository.BookRepository;
import com.springboot.librarymanagementsystem.repository.UserRepository;
import com.springboot.librarymanagementsystem.service.BookIssuedTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookIssuedTransactionServiceImpl implements BookIssuedTransactionService {
    private static final Logger log = LoggerFactory.getLogger(BookIssuedTransactionServiceImpl.class);

    @Autowired
    private BookIssueRepository bookTransactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public BookIssuedTransaction_Info saveTransaction(BookIssuedTransaction_Info bookIssuedTransaction, long userId, long bookId, long libId){
        log.info("Book issued service called for save transaction.");
        User user = userRepository.findById(userId).get();
        User librId = userRepository.findById(libId).get();
        Books_Info book = bookRepository.findById(bookId).get();
        bookIssuedTransaction.setBookId(book);
        bookIssuedTransaction.setIssued_To(user);
        bookIssuedTransaction.setIssued_By(user);
        bookIssuedTransaction.setModifiedBy(user);
        bookIssuedTransaction.setCreatedBy(librId);
        bookIssuedTransaction.setUserId(user);
        return bookTransactionRepository.save(bookIssuedTransaction);
    }

    public List<BookIssuedTransaction_Info> findAllBookIssue(){
        log.info("Book issued service called for fetching all transaction.");
        return bookTransactionRepository.findAll();
    }

    public Optional<BookIssuedTransaction_Info> findTransactionByTransactionId(Long id){
        log.info("Book issued service called for finding transaction by id.");
        return bookTransactionRepository.findById(id);
    }

    public List<BookIssuedTransaction_Info> findTransactionByStatus(String name){
        log.info("Book issued service called for finding transaction by name.");
        return bookTransactionRepository.findBytransactionStatus(name);
    }

    public BookIssuedTransaction_Info updateTransaction(BookIssuedTransaction_Info bookIssuedTransaction) {
        log.info("Book issued service called for updating transaction.");
        BookIssuedTransaction_Info existingProduct = bookTransactionRepository.findById(bookIssuedTransaction.getTransactionId()).orElse(null);
        existingProduct.setBookActualreturndate(bookIssuedTransaction.getBookActualreturndate());
        existingProduct.setBookIssueddate(bookIssuedTransaction.getBookIssueddate());
        existingProduct.setBookReturneddate(bookIssuedTransaction.getBookReturneddate());
        existingProduct.setCreatedOn(bookIssuedTransaction.getCreatedOn());
        existingProduct.setIssued_By(bookIssuedTransaction.getIssued_By());
        existingProduct.setRemarks(bookIssuedTransaction.getRemarks());
        existingProduct.setTransactionStatus(bookIssuedTransaction.getTransactionStatus());
        existingProduct.setIssued_To(bookIssuedTransaction.getIssued_To());
        existingProduct.setUserId(bookIssuedTransaction.getUserId());
        existingProduct.setBookId(bookIssuedTransaction.getBookId());
        existingProduct.setCreatedBy(bookIssuedTransaction.getCreatedBy());
        existingProduct.setModifiedBy(bookIssuedTransaction.getModifiedBy());
        existingProduct.setModifiedon(bookIssuedTransaction.getModifiedon());
        return bookTransactionRepository.save(existingProduct);
    }
}
